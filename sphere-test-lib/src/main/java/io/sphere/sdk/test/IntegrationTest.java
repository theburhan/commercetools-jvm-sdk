package io.sphere.sdk.test;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import io.sphere.sdk.client.*;
import io.sphere.sdk.http.AsyncHttpClientAdapter;
import io.sphere.sdk.http.HttpClient;
import io.sphere.sdk.queries.Query;
import org.junit.BeforeClass;
import org.slf4j.LoggerFactory;

public abstract class IntegrationTest {

    private static TestClient client;

    public static void setupClient() {
        if (client == null) {
            final SphereClientConfig config = getSphereClientConfig();
            final HttpClient httpClient = newHttpClient();
            final SphereAccessTokenSupplier tokenSupplier = SphereAccessTokenSupplier.ofAutoRefresh(config, httpClient, false);
            final SphereClient underlying = SphereClient.of(config, httpClient, tokenSupplier);
            client = new TestClient(withMaybeDeprecationWarnTool(underlying));
        }
    }

    protected static TestClient client() {
        return client;
    }

    protected static SphereClient sphereClient() {
        return client().getUnderlying();
    }

    private static SphereClient withMaybeDeprecationWarnTool(final SphereClient underlying) {
        if ("false".equals(System.getenv("JVM_SDK_IT_DEPRECATION"))) {
            LoggerFactory.getLogger(IntegrationTest.class).info("Deprecation client deactivated.");
            return underlying;
        } else {
            return DeprecationExceptionSphereClientDecorator.of(underlying);
        }
    }

    protected static HttpClient newHttpClient() {
        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient(new AsyncHttpClientConfig.Builder().setAcceptAnyCertificate(true).build());
        return AsyncHttpClientAdapter.of(asyncHttpClient);
    }

    public static SphereClientConfig getSphereClientConfig() {
        return SphereClientConfig.ofEnvironmentVariables("JVM_SDK_IT");
    }

    protected static <T> T execute(final SphereRequest<T> sphereRequest) {
        try {
            return client().execute(sphereRequest);
        } catch (final TestClientException e) {
            if (e.getCause() != null && e.getCause() instanceof RuntimeException) {
                throw (RuntimeException) e.getCause();
            } else {
                throw e;
            }
        }
    }

    public synchronized static void shutdownClient() {
        if (client != null) {
            client.close();
            client = null;
        }
    }

    protected static <T> T getOrCreate(final SphereRequest<T> createCommand, final Query<T> query) {
        return execute(query).head().orElseGet(() -> execute(createCommand));
    }
}

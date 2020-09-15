package io.sphere.sdk.orders.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sphere.sdk.messages.GenericMessageImpl;
import io.sphere.sdk.messages.MessageDerivateHint;
import io.sphere.sdk.messages.UserProvidedIdentifiers;
import io.sphere.sdk.models.KeyReference;
import io.sphere.sdk.orders.Order;
import io.sphere.sdk.stores.Store;

import java.time.ZonedDateTime;

@JsonDeserialize(as = OrderStoreSetMessage.class)//important to override annotation in Message class
public final class OrderStoreSetMessage extends GenericMessageImpl<Order> implements SimpleOrderMessage {

    public static final String MESSAGE_TYPE = "OrderStoreSet";
    public static final MessageDerivateHint<OrderStoreSetMessage> MESSAGE_HINT =
            MessageDerivateHint.ofSingleMessageType(MESSAGE_TYPE, OrderStoreSetMessage.class, Order.referenceTypeId());

    private final KeyReference<Store> store;

    @JsonCreator
    private OrderStoreSetMessage(final String id, final Long version, final ZonedDateTime createdAt, final ZonedDateTime lastModifiedAt, final JsonNode resource, final Long sequenceNumber, final Long resourceVersion, final String type, final UserProvidedIdentifiers resourceUserProvidedIdentifiers,
                                 final KeyReference<Store> store) {
        super(id, version, createdAt, lastModifiedAt, resource, sequenceNumber, resourceVersion, type,resourceUserProvidedIdentifiers, Order.class);
        this.store = store;
    }

    public KeyReference<Store> getStore() {
        return store;
    }
}

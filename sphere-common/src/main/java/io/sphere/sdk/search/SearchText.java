package io.sphere.sdk.search;

import io.sphere.sdk.models.Base;

import java.util.Locale;

import static java.util.Objects.requireNonNull;

public class SearchText extends Base {
    private final Locale locale;
    private final String text;

    SearchText(final Locale locale, final String text) {
        this.locale = requireNonNull(locale);
        this.text = requireNonNull(text);
    }

    public Locale getLocale() {
        return locale;
    }

    public String getText() {
        return text;
    }

    public static SearchText of(final Locale locale, final String text) {
        return new SearchText(locale, text);
    }
}

package com.github.gomboshkr.utils;

/**
 * @author Kristian Gombosh
 */
public final class ApplicationProperties {
    public static final String BROWSER = System.getProperty("browser", "Chrome");
    public static final String BASE_URL = System.getProperty("base.url", "https://www.google.com/");

    private ApplicationProperties() {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}

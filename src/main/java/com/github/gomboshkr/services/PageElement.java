package com.github.gomboshkr.services;

import java.util.function.Consumer;

import lombok.Data;
import org.openqa.selenium.By;

import static java.util.Objects.requireNonNull;

/**
 * @author Kristian Gombosh
 */
@Data
public class PageElement {
    private String name;
    private By locator;
    private boolean required;

    public PageElement(final String name, final By locator, final boolean required) {
        this.name = name;
        this.locator = locator;
        this.required = required;
    }

    public PageElement(final String name, final By locator) {
        this(name, locator, false);
    }

}

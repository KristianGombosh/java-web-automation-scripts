package com.github.gomboshkr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.gomboshkr.services.AbstractServicePage;
import com.github.gomboshkr.services.PageElement;

/**
 * @author Kristian Gombosh
 */
public class GoogleSearchPage extends AbstractServicePage {
    private static final PageElement TITLE = new PageElement(
            "Title of the Google page",
            By.id("hplogo"),
            true);
    private static final PageElement SEARCH_FIELD = new PageElement(
            "Search field on the Google page",
            By.xpath(".//div[@class='RNNXgb']//input"),
            true);

    public GoogleSearchPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public void searchResult(String searchWord) {
        waitToBeVisible(TITLE);
        enterText(SEARCH_FIELD,searchWord);
        pressEnter(SEARCH_FIELD);
    }
}

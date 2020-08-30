package com.github.gomboshkr.pages;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.gomboshkr.services.AbstractServicePage;
import com.github.gomboshkr.services.PageElement;

/**
 * @author Kristian Gombosh
 */
public class ResultSearchPage extends AbstractServicePage {
    private static final PageElement TITLE = new PageElement(
            "Title in Search Result Page",
            By.xpath("(//title)[1]"),
            true);
    public ResultSearchPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed() {
        return allRequiredElementDisplayed();
    }

    public String searchResult() {
        waitToBeVisible(TITLE);
        String actual = getTabText();
        String replacedActualTxt = actual.replaceAll("([ ][-].*)", "");
        return replacedActualTxt;
    }
}

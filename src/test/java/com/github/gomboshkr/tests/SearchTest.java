package com.github.gomboshkr.tests;

import com.devskiller.jfairy.Fairy;
import org.testng.annotations.Test;

import java.util.Locale;

/**
 * @author Kristian Gombosh
 */
public class SearchTest extends BaseTest {
    private final static Fairy FAIRY = Fairy.create(Locale.US);

    @Test(description = "Search words in Google")
    public void searchWordsInGoogle() {
        String testWord = FAIRY.textProducer().word();
        googleSearchPage.searchResult(testWord);
        assertThat(resultSearchPage.searchResult())
                .as("Title result words should be the same with entered words")
                .isEqualTo(testWord);
    }
}

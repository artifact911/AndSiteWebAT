package com.andersenlab.autotests.site.page.industries.healthcare.blocks.differencemodule;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DifferenceBlock{
    protected DifferenceLocators locators = new DifferenceLocators();

    private final SelenideElement title = $(locators.getTITLE());
    private final ElementsCollection cardImg = $$(locators.getDIFFERENCE_CARD_IMG());
    private final ElementsCollection cardTxt = $$(locators.getDIFFERENCE_CARD_TXT());
    private final ElementsCollection listTxt = $$(locators.getDIFFERENCE_LIST_TXT());

    private final String expectedTitle;
    private final List<List<String>> expectedCards;
    private final List<List<String>> expectedList;


    public DifferenceBlock(List<List<String>> header, List<List<String>> cards, List<List<String>> list){
        this.expectedTitle = header.get(0).get(1);
        this.expectedCards = cards;
        this.expectedList = list;
    }

    @Step
    public void checkTitle(){
        Assert.assertEquals(title.getText(), expectedTitle);
    }

    @Step
    public void checkCards(){
        for (int index=0; index<cardImg.size(); index++){
            Assert.assertTrue(cardImg.get(index).getAttribute("xlink:href").contains(expectedCards.get(index).get(0)));
            Assert.assertEquals(cardTxt.get(index).getText(), expectedCards.get(index).get(1));
        }
    }

    @Step
    public void checkList(){
        for (int index=0; index<listTxt.size(); index++){
            Assert.assertEquals(listTxt.get(index).getText(), expectedList.get(index).get(1));
        }
    }
}

package com.andersenlab.autotests.site.page.techstack.calculators;

import com.andersenlab.autotests.site.page.services.augmentation.calculator.Calculator;
import com.andersenlab.autotests.site.page.services.augmentation.calculator.CalculatorLocators;
import com.codeborne.selenide.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalculatorsFindDevelopers extends Calculator implements CalculatorLocators {

    protected ElementsCollection checkBoxes = $$(By.xpath("//div[contains(@class, 'checkbox-module--title')]"));
    protected SelenideElement popUpText = $(By.xpath("//div[contains(@class, 'themeFiltered')]"));
    protected ElementsCollection radioButtons = $$(By.xpath("//div[contains(@class, 'radioButton-module--title')]"));


    @Override
    @Step
    public void checkYourDevelopmentTeamBlock() {
        checkClPointers();
        checkToolTips();
        checkAdditionButtonFirstBlock();
        checkReduceButtonFirstBlock();
    }

    @Step
    public void checkAdditionalServicesBlock (){
        int index = 0;
        for (AdditionalServices enu: AdditionalServices.values()){
            moveAndClick(checkBoxes.get(index));
            popUpText.shouldBe(Condition.visible).shouldHave(Condition.exactText(enu.getText()));
            moveAndClick(popUpText);
            popUpText.shouldBe(Condition.hidden);
            index++;
        }
    }

    @Override
    @Step
    public void checkBusinessIndustryBlock(){
        int index = 0;
        for(Industries enu:Industries.values()){
            moveAndClick(radioButtons.get(index));
            popUpText.shouldBe(Condition.visible).shouldHave(Condition.exactText(enu.getText()));
            moveAndClick(popUpText);
            popUpText.shouldBe(Condition.hidden);
            index++;
        }
    }

    @Step
    public void checkGetPriceButton (){
        super.checkGetPriceButton();
    }

    @Override
    @Step
    public void checkSendFormBlock() {
        checkToolTipNearSendFormButton();
        checkRecapthaRefs();
    }
}

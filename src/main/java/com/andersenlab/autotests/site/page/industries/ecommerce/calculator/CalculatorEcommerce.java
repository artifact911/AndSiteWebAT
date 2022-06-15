package com.andersenlab.autotests.site.page.industries.ecommerce.calculator;

import com.andersenlab.autotests.site.page.techstack.calculators.CalculatorsFindDevelopers;
import com.andersenlab.autotests.site.page.services.augmentation.calculator.CalculatorLocators;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalculatorEcommerce extends CalculatorsFindDevelopers implements CalculatorLocators {

    protected ElementsCollection typeOfBusinessCheckBoxes = $$(By.xpath("//p[contains(text(), 'Select type of business')]/../following-sibling::div//label/div"));
    protected ElementsCollection revenueModelCheckBoxes = $$(By.xpath("//p[contains(text(), 'Select revenue model')]/../following-sibling::div//label/div"));
    protected ElementsCollection selectServiceCheckBoxes = $$(By.xpath("//p[contains(text(), 'Select services')]/../following-sibling::div//label/div"));
    protected ElementsCollection selectOtherServiceCheckBoxes = $$(By.xpath("//p[contains(text(), 'Select other services')]/../following-sibling::div//label/div"));
    protected SelenideElement defaultValueOfSlider = $(By.xpath("//div[@class='rc-slider-step']/span[@style='left: 20%;']"));
    protected SelenideElement twentyTillFiftyValueOfSlider = $(By.xpath("//div[@class='rc-slider-step']/span[@style='left: 40%;']"));
    protected String activePhaseOfSlider = "rc-slider-dot rc-slider-dot-active";

    @Step
    public void checkTypeOfBusinessBlock() {
        int index = 0;
        for (TypeOfIndustries enu : TypeOfIndustries.values()) {
            moveAndClick(typeOfBusinessCheckBoxes.get(index));
            popUpText.shouldBe(Condition.visible).shouldHave(Condition.exactText(enu.getText()));
            moveAndClick(popUpText);
            popUpText.shouldBe(Condition.hidden);
            index++;
        }
    }

    @Step
    public void checkRevenueModelBlock() {
        int index = 0;
        for (RevenueModels enu : RevenueModels.values()) {
            moveAndClick(revenueModelCheckBoxes.get(index));
            popUpText.shouldBe(Condition.visible).shouldHave(Condition.exactText(enu.getText()));
            moveAndClick(popUpText);
            popUpText.shouldBe(Condition.hidden);
            index++;
        }
    }

    @Step
    public void checkServicesSelectionBlock() {
        int index = 0;
        for (SelectServices enu : SelectServices.values()) {
            moveAndClick(selectServiceCheckBoxes.get(index));
            popUpText.shouldBe(Condition.visible).shouldHave(Condition.exactText(enu.getText()));
            moveAndClick(popUpText);
            popUpText.shouldBe(Condition.hidden);
            index++;
        }
    }

    @Step
    public void checkOtherServicesSelectionBlock() {
        int index = 0;
        for (SelectOtherServices enu : SelectOtherServices.values()) {
            moveAndClick(selectOtherServiceCheckBoxes.get(index));
            popUpText.shouldBe(Condition.visible).shouldHave(Condition.exactText(enu.getText()));
            moveAndClick(popUpText);
            popUpText.shouldBe(Condition.hidden);
            index++;
        }
    }

    @Step
    public void checkBudgetEstimationBlock() {
        defaultValueOfSlider.shouldHave(Condition.attribute("class", activePhaseOfSlider));
        moveAndClick(twentyTillFiftyValueOfSlider);
        popUpText.shouldHave(Condition.exactText("25-50K"));
        moveAndClick(popUpText);
    }

    @Step
    public void checkGetPriceButton() {
        super.checkGetPriceButton();
    }

    @Step
    public void checkSendFormBlock (){
        super.checkSendFormBlock();
    }
}

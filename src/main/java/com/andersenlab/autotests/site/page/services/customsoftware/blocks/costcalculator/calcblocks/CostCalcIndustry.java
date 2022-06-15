package com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks;

import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class CostCalcIndustry implements ToBottomScrollable{
    private final String RB_UNCHECKED_B_COLOR = "rgb(224, 224, 224)";
    private final String RB_CHECKED_B_COLOR = "rgb(254, 218, 0)";
    private final String[] itemNames = {
            "Financial Services",
            "eCommerce",
            "Travel & Hospitality",
            "Telecom",
            "Video & Entertainment",
            "Enterprise",
            "Real Estate",
            "Healthcare",
            "iGaming",
            "Logistics",
            "eLearning",
            "Retail"
    };
    private final String BASE = "//p[contains(text(), 'Business industry')]//..//..";
    private final By RADIO_BUTTONS = By.xpath(BASE + "//label[contains(@class, 'radioBtn')]/span");
    private final By TITLE = By.xpath(BASE + "//header/p[contains(@class, 'title')]");


    private ElementsCollection RadioButtons = $$(RADIO_BUTTONS);
    private SelenideElement title = $(TITLE);

    public void scrollToBottom(){
        scrollToBottom(BASE);
    }


    @Step
    public String sectionTitle() {
        return title.getAttribute("innerText");
    }

    @Step
    public String checkUnit(int index) {
        if(index > 11 || index < 0) throw new IllegalArgumentException("BAD INDEX");
        RadioButtons.get(index).click();
        return itemNames[index];
    }

    @Step
    public void behaviourBlock() {
        scrollToBottom(BASE);
        int checkedIndex = Warp.randomInt(11);
        Assert.assertTrue(Warp.isElementPresent(TITLE));
        Assertions.mouseIsPointer(RadioButtons.get(checkedIndex));
        Assert.assertEquals(RadioButtons.get(checkedIndex).getCssValue("border-color"), RB_UNCHECKED_B_COLOR);
        RadioButtons.get(checkedIndex).click();
        Assert.assertEquals(RadioButtons.get(checkedIndex).getCssValue("border-color"), RB_CHECKED_B_COLOR);
        PanelPopUp panel = new PanelPopUp();
        Assert.assertEquals(panel.getChosenUnits().size(), 1);
        (panel.getChosenUnits().first()).click();
        Assert.assertEquals(RadioButtons.get(checkedIndex).getCssValue("border-color"), RB_UNCHECKED_B_COLOR);
        panel.close();
        RadioButtons.get(checkedIndex).click();
        for (int i = 0; i < 12; i++) {
            if(i != checkedIndex) Assert.assertEquals(RadioButtons.get(i).getCssValue("border-color"), RB_UNCHECKED_B_COLOR);
            else Assert.assertEquals(RadioButtons.get(i).getCssValue("border-color"), RB_CHECKED_B_COLOR);
        }
    }
}

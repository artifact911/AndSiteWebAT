package com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap.ProjectMap;
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
public class CostCalcTimeBar implements ToBottomScrollable{
    private String BASE;

    private By TITLE;
    private By STRAIGHTEDGE_STEPS;
    private By DISCOUNT;
    private By DURATION;


    private SelenideElement title;
    private ElementsCollection straightedgeSteps;
    private SelenideElement discount;
    private SelenideElement duration;

    private final String DISCOUNT_1 = "Your discount is 5%";
    private final String DISCOUNT_2 = "Your discount is 7%";
    private final String TEXT_TITLE = " Duration of Your Project";

    public CostCalcTimeBar(String BASE) {
        this.BASE = BASE;
        calc();
    }

    private void calc() {
        TITLE = By.xpath(BASE + "//h3");
        STRAIGHTEDGE_STEPS = By.xpath(BASE + "//div[@class='ui-slider-grid__item']");
        DISCOUNT = By.xpath(BASE + "//span[@class='ui-slider-helper__row ui-slider-helper__footer']");
        DURATION = By.xpath(BASE + "//span[@id='ui-slider-duration']");

        title = $(TITLE);
        straightedgeSteps = $$(STRAIGHTEDGE_STEPS);
        discount = $(DISCOUNT);
        duration = $(DURATION);
    }

    @Step
    public void behaviourBlock() {
        PanelPopUp panel = new PanelPopUp();

        scrollToBottom(BASE);
        Assert.assertEquals(title.getAttribute("innerText"), TEXT_TITLE);
        Assert.assertEquals(duration.getAttribute("innerText"), "6 months");

        Warp.clickUntouchable(straightedgeSteps.get(5), 0, 0);
        Assert.assertFalse(Warp.elementIsIntractable(discount));
        Assert.assertTrue(Warp.elementIsIntractable(duration));

        Warp.clickUntouchable(straightedgeSteps.get(10), 0, 0);
        Assert.assertTrue(Warp.elementIsIntractable(discount));
        Assert.assertEquals(discount.getAttribute("innerText"), DISCOUNT_1);
        Assert.assertEquals(duration.getAttribute("innerText"), "13 months");
        Assert.assertEquals(panel.getChosenUnits().size(), 1);
        panel.getChosenUnits().first().click();
        Assert.assertTrue(panel.getChosenUnits().isEmpty());
        Assert.assertEquals(duration.getAttribute("innerText"), "6 months");

        Warp.clickUntouchable(straightedgeSteps.last(), 40, 0);
        Assert.assertTrue(Warp.elementIsIntractable(discount));
        Assert.assertEquals(discount.getAttribute("innerText"), DISCOUNT_2);

        panel.close();
    }
}

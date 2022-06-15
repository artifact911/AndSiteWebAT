package com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcCheckBox;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcIndustry;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.PanelPopUp;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;

public class CostCalc {
    private String BASE = "//div[@id='calculator']";

    private CostCalcCheckBox purpose;
    private CostCalcCheckBox request;
    private CostCalcIndustry domain;
    private PanelPopUp pu;
    private CalcPopupGift gift;

    public CostCalc() {
        purpose = new CostCalcCheckBox(BASE + "//section[@data-type='checkbox' and contains(@data-name, 'purpose')]");
        request = new CostCalcCheckBox(BASE + "//section[@data-type='checkbox' and contains(@data-name, 'request')]");
        domain = new CostCalcIndustry();
        pu = new PanelPopUp();
        gift = new CalcPopupGift();
    }


    @Step
    public void request() {
        Selenide.refresh();
        request.scrollToBottom();
        request.behaviourBlock();
    }

    @Step
    public void purpose() {
        Selenide.refresh();
        purpose.scrollToBottom();
        Warp.delay(2);
        purpose.behaviourBlock();
    }

    @Step
    public void domain() {
        Selenide.refresh();
        domain.scrollToBottom();
        domain.behaviourBlock();
        Selenide.refresh();
        String checked = domain.checkUnit(2);
        Assert.assertTrue(pu.isChosenItemPresent(checked));
        checked = domain.checkUnit(5);
        Assert.assertTrue(pu.isChosenItemPresent(checked));
    }

    @Step
    public void popup() {
        Selenide.refresh();
        Warp.scrollToElement(request.getTITLE());

        request.scrollToBottom();
        String unit2 = request.checkUnit(1);

        purpose.scrollToBottom();
        String unit1 = purpose.checkUnit(1);

        domain.scrollToBottom();
        String unit3 = domain.checkUnit(1);

        Assert.assertTrue(pu.isChosenItemPresent(unit1) && pu.isChosenItemPresent(unit2) && pu.isChosenItemPresent(unit3)); //это на панельке

        pu.checkTitle();
        pu.getPricePanel();
        Assert.assertTrue(pu.isChosenItemPresent(unit1) && pu.isChosenItemPresent(unit2) && pu.isChosenItemPresent(unit3));//это в форме запроса

        int chosen = pu.getChosenUnits().size();
        //если экран закрывает всплывающее сообщение "Get a complimentary audit for free"
        if (gift.visible()) {
            gift.close();
        }
        pu.getChosenUnits().first().click();
        Assert.assertEquals(pu.getChosenUnits().size(), --chosen);
        pu.getChosenUnits().first().click();
        pu.getChosenUnits().first().click();
        Assert.assertTrue(pu.getChosenUnits().isEmpty());
        pu.close();//Зарыть форму
        Selenide.refresh();
        Warp.scrollToElement(domain.getTITLE());
        domain.checkUnit(1);
        pu.close();//закрыть панельку
    }
}

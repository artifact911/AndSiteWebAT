package com.andersenlab.autotests.site.page.techstack.mobile.ionic.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcCheckBox;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcIndustry;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcPlusMinus;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.PanelPopUp;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator.CalcPopupGift;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator.GetPriceBtn;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;

public class CostCalc {
    protected final int topCheckedUnit = 0; //Или Warp.randomInt(top.getCounts().size()), но будет избыточно для этого теста;
    protected final int otherCheckedUnit = 0; //Или Warp.randomInt(other.getCounts().size()), но будет избыточно для этого теста;
    protected final int domainCheckedUnit = 0; //Или Warp.randomInt(domain.getItemNames().length), но будет избыточно для этого теста;
    protected final int addServCheckedUnit = 0; //Или Warp.randomInt(addServ.getCheckBoxes().size()), но будет избыточно для этого теста;

    private final CostCalcPlusMinus top;
    private final CostCalcPlusMinus other;
    private final CostCalcIndustry industry;
    private final CostCalcCheckBox addServ;
    private final PanelPopUp panel;
    private final CalcPopupGift gift;
    private final GetPriceBtn getPrice;

    public CostCalc() {
        top = new CostCalcPlusMinus("//h3[contains(text(), 'Top Ionic engineers for your team')]//..//..");
        other = new CostCalcPlusMinus("//h3[contains(text(), 'Other specialists')]//..//..");
        addServ = new CostCalcCheckBox("//h3[contains(text(), 'Additional services')]//..//..");
        industry = new CostCalcIndustry();
        panel = new PanelPopUp();
        gift = new CalcPopupGift();
        getPrice = new GetPriceBtn();
    }

    @Step
    public void setTop() {
        Selenide.refresh();
        top.behaviourBlock();
    }

    @Step
    public void setOther() {
        Selenide.refresh();
        other.behaviourBlock();
    }

    @Step
    public void domain() {
        Selenide.refresh();
        industry.behaviourBlock();

        Selenide.refresh();
        //Выбираем в 3 разделе (Domain/ Business Industry) пункт и проверяем, что он выбран
        String checked = industry.checkUnit(2);
        Assert.assertTrue(panel.isChosenItemPresent(checked));
        //Выбираем в 3 разделе (Domain/ Business Industry) другой пункт и проверяем, что он выбран
        Warp.scrollToElement(addServ.getTITLE());
        checked = industry.checkUnit(5);
        Assert.assertTrue(panel.isChosenItemPresent(checked));
    }

    @Step
    public void setAddServ() {
        Selenide.refresh();
        addServ.behaviourBlock();
    }

    @Step
    public void popup() {
        //обновиться
        Selenide.refresh();
        //чекнуть 1 с первого блока
        Warp.scrollToElement(top.getCOUNTS());
        String unit1 = top.checkUnit(1);
        //чекнуть со 2 блока
        Warp.scrollToElement(addServ.getTITLE());
        String unit2 = industry.checkUnit(1);
        //чекнуть один с 3 блока
        Warp.scrollToElement(panel.getBUTTON_GET_PRICE());
        String unit3 = addServ.checkUnit(1);
        //проверить отображение добавленных юнитов
        Assert.assertTrue(panel.isChosenItemPresent(unit1) && panel.isChosenItemPresent(unit2) && panel.isChosenItemPresent(unit3)); //это на панельке
        //титул панели
        panel.checkTitle();
        //открыть попап кнопкой панели
        panel.getPricePanel();
        //проверить, что те же юниты отобр в попап
        Assert.assertTrue(panel.isChosenItemPresent(unit1) && panel.isChosenItemPresent(unit2) && panel.isChosenItemPresent(unit3));//это в форме запроса
        //покликать по кнопкам выбраных юнитов в поап
        int chosen = panel.getChosenUnits().size();
        //если экран закрывает всплывающее сообщение "Get a complimentary audit for free"
        if (gift.visible()) {
            gift.close();
        }
        panel.getChosenUnits().first().click();
        Assert.assertEquals(panel.getChosenUnits().size(), --chosen);
        panel.getChosenUnits().first().click();
        panel.getChosenUnits().first().click();
        Assert.assertTrue(panel.getChosenUnits().isEmpty());
        panel.close();//Зарыть форму
        //обновиться, проскролить, проверить кнопку закрыть панель
        Selenide.refresh();
        Warp.scrollToElement(industry.getRADIO_BUTTONS());
        industry.checkUnit(1);
        panel.close();//закрыть панельку

    }

    @Step
    public void preparePopup()
    {
        Selenide.refresh();
        Warp.scrollToElement(top.getTITLE());
        top.checkUnit(topCheckedUnit);
        panel.close();
        other.checkUnit(otherCheckedUnit);
        industry.checkUnit(domainCheckedUnit);
        addServ.checkUnit(addServCheckedUnit);
        getPrice.pricePopup();
        if (gift.visible()) {
            gift.close();
        }
    }
}

package com.andersenlab.autotests.site.page.techstack.mobile.mobile.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcCheckBox;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcIndustry;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcPlusMinus;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.PanelPopUp;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator.CalcPopupGift;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator.GetPriceBtn;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.Getter;
import org.testng.Assert;

@Getter
public class CostCalc {
    protected final int topCheckedUnit = 0;
    protected final int domainCheckedUnit = 0;
    protected final int addServCheckedUnit = 0;

    private final CostCalcPlusMinus top;
    private final CostCalcIndustry domain;
    private final CostCalcCheckBox addServ;
    private final PanelPopUp panel;
    private final CalcPopupGift gift;
    private final GetPriceBtn getPrice;


    public CostCalc() {
        top = new CostCalcPlusMinus("//h3[contains(text(), 'Top Mobile developers for your team')]//..//..");
        addServ = new CostCalcCheckBox("//h3[contains(text(), 'Additional services')]//..//..");
        domain = new CostCalcIndustry();
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
    public void domain() {
        Selenide.refresh();
        domain.behaviourBlock();
        Selenide.refresh();
        String checked = domain.checkUnit(2);
        Assert.assertTrue(panel.isChosenItemPresent(checked));
        checked = domain.checkUnit(5);
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
//        Wrap.clickUntouchable(top.getPlus().get(1), 0, 0);
        String unit1 = top.checkUnit(1);
        //чекнуть со 2 блока
        Warp.scrollToElement(addServ.getTITLE());
        String unit2 = domain.checkUnit(1);
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
        panel.getChosenUnits().first().click();
        Assert.assertEquals(panel.getChosenUnits().size(), --chosen);
        panel.getChosenUnits().first().click();
        panel.getChosenUnits().first().click();
        Assert.assertTrue(panel.getChosenUnits().isEmpty());
        panel.close();//Зарыть форму
        //обновиться, проскролить, проверить кнопку закрыть панель
        Selenide.refresh();
        Warp.scrollToElement(domain.getRADIO_BUTTONS());
        domain.checkUnit(1);
        panel.close();//закрыть панельку
    }

    @Step
    public void preparePopup()
    {
        Selenide.refresh();
        Warp.scrollToElement(top.getTITLE());
        top.checkUnit(topCheckedUnit);
        panel.close();
        domain.checkUnit(domainCheckedUnit);
        addServ.checkUnit(addServCheckedUnit);
        getPrice.pricePopup();
        if (gift.visible()) {
            gift.close();
        }
    }
}

package com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.PanelPopUp;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcCheckBox;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcIndustry;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcTimeBar;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;

public class CostCalc {
    private String BASE = "//div[@id='calculator']";

    private CostCalcCheckBox devDir;
    private CostCalcCheckBox proCons;
    private CostCalcIndustry domain;
    private PanelPopUp pu;
    private CostCalcTimeBar timeBar;

    public CostCalc() {
        devDir = new CostCalcCheckBox(BASE + "//section[@data-type='checkbox' and @data-name='development_direction']");
        domain = new CostCalcIndustry();
        proCons = new CostCalcCheckBox(BASE + "//section[@data-type='checkbox' and @data-name='professional_consultation']");
        timeBar = new CostCalcTimeBar(BASE + "//section[@data-name='duration']");
        pu = new PanelPopUp();
    }


    @Step
    public void setDevDir() {
        Selenide.refresh();
        devDir.behaviourBlock();
    }

    @Step
    public void domain() {
        Selenide.refresh();
        domain.behaviourBlock();
        Selenide.refresh();
        String checked = domain.checkUnit(2);
        Assert.assertTrue(pu.isChosenItemPresent(checked));
        checked = domain.checkUnit(5);
        Assert.assertTrue(pu.isChosenItemPresent(checked));
    }

    @Step
    public void setProCons() {
        Selenide.refresh();
        Warp.delay(2);
        proCons.behaviourBlock();
    }

    @Step
    public void setTimeBar() {
        Selenide.refresh();
        Warp.delay(2);
        timeBar.behaviourBlock();
    }

    @Step
    public void popup() {
        //обновиться и проскролиться
        Selenide.refresh();
        Warp.scrollToElement(devDir.getTITLE());
        Warp.scrollToElement(proCons.getCHECKBOXES());
        //чекнуть 1 с первого блока
        String unit2 = devDir.checkUnit(1);
        Warp.scrollToElement(domain.getRADIO_BUTTONS());
        //чекнуть со 2 блока
        String unit1 = domain.checkUnit(1);
        Warp.scrollToElement(timeBar.getSTRAIGHTEDGE_STEPS());
        //чекнуть один с 3 блока
        String unit3 = proCons.checkUnit(1);
        //проверить отображение добавленных юнитов
        Assert.assertTrue(pu.isChosenItemPresent(unit1) && pu.isChosenItemPresent(unit2) && pu.isChosenItemPresent(unit3)); //это на панельке
        //титул панели
        pu.checkTitle();
        //открыть попап кнопкой панели
        pu.getPricePanel();
        //проверить, что те же юниты отобр в попап
        Assert.assertTrue(pu.isChosenItemPresent(unit1) && pu.isChosenItemPresent(unit2) && pu.isChosenItemPresent(unit3));//это в форме запроса
        //покликать по кнопкам выбраных юнитов в поап
        int chosen = pu.getChosenUnits().size();
        pu.getChosenUnits().first().click();
        Assert.assertEquals(pu.getChosenUnits().size(), --chosen);
        pu.getChosenUnits().first().click();
        pu.getChosenUnits().first().click();
        Assert.assertTrue(pu.getChosenUnits().isEmpty());
        pu.close();//Зарыть форму
        //обновиться, проскролить, проверить кнопку закрыть панель
        Selenide.refresh();
        Warp.scrollToElement(domain.getRADIO_BUTTONS());
        domain.checkUnit(1);
        pu.close();//закрыть панельку
        //TODO поиграться с временем
    }
}

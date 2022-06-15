package com.andersenlab.autotests.site.page.services.businessanalysts.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcCheckBox;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcIndustry;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.CostCalcTimeBar;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.PanelPopUp;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;

public class CostCalc {
    private String BASE = "//div[@id='calculator']";

    private CostCalcCheckBox indicator;
    private CostCalcCheckBox selector;
    private CostCalcIndustry domain;
    private PanelPopUp pu;
    private CostCalcTimeBar timeBar;

    public CostCalc() {
        indicator = new CostCalcCheckBox(BASE + "//section[@data-type='checkbox' and @data-name='problems']");
        selector = new CostCalcCheckBox(BASE + "//section[@data-type='checkbox' and @data-name='specialists']");
        domain = new CostCalcIndustry();
        timeBar = new CostCalcTimeBar(BASE + "//section[@data-name='duration']");
        pu = new PanelPopUp();
    }


    @Step
    public void indicateTheProblem() {
        Selenide.refresh();
        indicator.behaviourBlock();
    }

    @Step
    public void selectSpecialist() {
        Selenide.refresh();
        Warp.delay(2);
        selector.behaviourBlock();
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
    public void durationOfProject() {
        Selenide.refresh();
        timeBar.scrollToBottom(BASE + "//section[@data-name='duration']");
        Warp.delay(2);
        timeBar.behaviourBlock();
    }

    @Step
    public void popup() {
        //обновиться и проскролиться
        Selenide.refresh();
        Warp.scrollToElement(indicator.getTITLE());

        //чекнуть 1 с первого блока
        indicator.scrollToBottom();
        String unit1 = indicator.checkUnit(1);

        //чекнуть со 2 блока
        selector.scrollToBottom();
        String unit2 = selector.checkUnit(1);

        //чекнуть один с 3 блока
        domain.scrollToBottom();
        String unit3 = domain.checkUnit(1);
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

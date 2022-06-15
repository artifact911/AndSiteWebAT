package com.andersenlab.autotests.site.page.services.maintenance.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.costcalculator.calcblocks.*;
import com.andersenlab.autotests.site.page.services.salesforce.blocks.costcalculator.CalcPopupGift;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.Assert;

public class CostCalc {
    private String BASE = "//div[@id='calculator']";

    private CostCalcRadioButton volume;
    private CostCalcCheckBox level;
    private CostCalcRadioButton schedule;

    private PanelPopUp pu;
    private CalcPopupGift gift;


    public CostCalc() {
        volume = new CostCalcRadioButton(BASE + "//section[@data-type='radiobutton' and @data-name='support_requests_volume']");
        level = new CostCalcCheckBox(BASE + "//section[@data-type='checkbox' and @data-name='support_level']");
        schedule = new CostCalcRadioButton(BASE + "//section[@data-type='radiobutton' and @data-name='support_schedule']");
        pu = new PanelPopUp();
        gift = new CalcPopupGift();
    }

    @Step
    public void volume() {
        Selenide.refresh();
        volume.behaviourBlock();
    }

    @Step
    public void level() {
        Selenide.refresh();
        Warp.delay(2);
        level.behaviourBlock();
    }

    @Step
    public void schedule() {
        Selenide.refresh();
        schedule.scrollToBottom();
        Warp.delay(2);
        schedule.behaviourBlock();
    }

    @Step
    public void popup() {
        //обновиться и проскролиться
        Selenide.refresh();
        Warp.scrollToElement(volume.getTITLE());
        //чекнуть 1 с первого блока
        //Warp.scrollToElement(level.getCHECKBOXES());
        volume.scrollToBottom();
        String unit1 = volume.checkUnit(1);
        //чекнуть со 2 блока
        //Warp.scrollToElement(schedule.getRADIO_BUTTONS());
        level.scrollToBottom();
        String unit2 = level.checkUnit(1);
        //чекнуть один с 3 блока
        schedule.scrollToBottom();
        String unit3 = schedule.checkUnit(1);
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
        //если экран закрывает всплывающее сообщение "Get a complimentary audit for free"
        if (gift.visible()) gift.close();
        pu.getChosenUnits().first().click();
        Assert.assertEquals(pu.getChosenUnits().size(), --chosen);
        pu.getChosenUnits().first().click();
        pu.getChosenUnits().first().click();
        Assert.assertTrue(pu.getChosenUnits().isEmpty());
        pu.close();//Зарыть форму
        //обновиться, проскролить, проверить кнопку закрыть панель
        Selenide.refresh();
        Warp.scrollToElement(level.getCHECKBOXES());
        level.checkUnit(1);
        pu.close();//закрыть панельку
    }
}

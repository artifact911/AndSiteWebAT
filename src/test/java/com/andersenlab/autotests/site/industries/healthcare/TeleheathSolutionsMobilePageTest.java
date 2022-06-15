package com.andersenlab.autotests.site.industries.healthcare;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.CostCalcData;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.Resolution;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.costcalc.DesktopCostCalc;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.blocks.costcalc.MobileCostCalc;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class TeleheathSolutionsMobilePageTest extends BaseTest2{
    private final Pages page = Pages.TELEHEATH_SOLUTIONS;
    private final Country country = Country.UA;
    private final Resolution mobile = Resolution.MOBILE;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, mobile);
    }

    @BeforeMethod(alwaysRun = true)
    @Override
    protected void beforeMethod(){
        super.beforeMethod();
    }

    @TmsLink("5346705")
    @Test(description = "[M] Отображение блока с калькулятором 'Your price calculator'", priority = 160)
    public void checkMobileCostCalc(){
        MobileCostCalc block = new MobileCostCalc(CostCalcData.Page.TELEHEATH.getData(), country);
        block.checkMobileCalc();
    }


}

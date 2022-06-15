package com.andersenlab.autotests.site.company;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Site")
@Listeners(SelenideListener.class)
public class PrivacyPolicyPageTest extends BaseTest2 {

    private final Pages page = Pages.PRIVACY_POLICY;
    private final Country country = Country.NOT_SPECIFIED;

    private CheckingThePresenceOfBlocks checkingThePresenceOfBlocks;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, country);
        checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 10, groups = "Checking the blocks")
    public void checkBlocks(){
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
    }
}

package com.andersenlab.autotests.core.configs.basetest;

import com.andersenlab.autotests.core.configs.SelenideConfiguration;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.Resolution;
import com.andersenlab.autotests.core.utils.utility.Utility;
import com.andersenlab.autotests.site.logic.Navigation;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.andersenlab.autotests.core.configs.basetest.Pages.HOMEPAGE;


public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    protected void beforeMethod() {
        prepare(HOMEPAGE, Country.NOT_SPECIFIED);
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
        Selenide.closeWebDriver();
    }

    protected void prepare(Pages page, Country country) {
        SelenideConfiguration.configure(Resolution.DESKTOP, country);

        switch (page) {
            case HOMEPAGE:
                Navigation.openHomeDev();
                break;
            case FRONTEND:
                Navigation.toFrontEnd();
                break;
            case E_COMMERCE:
                Navigation.toECommerce();
                break;
            case MOBILE_DEV:
                Navigation.toMobileDevelopment();
                break;
            case CUSTOM_SOFTWARE:
                Navigation.toCustomSoftware();
                break;
            case MEET_US_TOMORROW:
                Navigation.toMeetUsTomorrow();
                break;
            case BLOG:
                Navigation.openBlogUrl();
                break;
            case PRICING:
                Navigation.openPricing();
                break;
        }

        Utility.operations.acceptCookies();
    }

}

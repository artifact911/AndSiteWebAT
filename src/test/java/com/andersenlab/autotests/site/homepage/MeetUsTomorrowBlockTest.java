package com.andersenlab.autotests.site.homepage;

import com.andersenlab.autotests.core.configs.basetest.BaseTest;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.page.company.meetustomorrow.MeetUsTomorrowPage;
import com.andersenlab.autotests.site.page.homepage.HomePage;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Epic("Site")
@Listeners(SelenideListener.class)
public class MeetUsTomorrowBlockTest extends BaseTest {
    private HomePage homePage = new HomePage();

    @TmsLink("4990655")
    @Test(description = "Переход с главной на страницы трипов")
    public void transitionToMeetUsPageTest() {
        homePage.getMeetUsTomorrowBlock().getViewAllButton().click();
        assertEquals(new MeetUsTomorrowPage().getTitle().text(), "Meet us tomorrow", "meet us tomorrow page is not open");
        Assertions.assertCurrentUrlContains("https://dev.andersenlab.com/meet-us-tomorrow");
    }

}

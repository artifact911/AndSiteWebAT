package com.andersenlab.autotests.site.homepage;

import com.andersenlab.autotests.core.configs.basetest.BaseTest;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.page.homepage.HomePage;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.andersenlab.autotests.core.configs.basetest.Pages.HOMEPAGE;
import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.*;


@Epic("Site")
@Listeners(SelenideListener.class)
public class OurSatisfiedClientsTest extends BaseTest {
    private HomePage homePage = new HomePage();

    @BeforeMethod(alwaysRun = true)
    protected void beforeMethod() {
        prepare(HOMEPAGE, Country.UA);
    } //баг в 4910134 при Country.US

    @TmsLink("4910134")
    @Test(description = "Test opening and closing a modal window with video")
    public void openAndCloseVideoTest() {
        homePage.getOurSatisfiedClients().getLinkVideoBlock().click();
        assertTrue(homePage.getOurSatisfiedClients().getVideoBlock().isDisplayed(), "video is not opened");
        homePage.getOurSatisfiedClients().getCloseVideoButton().click();
        assertFalse(homePage.getOurSatisfiedClients().getVideoBlock().shouldNotBe(Condition.visible).isDisplayed(), "video is not closed");
        assertTrue(homePage.getHeadingBlock().getIntroTitle().isDisplayed());
    }

    @TmsLink("4910136")
    @Test(description = "Test going from the home page to Clutch.co", enabled = false) // убрали линки на клатч, новая фича
    public void openClutchAndersenPageFromHomePageTest() {
        /*
        homePage.getOurSatisfiedClients().getLinkToClutch().click();
        Selenide.switchTo().window(1);
        assertEquals(new ClutchAndersenPage().getPageTitle().text(), "Andersen",
                "clutch andersen page from link <more references> is not opened ");
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
        */
        homePage.getOurSatisfiedClients().getLinkMoreReferences().click();
        assertEquals((new Intro()).getEl().getHeading().getAttribute("innerText"), "Testimonials",
                "clutch andersen page from link <clutch>  is not opened ");
    }
}

package com.andersenlab.autotests.site.homepage;

import com.andersenlab.autotests.core.configs.basetest.BaseTest;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.page.engineers.EngineersOnProjectsPage;
import com.andersenlab.autotests.site.page.homepage.HomePage;
import com.andersenlab.autotests.site.page.map.ProjectMapPage;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro.Intro;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("Site")
@Listeners(SelenideListener.class)
public class StartProjectBlockTest extends BaseTest {
    private HomePage homePage = new HomePage();

    @TmsLink("4861997")
    @Test(description = "Switching from the home page to Find developers") //баг при Country.US
    public void openDedicatedTeamPageTest() {
        homePage.getStartProject().getLinkMoreInformation().click();
        assertEquals((new Intro()).getEl().getHeading().getAttribute("innerText"), "Find Developers");
    }

    @TmsLink("4861999")
    @Test(description = "Switching from the home page to Projects map", enabled = false) //ссылки больше нет
    public void openProjectMapPageTest() {
        homePage.getStartProject().getLinkProvenExpertise().click();
        assertEquals(new ProjectMapPage().getTitle().getAttribute("innerText"), "Andersen’s Project Map");
    }

    @TmsLink("4862000")
    @Test(description = "Switching from the home page to Engineers on Projects")
    public void openEngineersOnProjectsPageTest() {
        homePage.getStartProject().getLinkSatisfiedClients().click();
        assertEquals(new EngineersOnProjectsPage().getTitle().getAttribute("innerText"), "Engineers on Projects");
    }
}

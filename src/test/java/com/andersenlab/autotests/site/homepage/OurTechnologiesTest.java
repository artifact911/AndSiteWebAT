package com.andersenlab.autotests.site.homepage;

import com.andersenlab.autotests.core.configs.basetest.BaseTest;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.page.homepage.HomePage;
import com.andersenlab.autotests.site.page.services.dedicatedteampage.DedicatedTeamPage;
import com.andersenlab.autotests.site.page.techstack.BaseTechPage;
import com.andersenlab.autotests.site.page.techstack.backend.dotnet.DotNetPage;
import com.andersenlab.autotests.site.page.techstack.backend.java.JavaPage;
import com.andersenlab.autotests.site.page.techstack.mobile.mobile.MobilePage;
import com.andersenlab.autotests.site.page.techstack.backend.python.PythonPage;
import com.andersenlab.autotests.site.page.techstack.backend.scala.ScalaPage;
import com.andersenlab.autotests.site.utility.Warp;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("Site")
@Listeners(SelenideListener.class)

public class OurTechnologiesTest extends BaseTest {
    private HomePage homePage = new HomePage();

    @TmsLink("4910132")
    @Test(description = "Test transition to the mobile developers search page from the home page")
    public void openMobilePageFromHomePageTest() {
        homePage.getTechnologies().getLinkMobilePage().click();
        assertEquals(new MobilePage().getFeatureTitle().text(), "Get Mobile development specialists with long term experience and proven track record",
                "mobile developers search page is not loaded");
    }

    @TmsLink("4910114")
    @Test(description = "Test transition to the front end developers search page from the home page")
    public void openFrontEndPageFromHomePageTest() {
        homePage.getTechnologies().getLinkFrontEndPage().click();
        assertEquals(new BaseTechPage().getFeatureTitle().text(), "Get Front-end development specialists with long term experience and proven track record",
                "front end developers search page page is not loaded");
    }

    @TmsLink("4910110")
    @Test(description = "Test transition to the scala developers search page from the home page")
    public void openScalaPageFromHomePageTest() {
        homePage.getTechnologies().getLinkScalaPage().click();
        assertEquals(new ScalaPage().getFeatureTitle().text(), "Get Scala development specialists with long term experience and proven track record",
                "Scala page is not loaded");
    }

    @TmsLink("4910133")
    @Test(description = "Test switching from the home page to Technologies", enabled = false)//блока больше нет
    public void openDedicatedTeamPageFromHomePageTest() {
        homePage.getTechnologies().getLinkDedicatedTeamPage().click();
        assertEquals(new DedicatedTeamPage().getTechnologiesBlock().getH2Title().text(), "Technologies",
                "page not contains title <Technologies>");
        Assertions.assertCurrentUrlContains("andersenlab.com/services/dedicated-team#technologies-et");
    }

    @TmsLink("4910103")
    @Test(description = "Test transition to the .net developers search page from the home page")
    public void openDotNetPageFromHomePageTest() {
        homePage.getTechnologies().getLinkDotNetPage().click();
        Warp.delay(10);
        assertEquals(new DotNetPage().getFeatureTitle().text(), "Get .NET development specialists with long term experience and proven track record",
                ".NET page is not loaded");
    }

    @TmsLink("4910102")
    @Test(description = "Test transition to the python developers search page from the home page")
    public void openPythonPageFromHomePageTest() {
        homePage.getTechnologies().getLinkPythonPage().click();
        assertEquals(new PythonPage().getFeatureTitle().text(), "Get Python development specialists with long term experience and proven track record",
                "Python page is not loaded");
    }

    @TmsLink("4910104")
    @Test(description = "Test transition to the java developers search page from the home page")
    public void openJavaPageFromHomePageTest() {
        homePage.getTechnologies().getLinkJavaPage().click();
        assertEquals(new JavaPage().getFeatureTitle().text(), "Get Java development specialists with long term experience and proven track record",
                "Java page is not loaded");
    }

}




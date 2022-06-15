package com.andersenlab.autotests.site.homepage;
import com.andersenlab.autotests.core.configs.basetest.BaseTest;
import com.andersenlab.autotests.site.page.homepage.HomePage;
import com.andersenlab.autotests.site.page.industries.ecommerce.EcommercePage;
import com.andersenlab.autotests.site.page.industries.financialservices.FinancialServicesBankingPage;
import com.andersenlab.autotests.site.page.industries.healthcare.HealthCarePage;
import com.andersenlab.autotests.site.page.industries.realestate.RealEstatePage;
import com.andersenlab.autotests.site.page.industries.travelandhospitality.TravelHospitalityPage;
import com.andersenlab.autotests.site.page.industries.videoandentertainment.VideoEntertainmentPAge;
import com.andersenlab.autotests.site.page.topcompanies.interactivetv.InteractiveTvPage;
import com.andersenlab.autotests.site.page.topcompanies.mediamarkt.MediaMarktPage;
import com.andersenlab.autotests.site.page.topcompanies.mercedesme.MercedesMePage;
import com.andersenlab.autotests.core.configs.SelenideConfiguration;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.Resolution;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.andersenlab.autotests.core.utils.utility.Utility;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("Site")
@Listeners(SelenideListener.class)
public class TopCompaniesBlockTest extends BaseTest {
    private HomePage homePage = new HomePage();

    @TmsLink("4910775")
    @Test(description = "Test transition from the main page to <Mercedes Me>")
    public void openCaseMercedesPageFromMainPageTest() {
        homePage.getTopCompanies().getLinkMercedesMe().click();
        assertTrue(Selenide.title().contains("Mercedes-Benz"), "mercedes page not opened");
        assertEquals(new MercedesMePage().getHeaderTitle().text(), "Mercedes Cafe", "page not contains title 'Mercedes Cafe'");
    }

    @TmsLink("4910776")
    @Test(description = "Transition from the main page of the site to 'Interactive TV'")
    public void openInteractiveTvPageFromMainPageTest() {
        homePage.getTopCompanies().getLinkInteractiveTv().click();
        assertTrue(Selenide.title().contains("Internet TV"), "Interactive TV page not opened");
        assertEquals(new InteractiveTvPage().getTvTitle().text(), "Interactive TV", "Interactive TV page not loaded");
    }

    @TmsLink("4910777")
    //кейс был не корректен для US, временно меняю на UA proxy
    @Test(description = "Transition from the main page of the site to 'Media Market'")
    public void openMediaMarketPageFromMainPageTest() {
        Selenide.closeWebDriver();
        SelenideConfiguration.configure(Resolution.DESKTOP, Country.UA);
        homePage = open(PropertiesReader.get("application.url"), HomePage.class);
        homePage.getTopCompanies().getLinkMediaMarkt().click();
        assertTrue(Utility.operations.checkLoadSite(), "Homepage not loaded");
        assertEquals(new MediaMarktPage().getHeaderTitle().text(), "Media Markt", "Media Market page not loaded");
        assertTrue(Selenide.title().contains("Consumer"), "Media Market page not opened");
    }

    @TmsLink("4916780")
    @Test(description = "Transition from the main page of the site to 'Fintech Banking'")
    public void openFintechBankingPageFromMainPageTest(){
        homePage.getTopCompanies().getLinkFintechBanking().click();
        assertEquals(new FinancialServicesBankingPage().getTitle().getText(),"Custom Financial Software Development");
    }

    @TmsLink("4916782")
    @Test(description = "Transition from the main page of the site to 'Ecommerce'")
    public void openEcommercePageFromMainPageTest(){
        homePage.getTopCompanies().getLinkEcommerce().click();
        assertEquals(new EcommercePage().getHeadingBlock().getTitle().getText(), "eCommerce Development Services");
    }

    @TmsLink("4916783")
    @Test(description = "Transition from the main page of the site to 'healthcare'")
    public void openHealthcarePageFromMainPageTest() {
        homePage.getTopCompanies().getLinkHealthcare().click();
        assertEquals(new HealthCarePage().getHeadingBlock().getTitle().getText(), "Custom Healthcare Software Development Services");
    }

    @TmsLink("4917967")
    @Test(description = "Transition from the main page of the site to 'Video & Entertainment'", enabled = false)//ссылка убрана, доступ из навбара
    public void openVideoEntertainmentPageFromMainPageTest() {
        homePage.getTopCompanies().getLinkVideoEntertainment().click();
        assertEquals(new VideoEntertainmentPAge().getHeadingBlock().getTitle().getText(),"The OTT Platform Development Company of Choice");
    }

    @TmsLink("4917968")
    @Test(description = "Transition from the main page of the site to 'Real Estate'", enabled = false)//ссылка убрана, доступ из навбара
    public void openRealEstatePageFromMainPageTest() {
        actions().moveToElement(homePage.getNavBarBlock().getDropDownMenuServices()).click(homePage.getNavBarBlock().getDropDownMenuServices());
        homePage.getTopCompanies().getLinkRealEstate().click();
        assertEquals(new RealEstatePage().getHeadingBlock().getTitle().getText(),"Real Estate Software Development");

    }

    @TmsLink("4917972")
    @Test(description = "Transition from the main page of the site to 'Travel & Hospitality'", enabled = false)//ссылка убрана, доступ из навбара
    public void openTravelHospitalityPageFromMainPageTest() {
        homePage.getTopCompanies().getLinkTravelHospitality().click();
        assertEquals(new TravelHospitalityPage().getHeadingBlock().getTitle().getText(),"Hospitality and Travel Software Development");
    }

}


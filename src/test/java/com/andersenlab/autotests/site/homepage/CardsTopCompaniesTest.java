package com.andersenlab.autotests.site.homepage;

import com.andersenlab.autotests.core.configs.basetest.BaseTest;
import com.andersenlab.autotests.site.page.homepage.HomePage;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CardsTopCompaniesTest extends BaseTest {
    HomePage homePage = new HomePage();
    final String EXPECTED = "Top-Rated American Software Provider";
    final String ACTUAL = "Andersen, delivering the Value of Software";//атуальный и ожидаемый перепутаны для проверки добавлено 6,11 TODO переделать после актуализации кейсов

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Samsung'", priority = 10)
    public void openPopUpsSamsungCard() {
        homePage.getCardsTopCompaniesBlock().getSamsungCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Marvel'", priority = 20)
    public void openPopUpsMarvelCard() {
        homePage.getCardsTopCompaniesBlock().getMarvelCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Mercedes'", priority = 30)
    public void openPopUpsMercedesCard() {
        homePage.getCardsTopCompaniesBlock().getMercedesCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Payroll'", priority = 40)
    public void openPopUpsPayrollCard() {
        homePage.getCardsTopCompaniesBlock().getGlobePayrollCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Ihs'", priority = 50)
    public void openPopUpsIhsCard() {
        homePage.getCardsTopCompaniesBlock().getIhsCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Bnp'", priority = 60)
    public void openPopUpsBnpCard() {
        homePage.getCardsTopCompaniesBlock().getBnpCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Tui'", priority = 70)
    public void openPopUpsTuiCard() {
        homePage.getCardsTopCompaniesBlock().getTuiCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Purity'", priority = 80)
    public void openPopUpsPurityCard() {
        homePage.getCardsTopCompaniesBlock().getPurityCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Mogo Finance'", priority = 90)
    public void openPopUpsMogoFinanceCard() {
        homePage.getCardsTopCompaniesBlock().getMogoFinanceCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Siemens'", priority = 100)
    public void openPopUpsSiemensCard() {
        homePage.getCardsTopCompaniesBlock().getSiemensCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Beeline'", priority = 110)
    public void openPopUpsBeelineCard() {
        homePage.getCardsTopCompaniesBlock().getBeelineCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Alfa Bank'", priority = 120)
    public void openPopUpsAlfaBankCard() {
        homePage.getCardsTopCompaniesBlock().getAlfaBankCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }

    @TmsLink("4917982")
    @Test(description = "Opening pop-ups 'Momook'", priority = 130)
    public void openPopUpsMomook() {
        homePage.getCardsTopCompaniesBlock().getAlfaBankCard().click();
        assertTrue(homePage.getCardsTopCompaniesBlock().getDisplayedPopUps().isDisplayed());
        homePage.getCardsTopCompaniesBlock().getClosePopUps().click();
        assertEquals(homePage.getHeadingBlock().getIntroTitle().text(), EXPECTED);
    }
}


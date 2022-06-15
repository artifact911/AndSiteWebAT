package com.andersenlab.autotests.site.industries;

import com.andersenlab.autotests.core.configs.basetest.BaseTest;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.andersenlab.autotests.site.page.industries.ecommerce.EcommercePage;
import com.andersenlab.autotests.site.page.topcompanies.commercialpeople.CommercialPeoplePage;
import com.andersenlab.autotests.site.page.topcompanies.decta.DectaPage;
import com.andersenlab.autotests.site.page.topcompanies.digitalinspire.DigitalInspirePage;
import com.andersenlab.autotests.site.page.topcompanies.gmcspost.GmcsPostPage;
import com.andersenlab.autotests.site.page.topcompanies.mediamarkt.MediaMarktPage;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.andersenlab.autotests.core.configs.basetest.Pages.E_COMMERCE;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.testng.Assert.*;

@Epic("Site")
@Listeners(SelenideListener.class)
public class ECommerceTest extends BaseTest implements FormData {
    private EcommercePage eCommercePage = new EcommercePage();

    @BeforeMethod
    @Override
    protected void beforeMethod() {
        prepare(E_COMMERCE, Country.NOT_SPECIFIED);
    }

    @TmsLink("4970332")
    @Test(description = "Functionality of pop-up <Reach out>", enabled = false)//кнопки и стр больше нет
    public void reachOutFormTest() {
        //Нажать на кнопку "Reach out
        // "Открыт поп-ап "Reach out"
        eCommercePage.getReachBlock().getOpenReachFormButton().click();
        assertTrue(eCommercePage.getReachBlock().getReachForm().isDisplayed(), "reach out form is not opened");

        //   Нажать на кнопку "Send"
        //   Под полями "Corporate E-mail" и "Phone" появляется ошибка "Please enter valid information"
        eCommercePage.getReachBlock().getReachFormSendButton().click();
        assertEquals(eCommercePage.getReachBlock().getOperations().getNoEmailReachFormError(), "Please enter valid information",
                "<no email> error message is not displayed");
        assertEquals(eCommercePage.getReachBlock().getOperations().getNoPhoneReachFormError(), "Please enter valid information",
                "<no phone> error message is not displayed");

        //Ввести спецсимвол в поле "Phone"
        //Нажать на кнопку "Send"
        //Под полями "Corporate E-mail" и "Phone" появляется ошибка "Please enter valid information"
        eCommercePage.getReachBlock().getReachFormPhone().sendKeys("%");
        eCommercePage.getReachBlock().getReachFormSendButton().click();
        assertEquals(eCommercePage.getReachBlock().getOperations().getNoEmailReachFormError(), "Please enter valid information",
                "<no email> error message is not displayed");
        assertEquals(eCommercePage.getReachBlock().getOperations().getNoPhoneReachFormError(), "Please enter valid information",
                "<no phone> error message is not displayed");

        //Ввести "@gmail.com" в поле "Corporate E-mail"
        //Нажать на кнопку "Send"
        //Под полями "Corporate E-mail" и "Phone" появляется ошибка "Please enter valid information"
        eCommercePage.getReachBlock().getReachFormEmail().sendKeys("@gmail.com");
        eCommercePage.getReachBlock().getReachFormSendButton().click();
        assertEquals(eCommercePage.getReachBlock().getOperations().getNoEmailReachFormError(), "Please enter valid information",
                "<no email> error message is not displayed");
        assertEquals(eCommercePage.getReachBlock().getOperations().getNoPhoneReachFormError(), "Please enter valid information",
                "<no phone> error message is not displayed");

        //Нажать на "Х"
        //Открыта страница https://dev.andersenlab.com/industries/ecommerce
        eCommercePage.getReachBlock().getCloseRequestPopupButton().click();
        assertEquals(eCommercePage.getHeadingBlock().getTitle().shouldBe(Condition.visible).text(), "Custom eCommerce development services",
                "eCommerce page is not opened");

        //Нажать на кнопку "Reach out"
        //Открыт поп-ап "Reach out"
        eCommercePage.getReachBlock().getOpenReachFormButton().click();
        assertTrue(eCommercePage.getReachBlock().getReachForm().isDisplayed(), "reach out form is not opened");

        //Нажать на место вне поп-апа
        //Открыта страница https://dev.andersenlab.com/industries/ecommerce
        eCommercePage.getReachBlock().getReachForm().shouldBe(Condition.visible).click(0, 450);
        assertEquals(eCommercePage.getHeadingBlock().getTitle().shouldBe(Condition.visible).text(), "Custom eCommerce development services",
                "eCommerce page is not opened");

        //Нажать на кнопку "Reach out"
        //Открыт поп-ап "Reach out"
        eCommercePage.getReachBlock().getOpenReachFormButton().click();
        assertTrue(eCommercePage.getReachBlock().getReachForm().isDisplayed(), "reach out form is not opened");

        //Нажать на "ESC"
        //Открыта страница https://dev.andersenlab.com/industries/ecommerce
        Selenide.getFocusedElement().sendKeys(Keys.ESCAPE);
        assertEquals(eCommercePage.getHeadingBlock().getTitle().shouldBe(Condition.visible).text(), "Custom eCommerce development services",
                "eCommerce page is not opened");

    }

    //правки в тест внесены со слов. TODO уточнить после правок кейсов
    @TmsLink("4970334")
    @Test(description = "Submitting data forms pop-up <Reach out>", enabled = false)//кнопки и стр больше нет
    public void reachOutFormSubmitDataTest() {
        final String VALID_PHONE =  "\b\b\b\b" + randomNumeric(4, 15);
        final String INVALID_PHONE = "\b\b\b\b" +  ((RandomUtils.nextBoolean()) ? randomNumeric(0, 3) : randomNumeric(16, 20)); //через раз разные невалидные номера
        final String COOPERATE_EMAIL = "qaands@zzx.com"; //корпоративный емейл появился 6.11.20, потому что gmail и подобные без телефона не пропускает
        final String PRIVATE_EMAIL = "qaands@gmail.com";
        final String INVALID_EMAIL = "qaandsmail.com";

        //Нажать на кнопку "Reach out
        // "Открыт поп-ап "Reach out"
        eCommercePage.getReachBlock().getOpenReachFormButton().click();
        assertTrue(eCommercePage.getReachBlock().getReachForm().isDisplayed(), "reach out form is not opened");

        //Заполнить поле "Corporate E-mail" валидными данными ( qaands@gmail.com )
        //Нажать на кнопку "Send"
        //Открыт поп-ап сообщающий об успешной отправке
        eCommercePage.getReachBlock().getReachFormEmail().sendKeys(COOPERATE_EMAIL);
        eCommercePage.getReachBlock().getReachFormSendButton().click();
        assertTrue(eCommercePage.getReachBlock().getPopupSuccess().shouldBe(Condition.visible).isDisplayed(), "success popup is not displayed");


        //Закрыть поп-ап сообщающий об успешной отправке
        //Нажать на кнопку "Reach out"
        //Открыт поп-ап "Reach out"
        eCommercePage.getReachBlock().getCloseSuccessPopupButton().click();
        eCommercePage.getReachBlock().getOpenReachFormButton().click();
        assertTrue(eCommercePage.getReachBlock().getReachForm().isDisplayed(), "reach out form is not opened");


        // Заполнить поле "Phone" валидными данными ( набор состоящий из 4-15 цифр )
        // Нажать на кнопку "Send"
        // Открыт поп-ап сообщающий об успешной отправке
//        eCommercePage.getReachBlock().getReachFormPhone().sendKeys(randomNumeric(4, 15)); //через раз сбоит, не знаю почему
        eCommercePage.getReachBlock().getReachFormPhone().sendKeys(VALID_PHONE);
        eCommercePage.getReachBlock().getReachFormSendButton().click();
        assertTrue(eCommercePage.getReachBlock().getPopupSuccess().shouldBe(Condition.visible).isDisplayed(), "success popup is not displayed");

        //Закрыть поп-ап сообщающий об успешной отправке
        //Нажать на кнопку "Reach out"
        //Открыт поп-ап "Reach out"
        eCommercePage.getReachBlock().getCloseSuccessPopupButton().click();
        eCommercePage.getReachBlock().getOpenReachFormButton().click();
        assertTrue(eCommercePage.getReachBlock().getReachForm().isDisplayed(), "reach out form is not opened");

        //Заполнить поле "Corporate E-mail" валидными данными ( qaands@gmail.com )
        //Заполнить поле "Phone" невалидными данными ( набор состоящий из менее 4 цифр или более 15 цифр )
        // Нажать на кнопку "Send"
        // Открыт поп-ап сообщающий об успешной отправке
        eCommercePage.getReachBlock().getReachFormEmail().sendKeys(COOPERATE_EMAIL);
//        if (RandomUtils.nextBoolean())
//            eCommercePage.getReachBlock().getReachFormPhone().sendKeys(randomNumeric(0, 3));
//        else eCommercePage.getReachBlock().getReachFormPhone().sendKeys(randomNumeric(16, 20)); //вынес в переменную INVALID_PHONE
        eCommercePage.getReachBlock().getReachFormPhone().sendKeys(INVALID_PHONE);
        eCommercePage.getReachBlock().getReachFormSendButton().click();
        assertTrue(eCommercePage.getReachBlock().getPopupSuccess().shouldBe(Condition.visible).isDisplayed(), "success popup is not displayed");

        //Закрыть поп-ап сообщающий об успешной отправке
        //Нажать на кнопку "Reach out"
        //Открыт поп-ап "Reach out"
        eCommercePage.getReachBlock().getCloseSuccessPopupButton().click();
        eCommercePage.getReachBlock().getOpenReachFormButton().click();
        assertTrue(eCommercePage.getReachBlock().getReachForm().isDisplayed(), "reach out form is not opened");

        //Заполнить поле "Phone" валидными данными ( набор состоящий из 4-15 цифр )
        //Заполнить поле "Corporate E-mail" невалидными данными ( qaandsgmail.com )
        //Нажать на кнопку "Send"
        //Открыт поп-ап сообщающий об успешной отправке
//        eCommercePage.getReachBlock().getReachFormPhone().sendKeys(randomNumeric(4, 15));
        eCommercePage.getReachBlock().getReachFormPhone().sendKeys(VALID_PHONE);
        eCommercePage.getReachBlock().getReachFormEmail().sendKeys(INVALID_EMAIL);
        eCommercePage.getReachBlock().getReachFormSendButton().click();
        assertTrue(eCommercePage.getReachBlock().getPopupSuccess().shouldBe(Condition.visible).isDisplayed(), "success popup is not displayed");

    }


    @TmsLink("4978543")
    @Test(description = "Functionality of the Let’s talk business block")
    public void letsTalkBlockTest() {
        //нажать на кнопку send не заполнив поля и проверить наличие ошибки под полем email
        eCommercePage.getLetsTalkBlock().getSendButton().click();
        assertEquals(eCommercePage.getLetsTalkBlock().getOperations().getNoEmailError(), "Please, enter your corporate email",
                "error message is not displayed");
        Selenide.refresh();

        //Ввести спецсимвол в поле "Phone or E-mail",нажать на кнопку "Send, под полем "Phone or E-mail"
        //проверить наличие ошибки под полем email
        eCommercePage.getLetsTalkBlock().getFieldEmail().sendKeys("&");
        eCommercePage.getLetsTalkBlock().getSendButton().click();
        assertEquals(eCommercePage.getLetsTalkBlock().getOperations().getNoEmailError(), "Please, enter your corporate email",
                "error message is not displayed");
        Selenide.refresh();


        //Ввести "@gmail.com" в поле "Phone or E-mail"
        //Нажать на кнопку "Send"
        //Под полем "Phone or E-mail" появляется ошибка "Please enter valid information"
        eCommercePage.getLetsTalkBlock().getFieldEmail().sendKeys("@gmail.com");
        eCommercePage.getLetsTalkBlock().getSendButton().click();
        assertEquals(eCommercePage.getLetsTalkBlock().getOperations().getNoEmailError(), "Please, enter your phone number",
                "error message is not displayed");

        //Заполнить поле "Phone or E-mail" валидными данными ( qaands@gmail.com )
        //Нажать на кнопку "Send"
        //Открыт поп-ап сообщающий об успешной отправке
        eCommercePage.getLetsTalkBlock().getFieldEmail().clear();
        eCommercePage.getLetsTalkBlock().getFieldEmail().sendKeys("qaands@andersenlab.com");
        eCommercePage.getLetsTalkBlock().getSendButton().click();
        Warp.delay(4);
        assertTrue(eCommercePage.getLetsTalkBlock().getPopupThank().getAttribute("style").contains("display: block;"));

        //Закрыть поп-ап сообщающий об успешной отправке
        //Заполнить поле "Phone or E-mail" валидными данными ( набор состоящий из 4-15 цифр )
        //Нажать на кнопку "Send"
        //Открыт поп-ап сообщающий об успешной отправке
        eCommercePage.getLetsTalkBlock().getPopupCloseButton().click();
        eCommercePage.getLetsTalkBlock().getFieldPhone().sendKeys(PHONE_VALID);
        eCommercePage.getLetsTalkBlock().getSendButton().click();
        assertTrue(eCommercePage.getLetsTalkBlock().getPopupThank().shouldBe(Condition.visible).isDisplayed(), "popup is not open");
    }

    @TmsLink("4978540")
    @Test(description = "Test opening and closing a modal window with video", enabled = false)//кнопки и стр больше нет
    public void openAndCloseVideoTest() {
        //открытие видео и закрытие с помощью кнопки "Х"
        eCommercePage.getAttractSellBlock().getWatchVideoButton().click();
        assertTrue(eCommercePage.getAttractSellBlock().getVideoBlock().shouldBe(Condition.visible).isDisplayed(), "Video popup is not open");
        eCommercePage.getAttractSellBlock().getCloseVideoButton().click();
        assertFalse(eCommercePage.getAttractSellBlock().getVideoBlock().shouldNotBe(Condition.visible).isDisplayed(), "video is not closed from close button");

        //открытие видео и закрытие с помощью клавиши "ESCAPE"
        eCommercePage.getAttractSellBlock().getWatchVideoButton().shouldBe(Condition.visible).click();
        assertTrue(eCommercePage.getAttractSellBlock().getVideoBlock().isDisplayed(), "Video popup is not open");
        Selenide.getFocusedElement().sendKeys(Keys.ESCAPE);
        assertFalse(eCommercePage.getAttractSellBlock().getVideoBlock().shouldNotBe(Condition.visible).isDisplayed(), "video is not closed from esc");

        //открытие видео и закрытие с помощью клика на место вне поп-апа
        eCommercePage.getAttractSellBlock().getWatchVideoButton().click();
        assertTrue(eCommercePage.getAttractSellBlock().getVideoBlock().shouldBe(Condition.visible).isDisplayed(), "Video popup is not open");
        eCommercePage.getAttractSellBlock().getOutsideVideoPopup().click(0, 450);
        assertFalse(eCommercePage.getAttractSellBlock().getVideoBlock().shouldNotBe(Condition.visible).isDisplayed(), "video is not closed from click on a place outside the pop-up");
    }


    @TmsLink("4978542")
    @Test(description = "Переход на страницы проектов ", enabled = false)//кнопки и стр больше нет
    public void projectsTransitionTest() {
        //ПЕРЕХОДЫ НА ПРОЕКТЫ:
        // переход на Media Markt
        eCommercePage.getIndustryLeadersBlock().getMediaMarktPreview().click();
        assertEquals(new MediaMarktPage().getHeaderTitle().text(), "Media Markt", "Media Markt page is not open");
        Selenide.back();
        assertEquals(eCommercePage.getHeadingBlock().getTitle().text(), "Custom eCommerce development services");

        // переход на Decta
        eCommercePage.getIndustryLeadersBlock().getDectaPreview().click();
        assertEquals(new DectaPage().getHeaderTitle().text(), "Solution for Internet Acquiring", "Decta page is not open");
        Selenide.back();
        assertEquals(eCommercePage.getHeadingBlock().getTitle().text(), "Custom eCommerce development services");

        //переход на GMCS/RUSSIAN post
        eCommercePage.getIndustryLeadersBlock().getGmcsPreview().click();
        assertEquals(new GmcsPostPage().getHeaderTitle().text(), "Registration of Mailing Units", "GMCS/RUSSIAN  post page is not open");
        Selenide.back();
        assertEquals(eCommercePage.getHeadingBlock().getTitle().text(), "Custom eCommerce development services");

        //переход на  Digital Inspire
        eCommercePage.getIndustryLeadersBlock().getDigitalInspirePreview().click();
        assertEquals(new DigitalInspirePage().getHeaderTitle().text(), "Software for Certificates Storage");
        Selenide.back();
        assertEquals(eCommercePage.getHeadingBlock().getTitle().text(), "Custom eCommerce development services");

        //клик на show more и переход на  Commercial People
        eCommercePage.getIndustryLeadersBlock().getShowMoreButton().click();
        assertTrue(eCommercePage.getIndustryLeadersBlock().getCommercialPeoplePreview().isDisplayed(), "commercial block is not displayed");
        eCommercePage.getIndustryLeadersBlock().getCommercialPeoplePreview().click();
        assertEquals(new CommercialPeoplePage().getHeaderTitle().text(), "Commercial People - Property Portal",
                "Commercial people page is not open");
    }
}


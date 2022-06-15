package com.andersenlab.autotests.site.form;

import com.andersenlab.autotests.core.gmail.ReadEmail;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.core.utils.utility.Utility;
import com.andersenlab.autotests.site.form.contactusfooterform.ContactUsFooterForm;
import com.andersenlab.autotests.site.logic.Navigation;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

@Epic("Site")
@Listeners(SelenideListener.class)
public class ContactUsFooterFormTest {

    private ContactUsFooterForm contactUsFooterForm;
    private ReadEmail readEmail;
    private Navigation navigation;

    @Parameters({"pageMethod"})
    @BeforeClass(alwaysRun = true)
    private void beforeClass( String pageMethod)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        navigation = new Navigation();
        contactUsFooterForm = new ContactUsFooterForm();
        readEmail = new ReadEmail();
        testGetMethod(pageMethod);
    }

    //TODO Look... maybe need AfterSuite, not that AfterClass
    @AfterClass(alwaysRun = true)
    private void afterClass() {
        Selenide.closeWebDriver();
    }

    @TmsLink("5274201")
    @Test(description = "Позитивный кейс (некорпоративный е-маил, заполнены все поля)", priority = 10)
    public void checkContactUsFormAtFooterPositiveCaseAllFieldsFilledIn() throws MessagingException, IOException, SQLException {
        contactUsFooterForm.scrollToSection(contactUsFooterForm.getContactUsFooterSection());
        contactUsFooterForm.positiveValidationNameField();
        contactUsFooterForm.enteringNoNCorporateEmail();
        contactUsFooterForm.enteringValidPhoneNumber();
        contactUsFooterForm.positiveValidationCommentsField();
        contactUsFooterForm.clickNda();
        contactUsFooterForm.clickSendButton();
        contactUsFooterForm.checkSuccessfulModalWindow();
        readEmail.readGoogleEmail();
        contactUsFooterForm.checkNewRecordInStageDatabaseAllFieldsFilledIn();
    }

    @TmsLink("5600428")
    @Test(description = "Позитивный кейс (корпоративный е-маил, не все поля заполнены)", priority = 20)
    public void checkContactUsFormAtFooterPositiveCaseNotAllFieldsFilledIn() throws SQLException {
        contactUsFooterForm.scrollToSection(contactUsFooterForm.getContactUsFooterSection());
        contactUsFooterForm.enteringCorporateEmail();
        contactUsFooterForm.clickSendButton();
        contactUsFooterForm.checkSuccessfulModalWindow();
        contactUsFooterForm.checkNewRecordInStageDatabaseCorporateEmailFilledIn();
    }

    @TmsLink("5600437")
    @Test(description = "Позитивный кейс (выбор способа связи, не все поля заполнены)", priority = 30)
    public void checkContactUsFormAtFooterPositiveCaseChoosingCommunicationMethodNotAllFieldsFilledIn() throws SQLException {
        contactUsFooterForm.scrollToSection(contactUsFooterForm.getContactUsFooterSection());
        contactUsFooterForm.enteringValidPhoneNumber();
        contactUsFooterForm.clickSendButton();
        contactUsFooterForm.checkSuccessfulModalWindow();
        contactUsFooterForm.checkNewRecordInStageDatabasePhoneNumberFilledIn();
    }

    @TmsLink("5600435")
    @Test(description = "Валидация поля Name (негативные проверки)", priority = 40)
    public void checkContactUsFormAtFooterValidationNameFieldNegativeChecks(){
        contactUsFooterForm.scrollToSection(contactUsFooterForm.getContactUsFooterSection());
        contactUsFooterForm.negativeValidationNameField();
    }

    @TmsLink("5274202")
    @Test(description = "Валидация поля Corporate E-mail (негативные проверки)", priority = 50)
    public void checkContactUsFormAtFooterValidationEmailFieldNegativeChecks(){
        contactUsFooterForm.scrollToSection(contactUsFooterForm.getContactUsFooterSection());
        contactUsFooterForm.negativeValidationEmailField();
    }

    @TmsLink("5274203")
    @Test(description = "Валидация поля Выбор способа связи (негативные проверки)", priority = 60)
    public void checkContactUsFormAtFooterValidationPhoneFieldNegativeChecks(){
        contactUsFooterForm.scrollToSection(contactUsFooterForm.getContactUsFooterSection());
        contactUsFooterForm.enteringInValidPhoneNumberLessThan5Characters();
        contactUsFooterForm.enteringInValidPhoneNumberMoreThan18Characters();
    }

    @TmsLink("5600436")
    @Test(description = "Валидация поля Comments (негативные проверки)", priority = 70)
    public void checkContactUsFormAtFooterValidationCommentsFieldNegativeChecks(){
        contactUsFooterForm.scrollToSection(contactUsFooterForm.getContactUsFooterSection());
        contactUsFooterForm.negativeValidationCommentsField();
    }

    private void testGetMethod(String methodName) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Method method = Navigation.class.getMethod(methodName);
        method.invoke(navigation, new Object[] {});
        Utility.operations.acceptCookies();
    }
}

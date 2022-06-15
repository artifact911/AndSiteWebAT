package com.andersenlab.autotests.site.form.contactusfooterform;

import com.andersenlab.autotests.core.configs.constants.CSSProperties;
import com.andersenlab.autotests.core.db.DbConnectionActual;
import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class ContactUsFooterForm {

    @Getter
    private final SelenideElement contactUsFooterSection = $(By.xpath("//section[contains(@class, 'GetConsultation-module')]"));
    private final SelenideElement nameField = $(By.xpath("//input[@placeholder='Name']"));
    private final SelenideElement emailField = $(By.xpath("//input[@placeholder='Corporate E-mail']"));
    private final SelenideElement phoneField = $(By.xpath("//input[@placeholder='Phone']"));
    private final SelenideElement emailTooltip = $(By.cssSelector(".GetConsultation-module--form--QVN8n > div:nth-child(1) > div.forms-module--fieldWrapperTwo--TWwtC section"));
    private final SelenideElement tipUnderThePhoneNumberField = $(By.xpath("//p[text()='Please, enter your phone number']"));
    private final SelenideElement tipUnderTheEmailField = $(By.xpath("//p[text()='Please, enter your corporate email']"));
    private final SelenideElement commentsField = $(By.xpath("//textarea[@placeholder='Comments']"));
    private final SelenideElement sendRequestButton = $(By.xpath("//button[contains(@class, 'forms-module--sendButton')]"));
    private final SelenideElement checkbox = $(By.xpath("//div[contains(@class, 'forms-module--nda')]"));
    private final SelenideElement selectedCheckbox = $(By.xpath("//input[@name='nda']"));
    private final SelenideElement successfulModalWindow = $(By.xpath("//div[contains(@class, 'modal-module--container')]"));
    private final SelenideElement successfulModalWindowText = $(By.xpath("//p[contains(@class, 'SuccessModal-module')]"));
    private final SelenideElement successfulModalWindowCloseButton = $(By.xpath("//div[contains(@class, 'modal-module--content')]//button[contains(@class, 'close-button')]"));

    @Getter
    private final String validUserName = "Test user name";
    private final String inValidUserName = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibu";
    private final String inValidUserNameForChecking = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus.";
    private final String corporateEmail = "qaands@andersenlab.com";
    private final String nonCorporateEmail = "qaands@gmail.com";
    private final String inValidEmail = "test.andersenlab.com";
    private final String validPhoneNumber = "1212345678";
    private final String validPhoneNumberForChecking = "+491212345678"; //TODO Т.к. удалённая машина в Германии, порефачить код (поработать с маской телефона) так,
    private final String inValidPhoneNumber = "+49123456789101112"; //TODO   что бы можно было тесты запускать и локально, и удалённо.
    private final String inValidPhoneNumberForChecking = "12345678910111213";
    private final String emailTooltipText = "For industry-based consultancy, a corporate email is preferred.";
    private final String tipUnderThePhoneNumberFieldText = "Please, enter your phone number";
    private final String tipUnderTheEmailFieldText = "Please, enter your corporate email";
    private final String validComment = "Hello, I'd like to cooperate with you! I ask you to contact me.";
    private final String invalidComment = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibu";
    private final String invalidCommentForChecking = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus.";
    private final String successfulText = "Thank you for your interest!\n" + "\n" + "We will contact you ASAP!";
    private final String url = PropertiesReader.get("application.db.url");
    private final String user = PropertiesReader.get("application.db.login");
    private final String password = PropertiesReader.get("application.db.password");
    private String query = "SELECT * FROM andersenlab_stage.form_data fd ORDER BY Id DESC LIMIT 1;";

    int messageWaitingTimeInDB = 90000;

    @Step
    public void scrollToSection(SelenideElement locatorOfSection){
        Warp.scrollToElement(locatorOfSection);
    }

    @Step
    public void positiveValidationNameField(){
        nameField.shouldHave(Condition.attribute("placeholder", "Name"));
        nameField.shouldHave(Condition.attribute("maxlength", "500"));
        actions().moveToElement(nameField).click().sendKeys(validUserName).perform();
        Assert.assertEquals(nameField.getAttribute("value"), validUserName);
    }

    @Step
    public void negativeValidationNameField(){
        nameField.shouldHave(Condition.attribute("placeholder", "Name"));
        nameField.shouldHave(Condition.attribute("maxlength", "500"));
        actions().moveToElement(nameField).click().sendKeys(inValidUserNameForChecking).perform();
        Assert.assertEquals(nameField.getAttribute("value"), inValidUserName);
    }

    @Step
    public void enteringCorporateEmail(){
        actions().moveToElement(emailField).click().sendKeys(corporateEmail).perform();
        Assert.assertEquals(emailField.getAttribute("value"), corporateEmail);
    }

    @Step
    public void enteringNoNCorporateEmail(){
        actions().moveToElement(emailField).click().sendKeys(nonCorporateEmail).perform();
        emailTooltip.shouldBe(Condition.visible).shouldHave(Condition.exactText(emailTooltipText));
        tipUnderThePhoneNumberField.shouldBe(Condition.visible).shouldHave(Condition.exactText(tipUnderThePhoneNumberFieldText));
        Assert.assertEquals(tipUnderThePhoneNumberField.getCssValue("color"), CSSProperties.Color.YELLOW.getCode());
    }

    @Step
    public void negativeValidationEmailField(){
        actions().moveToElement(emailField).click().sendKeys(inValidEmail).perform();
        actions().moveToElement(commentsField).click().perform();
        tipUnderTheEmailField.shouldBe(Condition.visible).shouldHave(Condition.exactText(tipUnderTheEmailFieldText));
        Assert.assertEquals(tipUnderTheEmailField.getCssValue("color"), CSSProperties.Color.YELLOW.getCode());
    }

    @Step
    public void enteringValidPhoneNumber(){
        actions().moveToElement(phoneField).click().sendKeys(validPhoneNumber).perform();
        Assert.assertFalse(tipUnderThePhoneNumberField.isDisplayed());
    }

    @Step
    public void enteringInValidPhoneNumberLessThan5Characters(){
        actions().moveToElement(phoneField).click().perform();
        actions().moveToElement(commentsField).click().perform();
        tipUnderThePhoneNumberField.shouldBe(Condition.visible).shouldHave(Condition.exactText(tipUnderThePhoneNumberFieldText));
        Assert.assertEquals(tipUnderThePhoneNumberField.getCssValue("color"), CSSProperties.Color.YELLOW.getCode());
    }

    @Step
    public void enteringInValidPhoneNumberMoreThan18Characters(){
        actions().moveToElement(phoneField).click().sendKeys(inValidPhoneNumberForChecking).perform();
        Assert.assertEquals(phoneField.getAttribute("value"), inValidPhoneNumber);
    }

    @Step
    public void positiveValidationCommentsField(){
        commentsField.shouldHave(Condition.attribute("placeholder","Comments"));
        commentsField.shouldHave(Condition.attribute("maxlength","500"));
        actions().moveToElement(commentsField).click().sendKeys(validComment).perform();
        Assert.assertEquals(commentsField.getAttribute("value"), validComment);
    }

    @Step
    public void negativeValidationCommentsField(){
        commentsField.shouldHave(Condition.attribute("placeholder","Comments"));
        commentsField.shouldHave(Condition.attribute("maxlength","500"));
        actions().moveToElement(commentsField).click().sendKeys(invalidCommentForChecking).perform();
        Assert.assertEquals(commentsField.getAttribute("value"), invalidComment);
    }

    @Step
    public void clickNda(){
        checkbox.click();
        Assert.assertTrue(selectedCheckbox.isSelected());
    }

    @Step
    public void clickSendButton(){
        sendRequestButton.click();
    }

    @Step
    public void checkSuccessfulModalWindow(){
        successfulModalWindow.shouldBe(Condition.visible);
        successfulModalWindowText.shouldBe(Condition.visible).shouldHave(Condition.exactText(successfulText));
        successfulModalWindowCloseButton.click();
        Assert.assertFalse(successfulModalWindow.isDisplayed());
    }

    /** В данном методе sleep отсутствует, т.к. он реализван в классе ReadEmail,
     и в тесте данный метод используется после ReadEmail*/
    @Step
    public void checkNewRecordInStageDatabaseAllFieldsFilledIn() throws SQLException {
        DbConnectionActual.openConnection(url, user, password);
        ArrayList <String> list = new ArrayList<>();
        list.addAll(DbConnectionActual.selectRecords(DbConnectionActual.createSelectQuery(query)));
        Assert.assertEquals(list.get(1), validUserName);
        Assert.assertEquals(list.get(2), nonCorporateEmail);
        Assert.assertEquals(list.get(3), validPhoneNumberForChecking);
        Assert.assertEquals(list.get(4).substring(list.get(4).indexOf("Hello"),list.get(4).lastIndexOf("\n"+"NDA")), validComment);
        DbConnectionActual.closeConnectionSelect();
    }

    /** В данном методе sleep присутствует, т.к. в тесте в корпоративную почту не заходим,
     а запись в БД появялется спустя некоторое время*/
    @Step
    public void checkNewRecordInStageDatabaseCorporateEmailFilledIn() throws SQLException {
        sleep(messageWaitingTimeInDB);
        DbConnectionActual.openConnection(url, user, password);
        ArrayList <String> list = new ArrayList<>();
        list.addAll(DbConnectionActual.selectRecords(DbConnectionActual.createSelectQuery(query)));
        Assert.assertEquals(list.get(2), corporateEmail);
        DbConnectionActual.closeConnectionSelect();
    }

    @Step
    public void checkNewRecordInStageDatabasePhoneNumberFilledIn() throws SQLException {
        sleep(messageWaitingTimeInDB);
        DbConnectionActual.openConnection(url, user, password);
        ArrayList <String> list = new ArrayList<>();
        list.addAll(DbConnectionActual.selectRecords(DbConnectionActual.createSelectQuery(query)));
        Assert.assertEquals(list.get(3), validPhoneNumberForChecking);
        DbConnectionActual.closeConnectionSelect();
    }
}
package com.andersenlab.autotests.site.form.ourprojectsblock;

import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.DTFPatterns;
import com.andersenlab.autotests.core.db.webdb.Db;
import com.andersenlab.autotests.core.steps.Assertions;
import com.andersenlab.autotests.site.form.commonforms.FormData;
import com.andersenlab.autotests.site.form.consultation.ConsultationFormLocators;
import com.andersenlab.autotests.site.form.spam.Spamable;
import com.andersenlab.autotests.site.form.successwindow.SuccesCase;
import com.andersenlab.autotests.site.form.successwindow.Success;
import com.andersenlab.autotests.site.logic.Navigation;
import com.andersenlab.autotests.site.utility.Warp;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.Wait;
import static java.time.LocalTime.now;

@Getter
public class CaseConcultationForm implements FormData, ConsultationFormLocators, Spamable {
    //т е, объединение приведет к динамическому пересчету локаторов, что удвоит кол строк для локаторов + элементов. нецелесообразно
    private final CaseConsultationFormElements el = new CaseConsultationFormElements();
    private final int index;
    private final CaseCheck caseCheck;
    private final Success success;
    private Country country = Country.US;//значение по умолчанию
    private Pages page = Pages.MOBILE_DEV;//переопределяется сеттером
    private final String title;
    private String subtitle = "";
    private String currentUrl;
    private String uniqNameForCheckedNda = null;
    private String uniqNameForUncheckedNda = null;
    private final String errorMessageAttribute = "forms-module--error";
    private final String route = "find-developers/front-end";

    public CaseConcultationForm(String title, int index) {
        this.title = title;
        this.success = new SuccesCase();
        this.index = index;
        this.caseCheck = new CaseCheck(index);
    }

    //контракт------------------------------------------------------------------------------------------------------------------------------------------

    public void setConditions(final Pages page, final Country country) {
        //вызывать в beforeClass после prepare(page, country);
        this.country = country;
        this.page = page;
        currentUrl = Warp.currentURL();
    }

    public void inputMailValidationPositive() {
        //Валидация поля Corporate E-mail и отправка сообщения (позитивный кейс)
        caseCheck.openCase();
        inputMailPositiveWithChekedNda();
        caseCheck.openCase();
        inputMailPositiveWithUnchekedNda();
    }

    public void inputMailValidationNegative() {
        //Валидация поля Corporate E-mail (негативный кейс)
        caseCheck.openCase();
        emptyInputRequest();
        enterInvalidMail();
        caseCheck.closeCase();
    }

    public void inputPhoneValidationAndSend() {
        //Валидация поля "Phone" и отправка сообщения
        caseCheck.openCase();
        inputValidPhone();
        caseCheck.openCase();
        inputInvalidPhone();
    }

    public void dbRecordCheckedNda() {
        //Запись БД включен чекбокс NDA. dependsOnMethods = "inputMailValidationPositive" БД/form_data/message/NDA - on
        recordIsPresentDb(uniqNameForUncheckedNda, true);
        Navigation.gotoLink(currentUrl);
    }

    public void dbRecordUncheckedNda() {
        //Запись БД чекбокс NDA не включен. dependsOnMethods = "inputPhoneValidationAndSend" БД/form_data/message/NDA - off
        recordIsPresentDb(uniqNameForUncheckedNda, false);
        Navigation.gotoLink(currentUrl);
    }

    public void emailSent() {
        //Отправка обратной связи на почту - косвенно, через БД/form_data/notifyTo/email - ok. проверяем наличие 1/2 записей(см выше)
        emailSentDb(uniqNameForCheckedNda, uniqNameForUncheckedNda);
        Navigation.gotoLink(currentUrl);
    }

    public String goodReq(String mail, String phone) {
        el.getInputMail().sendKeys(mail);
        el.getInputPhone().sendKeys(phone);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DTFPatterns.DEFAULT.getPattern());
        String date = now().format(dtf);
        String uniqName = Spamable.NAME_BASE + date;
        el.getInputName().sendKeys(uniqName);
        if (Spamable.CHECK_BOX) {
            checkTheBoxNda();
        }
        el.getButtonSendReq().click();
        success.checkAndClose();
        return uniqName;
    }

    public void precondition() {
        String page = WebDriverRunner.getWebDriver().getCurrentUrl() + route;
        Navigation.gotoLink(page);
    }

    //контракт------------------------------------------------------------------------------------------------------------------------------------------

    @Step
    protected void inputMailPositiveWithChekedNda()
    {
        enterNotCooperateMail();
        enterValidPhone();
        uniqNameForCheckedNda = makeUniqName();
        enterName(uniqNameForCheckedNda);
        checkTheBoxNda();
        sendRequest();
        closeSuccessWindow(currentUrl);
    }

    @Step
    protected void inputMailPositiveWithUnchekedNda(){
        uniqNameForUncheckedNda = makeUniqName();
        enterName(uniqNameForUncheckedNda);
        enterCooperateMail();
        sendRequest();
        closeSuccessWindow(currentUrl);
        Warp.delay(FormData.DELAY); //нехорошо, но иначе только в потоках/за разные пробеги через файл и т д
    }

    @Step
    protected void inputValidPhone(){
        enterValidPhone();
        sendRequest();
        closeSuccessWindow(currentUrl);
    }

    @Step
    protected void inputInvalidPhone(){
        enterInvalidPhone();
    }

    @Step
    public void checkTitle() {
        Assert.assertEquals(el.getTitle().getText(), title);
        Assert.assertTrue(el.getTitle().isDisplayed());
    }

    @Step
    public void checkSubtitle() {
        Assert.assertEquals(el.getSubtitle().getText(), subtitle);
        Assert.assertTrue(el.getSubtitle().isDisplayed());
    }

    @Step
    public void checkForm(){
        //check name
        Assert.assertEquals(el.getInputName().getAttribute("placeholder"), el.getInputNamePlaceholder());
        //check email
        Assert.assertEquals(el.getInputMail().getAttribute("placeholder"), el.getInputMailPlaceholder());
        //check phone
        Assert.assertEquals(el.getInputPhone().getAttribute("value"), el.getInputPhoneMask());
        Assert.assertEquals(el.getInputPhone().getAttribute("placeholder"), el.getInputPhonePlaceholder());
        //check comments
        Assert.assertEquals(el.getInputComment().getAttribute("placeholder"), el.getInputCommentsPlaceholder());
        //check NDA checkbox
        Assert.assertEquals(el.getCheckBoxText().getText(), el.getNDACheckbox());
        //check NDA info popup
        checkInfoPopup();
    }

    @Step
    private void checkInfoPopup(){
        Warp.scrollToElement(el.getHintForNDA());
        el.getHintForNDA().click();
        Wait().until(ExpectedConditions.visibilityOf(el.getHintTextForNDA()));
        Assert.assertEquals(el.getHintTextForNDA().getText(), el.getNDAPopupInfo());
        el.getCloseHintForNDA().click();
        Assert.assertFalse(el.getHintTextForNDA().isDisplayed());
    }

    @Step
    private void enterNotCooperateMail() {
        Warp.scrollToElement(el.getInputMail());
        el.getInputMail().sendKeys(MAIL_NOT_COOPERATE);
        Wait().until(ExpectedConditions.visibilityOfElementLocated(HINT_MAIL_COOPER));
        Assertions.elementShouldBeVisible(HINT_MAIL_COOPER);
        Assertions.elementShouldHaveText(HINT_MAIL_COOPER, TEXT_HINT_MAIL_COOPER);
    }

    @Step
    private void enterName(String name) {
        el.getInputName().sendKeys(name);
    }

    private String makeUniqName() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        String date = now().format(dtf);
        return NAME + date;
    }

    @Step
    public void checkTheBoxNda() {
        Warp.clickUntouchable(el.getCheckBoxProtect(), -27, 0);
    }

    @Step
    private void enterValidPhone() {
        el.getInputPhone().sendKeys(PHONE_VALID);
        Assert.assertTrue(el.getInputPhone().isDisplayed());
    }

    @Step
    private void sendRequest() {
        el.getButtonSendReq().click();
    }

    @Step
    private void closeSuccessWindow(String expectedUrl) {
        success.checkAndClose();
        Assert.assertEquals(expectedUrl, Warp.currentURL());
    }

    @Step
    private void enterCooperateMail() {
        el.getInputMail().sendKeys(MAIL_COOPERATE);
        Assert.assertTrue(el.getInputMail().isDisplayed());
    }

    @Step
    private void emptyInputRequest() {
        el.getButtonSendReq().click();
        Assert.assertEquals(el.getAskPhone().getText(), TEXT_ASK_PHONE);
        Assert.assertEquals(el.getAskMail().getText(), TEXT_ASK_MAIL);
        Assert.assertTrue(el.getAskPhone().getAttribute("class").contains(errorMessageAttribute)
                && el.getAskMail().getAttribute("class").contains(errorMessageAttribute));
    }

    @Step
    private void enterInvalidMail() {
        el.getInputMail().sendKeys(MAIL_INVALID);
        el.getInputPhone().click();
        Assert.assertEquals(el.getAskMail().getText(), TEXT_ASK_MAIL);
        Assert.assertTrue(el.getAskMail().getAttribute("class").contains(errorMessageAttribute));
    }

    @Step
    private void enterInvalidPhone() {
        el.getInputPhone().sendKeys(PHONE_INVALID);
        el.getInputName().click();
        Assert.assertEquals(el.getAskPhone().getText(), TEXT_ASK_PHONE);
        Warp.delay(3);
        Assert.assertTrue(el.getAskPhone().getAttribute("class").contains(errorMessageAttribute));
    }

    @Step
    private void recordIsPresentDb(String name) {
        if (name == null) Assert.fail("precondition not met");
        final String QUERY = "SELECT * FROM `form_data` WHERE `email` = 'qaands+3@gmail.com' AND `name`='" + name + "'  AND `message` LIKE '%NDA - on%' AND `date` BETWEEN \n" +
                "DATE_SUB(NOW(), INTERVAL 1 DAY) AND NOW() ORDER BY `id` DESC LIMIT 30";
        Db db = new Db();
        Assert.assertTrue(db.recordIsPresent(QUERY, 300));
    }

    @Step
    private void scrollTo() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        Actions action = new Actions(driver);
        action.moveToElement(el.getButtonSendReq()).build().perform();
    }

    @Step
    private void refreshPage() {
        Navigation.gotoLink(Warp.currentURL()); //FIXME зачем, если есть в Warp??
    }

    private void recordIsPresentDb(final String name, final boolean NDA) {//NDA=true - box checked
        if (name == null) Assert.fail("precondition not met");
        final String QUERY = "SELECT * FROM `form_data` WHERE `email` = '"
                + ((NDA) ? FormData.MAIL_NOT_COOPERATE : FormData.MAIL_COOPERATE)
                + "' AND `name`='" + name + "'  AND `message` LIKE '%"
                + ((NDA) ? "NDA - on" : "NDA - off")
                + "%' AND `date` BETWEEN \n" +
                "DATE_SUB(NOW(), INTERVAL 1 DAY) AND NOW() ORDER BY `id` DESC LIMIT 30";
        Db db = new Db();
        Assert.assertTrue(db.recordIsPresent(QUERY, 300));
    }

    private void emailSentDb(final String name1, final String name2) {
        if (name1 == null & name2 == null) Assert.fail("precondition not met");//для этой нам нужно хоть одно имя в базе
        String name = (name1 != null) ? name1 : name2;//если не упали выше, то одно не нулл
        final String QUERY = "SELECT * FROM `form_data` \n" +
                "WHERE (`email` = 'qaands+3@gmail.com' OR `email` = 'qaands@andersenlab.com') \n" +
                "AND `name`='" + name + "' AND `notifyTo` LIKE '%email - ok%' \n" +
                "AND `date` BETWEEN DATE_SUB(NOW(), INTERVAL 1 DAY) AND NOW() ORDER BY `id` DESC LIMIT 30";
        Db db = new Db();
        Assert.assertTrue(db.recordIsPresent(QUERY, 300));
    }
}
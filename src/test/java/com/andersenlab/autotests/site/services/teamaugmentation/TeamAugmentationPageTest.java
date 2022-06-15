package com.andersenlab.autotests.site.services.teamaugmentation;

import com.andersenlab.autotests.core.configs.basetest.BaseTest2;
import com.andersenlab.autotests.core.configs.basetest.Pages;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.gmail.ReadEmail;
import com.andersenlab.autotests.core.listeners.SelenideListener;
import com.andersenlab.autotests.site.blocks.CheckingThePresenceOfBlocks;
import com.andersenlab.autotests.site.form.contactusfooterform.ContactUsFooterForm;
import com.andersenlab.autotests.site.form.mainformforleads.MainFormForLeads;
import com.andersenlab.autotests.site.form.popup.requestform.RequestForm;
import com.andersenlab.autotests.site.page.services.augmentation.TitleAndDescriptionMeta;
import com.andersenlab.autotests.site.page.services.augmentation.benefits.Benefits;
import com.andersenlab.autotests.site.page.services.augmentation.calculator.Calculator;
import com.andersenlab.autotests.site.page.services.augmentation.contactus.ContactUs;
import com.andersenlab.autotests.site.page.services.augmentation.dynamicblockarchitecturebauxui.DynamicBlock;
import com.andersenlab.autotests.site.page.services.augmentation.intro.DedicatedTeamPage;
import com.andersenlab.autotests.site.page.services.augmentation.strengthenyours.StrengthenYours;
import com.andersenlab.autotests.site.page.services.augmentation.testimonials.CustomerRewiewsData;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.businessdomains.BusinessDomains;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.companyofexpert.CompanyOfExperts;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviews;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.projectmap.ProjectMap;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;

@Epic("Site")
@Listeners(SelenideListener.class)
public class TeamAugmentationPageTest extends BaseTest2 {

    private final Pages page = Pages.TEAM_AUGMENTATION;
    private final Country country = Country.NOT_SPECIFIED;

    private DedicatedTeamPage dedicatedTeamPage;
    private StrengthenYours strengthenYours;
    private Benefits benefits;
    private ProjectMap projectMap;
    private BusinessDomains businessDomains;
    private ContactUs contactUs;
    private CompanyOfExperts companyOfExperts;
    private Calculator calculator;
    private MainFormForLeads mainFormForLeads;
    private CheckingThePresenceOfBlocks checkingThePresenceOfBlocks;

    @BeforeClass(alwaysRun = true)
    @Override
    protected void beforeClass() {
        prepare(page, country);
        dedicatedTeamPage = new DedicatedTeamPage();
        strengthenYours = new StrengthenYours();
        benefits = new Benefits();
        projectMap = new ProjectMap();
        businessDomains = new BusinessDomains();
        contactUs = new ContactUs();
        companyOfExperts = new CompanyOfExperts();
        calculator = new Calculator();
        mainFormForLeads = new MainFormForLeads();
        checkingThePresenceOfBlocks = new CheckingThePresenceOfBlocks();
    }


    @TmsLink("5605355")
    @Test(description = "Title и Description страницы", priority = 10)
    public void testMetaTitleDescription() {
        dedicatedTeamPage.checkMetaTitle(TitleAndDescriptionMeta.TEAM_AUGMENTATION);
        dedicatedTeamPage.checkMetaDescription(TitleAndDescriptionMeta.TEAM_AUGMENTATION);
    }

    @TmsLink("5276432")
    @Test(description = "Отображение и функциональность блока Intro", priority = 20)
    public void displayingIntro() {
        dedicatedTeamPage.checkMetaTitle(TitleAndDescriptionMeta.TEAM_AUGMENTATION);
    }

    @TmsLink("5605394")
    @Test(description = "Отображение и функционал блока с буллетами", priority = 30)
    public void testBulletsBox() {
        strengthenYours.isPresentStartElements();
        strengthenYours.checkBulletsBox();
        strengthenYours.getRequestSpecialistBtn().click();
        strengthenYours.getModal().checkHoverAndPointerSendReqBtn();
        strengthenYours.getModal().checkToolType();
        strengthenYours.getModal().checkCheckBox();
        strengthenYours.getModal().checkReCaptchaLink();
    }

    @TmsLink("5341969")
    @Test(description = "Отображение блока с сертификатами 'Company of experts'", priority = 40)
    public void displayingCompanyOfExperts() {
        companyOfExperts.displayingElements(15);
    }

    @TmsLink("5605395")
    @Test(description = "Отображение блока 'Team augmentation benefits'", priority = 50)
    public void testBenefits() {
        benefits.checkIntro();
        benefits.checkArticlesAmount();
    }

    @TmsLink("5559394")
    @Test(description = "Отображение и функциональность блока архитектура + BA + UI/UX", priority = 60)
    public void displayingDynamicBlock() {
        DynamicBlock block = new DynamicBlock(new RequestForm("Contact us"));
        block.displayingElements();
    }

    @TmsLink("5286284 & 5286914")
    @Test (description = "Отображение и функционал блока с калькулятором",priority = 70,
    groups = "Calculators group")
    public void calculatorTest (){
        calculator.checkYourDevelopmentTeamBlock();
        calculator.checkYouMayAlsoIncludeBlock();
        calculator.checkBusinessIndustryBlock();
        calculator.durationOfYourProjectBlock();
        calculator.checkSendFormBlock();
    }

    @TmsLink("5394217 & 5619411")
    @Test(description = "Отображение и функциональность блока 'Real Time Projects Map'", priority = 80)
    public void checkRealTimeMap(){
        projectMap.checkMapWithFilters();
        projectMap.checkProjectPortfolioSubBlock();
    }

    @TmsLink("5344987")
    @Test (description = "Отображение и функциональность блока Expert custom solutions", priority = 90)
    public void checkExpertCustomSolutions(){
        businessDomains.displayingElements();
    }

    @TmsLink("5366481")
    @Test(description = "Отображение и функциональность блока Testimonials", priority = 100)
    public void displayingCustomerReviews() {
        CustomerReviews block = new CustomerReviews(new CustomerRewiewsData());
        block.displayingElements();
    }

    @TmsLink("5619875")
    @Test(description = "Отображение и функционал блока Contact us ...", priority = 110)
    public void displayingContactUs() {
        contactUs.displayingElements();
    }

    @TmsLink("5678817")
    @Test(description = "[EN] Отображение и функциональность контактной формы в блоке с буллетами, где текст кнопки 'Request specialist'", priority = 120, groups = "Checking the main form for leads")
    public void checkMainFormForLeads(){
        mainFormForLeads.scrollToButtonAndCheckTitle(mainFormForLeads.getButtonInMainModule(), "Request specialists");
        mainFormForLeads.checkEmailField();
        mainFormForLeads.checkPhoneField();
        mainFormForLeads.checkNda();
        mainFormForLeads.sendFormAndCheckSuccessfulModalWindow();
    }

    @TmsLink("5803694")
    @Test(description = "Проверить наличие блоков", priority = 130, groups = "Checking the blocks")
    public void checkBlocks(){
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getIntro());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getArchitect());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCalculator());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCompanyOfExperts());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getCustomSolutions());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getFeature());
        checkingThePresenceOfBlocks.checkAnyBlockForExistence(checkingThePresenceOfBlocks.getGetConsultation());
    }
}
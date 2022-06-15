package com.andersenlab.autotests.core.configs.basetest;

import com.andersenlab.autotests.core.configs.SelenideConfiguration;
import com.andersenlab.autotests.core.configs.constants.Country;
import com.andersenlab.autotests.core.configs.constants.Resolution;
import com.andersenlab.autotests.core.utils.utility.Utility;
import com.andersenlab.autotests.site.logic.Navigation;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

public abstract class BaseTest2 {
    protected Pages p;
    protected Country c;
    private ArrayList<String> tabs2;

    @BeforeClass(alwaysRun = true)
    protected void beforeClass() {
        prepare(p, c);
    }

    @BeforeMethod(alwaysRun = true)
    protected void beforeMethod() {
        Selenide.refresh();
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
    }

    @AfterClass(alwaysRun = true)
    protected void afterClass() {
        Selenide.closeWebDriver();
    }

    protected void prepare(Pages page, Country country) {
        SelenideConfiguration.configure(Resolution.DESKTOP, country);
        openPage(page);
        Utility.operations.acceptCookies();
    }

    protected void prepare(Pages page, Resolution resolution) {
        SelenideConfiguration.configure(resolution);
        openPage(page);
        Utility.operations.acceptCookies();
    }

    protected void openPage(Pages page){
        switch (page) {
            case HOMEPAGE:
                Navigation.openHomeDev();
                break;
            case ABOUT_US:
                Navigation.openAboutUs();
                break;
            case CAREERS:
                Navigation.openCareers();
                break;
            case TESTIMONIALS:
                Navigation.openTestimonials();
                break;
            case OUR_PROJECTS:
                Navigation.openOurProjects();
                break;
            case CORPORATE_SOCIAL_RESPONSIBILITY:
                Navigation.openCorporateSocialResponsibility();
                break;
            case CORPORATE_LIFE:
                Navigation.openCorporateLife();
                break;
            case PRIVACY_POLICY:
                Navigation.openPrivacyPolicy();
                break;
            case PROJECT_CASES:
                Navigation.openProjectCases();
                break;
            case PROMOCODES:
                Navigation.openPromocodes();
                break;

            //techstack
            //frontend
            case FRONTEND:
                Navigation.toFrontEnd();
                break;
            case ANGULAR:
                Navigation.toAngular();
                break;
            case JAVASCRIPT:
                Navigation.toJavascript();
                break;
            case REACT_JS:
                Navigation.toReactJS();
                break;
            case VUE_JS:
                Navigation.toVueJS();
                break;
            //backend
            case BACKEND:
                Navigation.toBackEnd();
                break;
            case JAVA:
                Navigation.toJava();
                break;
            case DOT_NET:
                Navigation.toDotNet();
                break;
            case PHP:
                Navigation.toPHP();
                break;
            case PYTHON:
                Navigation.toPython();
                break;
            case RUBY:
                Navigation.toRuby();
                break;
            case NODE_JS:
                Navigation.toNodeJS();
                break;
            case SCALA:
                Navigation.toScala();
                break;
            case GOLANG:
                Navigation.toGolang();
                break;
            case C_CPP:
                Navigation.toCandCPP();
                break;
            case RUST:
                Navigation.toRust();
                break;
            //mobile
            case MOBILE:
                Navigation.toMobile();
                break;
            case ANDROID:
                Navigation.toAndroid();
                break;
            case IOS:
                Navigation.toIOS();
                break;
            case IONIC:
                Navigation.toIonic();
                break;
            case XAMARIN:
                Navigation.toXamarin();
                break;
            case REACT_NATIVE:
                Navigation.toReactNative();
                break;
            case FLUTTER:
                Navigation.toFlutter();
                break;

            //industries
            case E_COMMERCE:
                Navigation.toECommerce();
                break;
            case FINANCIAL_SERVICES:
                Navigation.toFinancialServices();
                break;
            case E_LEARNING:
                Navigation.toELearning();
                break;
            case TRAVEL_AND_HOSPITALITY:
                Navigation.toTravelAndHospitality();
                break;
            case HEALTHCARE:
                Navigation.toHealthcare();
                break;
            case MEDIA_AND_ENTERTAINMENT:
                Navigation.toMediaAndEntertainment();
                break;
            case REAL_ESTATE:
                Navigation.toRealEstate();
                break;
            case TELECOM:
                Navigation.toTelecom();
                break;
            case CUSTOM_IGAMING_SOFTWARE_DEVELOPMENT:
                Navigation.toCustomIGamingSoftwareDevelopment();
                break;
            case LOGISTICS:
                Navigation.toLogistics();
                break;
            case ENTERPRISE:
                Navigation.toEnterprise();
                break;
            case RETAIL:
                Navigation.toRetail();
                break;
            case AUTOMOTIVE:
                Navigation.toAutomotive();
                break;

            //industries subpage
            case BETTING:
                Navigation.toBetting();
                break;
            case IGAMING_PLATFORM_DEVELOPMENT:
                Navigation.toIGamingPlatformDevelopment();
                break;
            case IGAMING_PLATFORM_SECURITY:
                Navigation.toIGamingPlatformSecurity();
                break;
            case PLATFORM_DEVELOPMENT:
                Navigation.toPlatformDevelopment();
                break;
            case PRODUCTION_OPERATIONS_SUPPORT:
                Navigation.toProductionOperationsSupport();
                break;
            case DANIEL_KRAFTON_HEALTH_TECHS_FUTURE:
                Navigation.toDanielKraftOnHealthTechsFuture();
                break;
            case INTEGRATIONS:
                Navigation.toIntegrations();
                break;
            case MULTI_DEVICES_BROWSERS_SUPPORT:
                Navigation.toMultiDevicesBrowsersSupport();
                break;
            case UIUX_GAMEART_DESIGN:
                Navigation.toUIUXGameArtDesign();
                break;
            case EMR_SOLUTIONS:
                Navigation.toEmrSolutions();
                break;
            case CUSTOM_EHR_DEVELOPMENT:
                Navigation.toCustomEHRDevelopment();
                break;
            case EHR_CUSTOMIZATION:
                Navigation.toEHRCustomization();
                break;
            case EHR_INTEGRATION:
                Navigation.toEHRIntegration();
                break;
            case DATA_ANALYTICS_AND_IOMT:
                Navigation.toDataAnalyticsAndIOMT();
                break;
            case CUSTOM_MEDICAL_SOFTWARE:
                Navigation.toCustomMedicalSoftware();
                break;
            case TELEHEATH_SOLUTIONS:
                Navigation.toTelehealthSolutions();
                break;
            case FINANCIAL_SERVICES_BANKING:
                Navigation.toFinancialServicesBanking();
                break;
            case BANKING_BIGDATA_SOLUTIONS:
                Navigation.toBankingBigDataSolutions();
                break;
            case BANKING_DIGITAL_TRANSFORMATION:
                Navigation.toBankingDigitalTransformation();
                break;
            case BANKING_INTEGRATION_SOFTWARE:
                Navigation.toBankingIntegrationSoftware();
                break;
            case CORE_BANKING_SOFTWARE_SOLUTIONS:
                Navigation.toCoreBankingSoftwareSolutions();
                break;
            case CUSTOM_LOAN_SOFTWARE_SOLUTIONS:
                Navigation.toCustomLoanSoftwareSolutions();
                break;
            case DIGITAL_BANKING_SOFTWARE_DEVELOPMENT:
                Navigation.toDigitalBankingSoftwareDevelopment();
                break;
            case CUSTOM_BLOCKCHAIN_SOFTWARE_DEVELOPMENT:
                Navigation.toCustomBlockchainSoftwareDevelopment();
                break;
            case FINANCIAL_SERVICES_FINTECH:
                Navigation.toFinancialServicesFintech();
                break;
            case ALTERNATIVE_LENDING_SOFTWARE:
                Navigation.toAlternativeLendingSoftware();
                break;
            case CLOUD_FINTECH_SOLUTIONS:
                Navigation.toCloudFintechSolutions();
                break;
            case CRYPTO_CURRENCY_DEVELOPMENT_SERVICES:
                Navigation.toCryptocurrencyDevelopmentServices();
                break;
            case CUSTOM_DIGITAL_WALLET_DEVELOPMENT:
                Navigation.toCustomDigitalWalletDevelopment();
                break;
            case FINTECH_PAYMENT_SOLUTIONS:
                Navigation.toFintechPaymentSolutions();
                break;
            case PERSONAL_FINANCE_SOLUTIONS:
                Navigation.toPersonalFinanceSolutions();
                break;
            case FINANCIAL_SERVICES_INVESTMENT:
                Navigation.toFinancialServicesInvestment();
                break;
            case ASSET_MANAGEMENT_SOFTWARE:
                Navigation.toAssetManagementSoftware();
                break;
            case CUSTOM_TRADING_SOFTWARE:
                Navigation.toCustomTradingSoftware();
                break;
            case FINANCIAL_ANALYSIS_SOFTWARE:
                Navigation.toFinancialAnalysisSoftware();
                break;
            case INVESTMENT_COMPLIANCE_DEVELOPMENT:
                Navigation.toInvestmentComplianceDevelopment();
                break;
            case MOBILE_INVESTMENT_SOFTWARE:
                Navigation.toMobileInvestmentSoftware();
                break;
            case TRADING_API_DEVELOPMENT:
                Navigation.toTradingApiDevelopment();
                break;
            case FINANCIAL_SERVICES_INSURANCE:
                Navigation.toFinancialServicesInsurance();
                break;
            case MEDICAL_PRACTICE_MANAGEMENT_SOFTWARE:
                Navigation.toMedicalPracticeManagementSoftware();
                break;
            case HEALTHCARE_SOFTWARE_DEVELOPERS:
                Navigation.toHealthcareSoftwareDevelopers();
                break;
            case REVENUE_CYCLE_MANAGEMENT_SOFTWARE:
                Navigation.toRevenueCycleManagementSoftware();
                break;
            case REMOTE_PATIENT_MONITORING_SOFTWARE:
                Navigation.toRemotePatientMonitoringSoftware();
                break;
            case PACS_DICOM_SOFTWARE:
                Navigation.toPacsDicomSoftware();
                break;
            case HEALTH_INFORMATION_MANAGEMENT_SOFTWARE:
                Navigation.toHealthInformationManagementSoftware();
                break;
            case HEALTHCARE_AI_SOFTWARE_SOLUTIONS:
                Navigation.toHealthcareAISoftwareSolutions();
                break;
            case CUSTOM_ASSISTIVE_TECHNOLOGY_SOFTWARE_SOLUTIONS:
                Navigation.toCustomAssistiveTechnologySoftwareSolutions();
                break;
            case MOBILE_HEALTHCARE_APPLICATIONS:
                Navigation.toMobileHealthcareApplications();
                break;
            case MENTAL_HEALTH_DIGITAL_SOLUTIONS:
                Navigation.toMentalHealthDigitalSolutions();
                break;
            case HEALTH_INFORMATION_EXCHANGE_SOFTWARE:
                Navigation.toHealthInformationExchangeSoftware();
                break;
            case HEALTH_INFORMATION_SECURITY_AND_COMPLIANCE:
                Navigation.toHealthInformationSecurityAndCompliance();
                break;
            case HOSPITAL_MANAGEMENT_SOFTWARE:
                Navigation.toHospitalManagementSoftware();
                break;
            case ORDER_MANAGEMENT_SOFTWARE_DEVELOPMENT:
                Navigation.toOrderManagementSoftwareDevelopment();
                break;
            case TRANSPORTATION_MANAGEMENT_SOFTWARE_DEVELOPMENT:
                Navigation.toTransportationManagementSoftwareDevelopment();
                break;
            case WAREHOUSE_MANAGEMENT_SOFTWARE_DEVELOPMENT:
                Navigation.toWarehouseManagementSoftwareDevelopment();
                break;
            case INVENTORY_MANAGEMENT_SOFTWARE_DEVELOPMENT:
                Navigation.toInventoryManagementSoftwareDevelopment();
                break;

            //services
            case MOBILE_DEV:
                Navigation.toMobileDevelopment();
                break;
            case CUSTOM_SOFTWARE:
                Navigation.toCustomSoftware();
                break;
            case MEET_US_TOMORROW:
                Navigation.toMeetUsTomorrow();
                break;
            case BLOG:
                Navigation.openBlog();
                break;
            case PRICING:
                Navigation.openPricing();
                break;
            case SALES_FORCE:
                Navigation.toSalesForce();
                break;
            case QA:
                Navigation.toQa();
                break;
            case BA:
                Navigation.toBa();
                break;
            case MAINTENANCE:
                Navigation.toMaintenance();
                break;
            case TEAM_AUGMENTATION:
                Navigation.toTeamAugmentation();
                break;
            case WEB_DEVELOPMENT_SERVICES:
                Navigation.toWebDevelopmentServices();
                break;
            case PRODUCT_DEVELOPMENT_SERVICES:
                Navigation.toProductDevelopmentServices();
                break;
            case UIUX_DESIGN:
                Navigation.toUIUXDesignStudio();
                break;
            case DEVOPS_SERVICES:
                Navigation.toDevOpsServices();
                break;
            case SOLUTION_ARCHITECTURE_SERVICES:
                Navigation.toSolutionArchitectureServices();
                break;
            case CLOUD_DEVELOPMENT_SERVICES:
                Navigation.toCloudDevelopmentServices();
                break;
            case IT_SECURITY_SERVICES:
                Navigation.toITSecurityServices();
                break;
            case DISCOVERY_PHASE_FOR_SOFTWARE_PROJECT:
                Navigation.toDiscoveryPhaseForSoftwareProject();
                break;
            case AGILE_IT_PROJECT_MANAGEMENT:
                Navigation.toAgileITProjectManagement();
                break;
            case DATA_SCIENCE:
                Navigation.toDataScience();
                break;
            case OUTSOURCED_IT_SERVICES:
                Navigation.toOutsourcedITServices();
                break;


            //services subpage
            case UIUX_DESIGN_AUDIT:
                Navigation.toUiUxDesignAudit();
                break;
            case PRODUCT_DESIGN_SERVICES:
                Navigation.toProductDesignServices();
                break;
            case MOBILE_DESIGN:
                Navigation.toMobileDesign();
                break;
            case WEB_DESIGN:
                Navigation.toWebDesign();
                break;
            case BRANDING_DESIGN:
                Navigation.toBrandingDesign();
                break;
            case GRAPHIC_DESIGN:
                Navigation.toGraphicDesign();
                break;
            case OUTSOURCED_CALL_CENTER:
                Navigation.toOutsourcedCallCenterServices();
                break;
            case DISCOVERY_PHASE:
                Navigation.toDiscoveryPhase();
                break;
            case ADVANCED_IT_SUPPORT_SERVICES:
                Navigation.toAdvancedITSupportServices();
                break;
            case INFRASTRUCTURE_AND_DEVELOPMENT_SUPPORT:
                Navigation.toInfrastructureAndDevelopmentSupportServices();
                break;
            case AMAZON_WEB_SERVICES:
                Navigation.toAmazonWebServices();
                break;
            case ADVANCED_CUSTOMER_SUPPORT:
                Navigation.toAdvancedCustomerSupport();
                break;
            case IT_EXPENSE_OPTIMIZATION:
                Navigation.toITExpenseOptimization();
                break;
            case IT_SERVICE_REPORTS:
                Navigation.toITServiceReports();
                break;
            case ADVANCED_TECHNICAL_SUPPORT_FOR_USERS:
                Navigation.toAdvancedTechnicalSupportForUsers();
                break;
            case ANDERSEN_QA_COMMUNITY:
                Navigation.toAndersenQaCommunity();
                break;
            case AUTOMATION_TESTING_SERVICES:
                Navigation.toAutomationTestingServices();
                break;
            case QA_AUDIT_SERVICES:
                Navigation.toQAAuditServices();
                break;
            case MANAGED_TESTING_SERVICES:
                Navigation.toManagedTestingServices();
                break;
            case CUSTOM_TESTING_SERVICES:
                Navigation.toCustomTestingServices();
                break;
        }
    }
}

package com.andersenlab.autotests.site.logic;

import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.andersenlab.autotests.site.page.homepage.HomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class Navigation {

    private static final String BASE = System.getProperty("application.url", "https://stage.andersenlab.com");
    private static final String SERVICES = "/services";
    private static final String INDUSTRIES = "/industries";
    private static final String TECHSTACK = "/find-developers";
    private static final String COMPANY = "/company";
    private static final String FINANCIAL_SERVICES = "/financial-services";
    private static final String HEALTHCARE = "/healthcare";
    private static final String DESIGN_STUDIO = "/design-studio";
    private static final String MAINTENANCE_SUPPORT = "/maintenance-support";

    @Step
    public static void openHomeDev() {
        open(BASE);
    }

    @Step
    public static void gotoLink(String link) {
        open(link);
    }

    @Step
    public static void openBlogUrl() {
        open(PropertiesReader.get("application.blog.url"));
    }

    @Step
    public static void openPricing() {
        open(BASE + "/pricing");
    }


    /** Company */
    @Step
    public static void openBlog() {
        open(BASE + COMPANY + "/articles");
    }

    @Step
    public static void openTestimonials() {
        open(BASE + COMPANY + "/testimonials");
    }

    @Step
    public static void openAboutUs() {
        open(BASE + "/about-us");
    }

    @Step
    public static void openOurProjects() {
        open(BASE + "/our-projects");
    }

    @Step
    public static void openCareers() {
        open(BASE + "/careers");
    }

    @Step
    public static void openCorporateSocialResponsibility() {
        open(BASE + "/corporate-social-responsibility");}

    @Step
    public static void openPrivacyPolicy() {
        open(BASE + "/privacy-policy");
    }

    @Step
    public static void openProjectCases() {
        open(BASE + "/project-cases");
    }

    @Step
    public static void openPromocodes() {
        open(BASE + "/promocodes");
    }

    @Step
    public static void openCorporateLife() {
        open(BASE + "/corporate-life");
    }



    /** Services */
    @Step
    public static void toCustomSoftware() {
        open(BASE + SERVICES + "/custom-software-development");
    }

    @Step
    public static void toTeamAugmentation() {
        open(BASE + SERVICES +"/dedicated-team");
    }

    @Step
    public static void toMobileDevelopment() {
        open(BASE + SERVICES + "/mobile-development");
    }

    @Step
    public static void toSalesForce() {
        open(BASE + SERVICES + "/salesforce");
    }

    @Step
    public static void toQa() {
        open(BASE + SERVICES + "/quality-assurance-services");
    }

    @Step
    public static void toBa() {
        open(BASE + SERVICES + "/business-analysts");
    }

    @Step
    public static void toMaintenance() {
        open(BASE + SERVICES + MAINTENANCE_SUPPORT);
    }

    @Step
    public static void toWebDevelopmentServices() {
        open(BASE + SERVICES + "/web-development");
    }

    @Step
    public static void toProductDevelopmentServices() {
        open(BASE + SERVICES + "/product-development-services");
    }

    @Step
    public static void toUIUXDesignStudio() {
        open(BASE + SERVICES + DESIGN_STUDIO);
    }

    @Step
    public static void toDevOpsServices() {
        open(BASE + SERVICES + "/devops");
    }

    @Step
    public static void toSolutionArchitectureServices() {
        open(BASE + SERVICES + "/architecture");
    }

    @Step
    public static void toCloudDevelopmentServices() {
        open(BASE + SERVICES + "/cloud-development-services");
    }

    @Step
    public static void toITSecurityServices() {
        open(BASE + SERVICES + "/security-management");
    }

    @Step
    public static void toDiscoveryPhaseForSoftwareProject() {open(BASE + SERVICES + "/discovery-phase");}

    @Step
    public static void toAgileITProjectManagement () {
        open(BASE + SERVICES + "/project-managers");
    }

    @Step
    public static void toDataScience() {
        open(BASE + SERVICES + "/data-science");
    }

    @Step
    public static void toOutsourcedITServices() {
        open(BASE + SERVICES + "/outsourced-it-services");
    }


    /** Services subpages */
    @Step
    public static void toUiUxDesignAudit() {
        open(BASE + SERVICES + DESIGN_STUDIO + "/audit");}

    @Step
    public static void toProductDesignServices() {
        open(BASE + SERVICES + DESIGN_STUDIO + "/product-design-services");}

    @Step
    public static void toMobileDesign() {
        open(BASE + SERVICES + DESIGN_STUDIO + "/mobile-design");}

    @Step
    public static void toWebDesign() {
        open(BASE + SERVICES + DESIGN_STUDIO + "/web-design");}

    @Step
    public static void toBrandingDesign() {
        open(BASE + SERVICES + DESIGN_STUDIO + "/branding-design");}

    @Step
    public static void toGraphicDesign() {
        open(BASE + SERVICES + DESIGN_STUDIO + "/graphic-design-services");}

    @Step
    public static void toAdvancedITSupportServices() {
        open(BASE + SERVICES + MAINTENANCE_SUPPORT + "/advanced-it-support");}

    @Step
    public static void toAdvancedCustomerSupport() {
        open(BASE + SERVICES + MAINTENANCE_SUPPORT + "/advanced-it-support/andersen-advanced-customer-support");}

    @Step
    public static void toITExpenseOptimization() {
        open(BASE + SERVICES + MAINTENANCE_SUPPORT + "/advanced-it-support/andersen-it-expense-optimization");}

    @Step
    public static void toAdvancedTechnicalSupportForUsers() {
        open(BASE + SERVICES + MAINTENANCE_SUPPORT + "/advanced-it-support/andersen-user-tech-support");}

    @Step
    public static void toITServiceReports() {
        open(BASE + SERVICES + MAINTENANCE_SUPPORT + "/advanced-it-support/andersen-it-service-comprehensive-reporting");}

    @Step
    public static void toOutsourcedCallCenterServices() {
        open(BASE + SERVICES + MAINTENANCE_SUPPORT + "/help-desk-and-call-center");}

    @Step
    public static void toInfrastructureAndDevelopmentSupportServices() {
        open(BASE + SERVICES + MAINTENANCE_SUPPORT + "/infrastructure-development-support");}

    @Step
    public static void toAmazonWebServices() {
        open(BASE + SERVICES + "/cloud-development-services/amazon-web-services");}

    @Step
    public static void toAndersenQaCommunity() {
        open(BASE + SERVICES + "/quality-assurance-services/andersen-qa-community");}

    @Step
    public static void toAutomationTestingServices() {
        open(BASE + SERVICES + "/quality-assurance-services/automation-testing-services");}

    @Step
    public static void toManagedTestingServices() {
        open(BASE + SERVICES + "/quality-assurance-services/qa-management");}

    @Step
    public static void toCustomTestingServices() {
        open(BASE + SERVICES + "/quality-assurance-services/custom-qa-services");}

    @Step
    public static void toQAAuditServices() {
        open(BASE + SERVICES + "/quality-assurance-services/qa-audit-services");}

    @Step
    public static void toDiscoveryPhase() {
        open(BASE + SERVICES + "/business-analysts/andersen-it-project-discovery-phase");}

    /** Industries */
    @Step
    public static void toELearning() {
        open(BASE + INDUSTRIES + "/eLearning");
    }

    @Step
    public static void toFinancialServices() { open(BASE + INDUSTRIES + FINANCIAL_SERVICES); }

    @Step
    public static void toECommerce() {
        open(BASE + INDUSTRIES + "/ecommerce");
    }

    @Step
    public static void toTravelAndHospitality(){open(BASE + INDUSTRIES + "/travel-hospitality");}

    @Step
    public static void toHealthcare(){open(BASE + INDUSTRIES + HEALTHCARE);}

    @Step
    public static void toMediaAndEntertainment(){open(BASE + INDUSTRIES + "/media-and-entertainment");}

    @Step
    public static void toRealEstate(){open(BASE + INDUSTRIES + "/real-estate");}

    @Step
    public static void toTelecom(){open(BASE + INDUSTRIES + "/telecom");}

    @Step
    public static void toCustomIGamingSoftwareDevelopment(){open(BASE + INDUSTRIES + "/gambling");}

    @Step
    public static void toLogistics(){open(BASE + INDUSTRIES + "/logistics");}

    @Step
    public static void toEnterprise(){open(BASE + INDUSTRIES + "/enterprise");}

    @Step
    public static void toRetail(){open(BASE + INDUSTRIES + "/retail");}

    @Step
    public static void toAutomotive(){open(BASE + INDUSTRIES + "/automotive");}


    /** Industries subpages */
    @Step
    public static void toBetting(){
        open(BASE + INDUSTRIES + "/gambling/betting");}

    @Step
    public static void toIGamingPlatformDevelopment(){
        open(BASE + INDUSTRIES + "/gambling/igaming");}

    @Step
    public static void toUIUXGameArtDesign(){
        open(BASE + INDUSTRIES + "/gambling/andersen-ui-ux-game-art-design-igaming");}

    @Step
    public static void toMultiDevicesBrowsersSupport(){
        open(BASE + INDUSTRIES + "/gambling/andersen-multi-devices-browsers-support");}

    @Step
    public static void toIntegrations(){
        open(BASE + INDUSTRIES + "/gambling/andersen-integrations-for-igaming");}

    @Step
    public static void toProductionOperationsSupport(){
        open(BASE + INDUSTRIES + "/gambling/andersen-igaming-production-operations-support");}

    @Step
    public static void toIGamingPlatformSecurity(){
        open(BASE + INDUSTRIES + "/gambling/andersen-igaming-platform-protection");}

    @Step
    public static void toPlatformDevelopment(){
        open(BASE + INDUSTRIES + "/gambling/andersen-igaming-platform-development");}

    @Step
    public static void toFinancialServicesBanking(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/banking");}

    @Step
    public static void toBankingBigDataSolutions(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/banking/andersen-banking-big-data-solutions");}

    @Step
    public static void toBankingDigitalTransformation(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/banking/andersen-banking-digital-transformation");}

    @Step
    public static void toBankingIntegrationSoftware(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/banking/andersen-banking-integration-software");}

    @Step
    public static void toCoreBankingSoftwareSolutions(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/banking/andersen-core-banking-software-solutions");}

    @Step
    public static void toCustomLoanSoftwareSolutions(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/banking/andersen-custom-loan-software-solutions");}

    @Step
    public static void toDigitalBankingSoftwareDevelopment(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/banking/andersen-digital-banking-software");}

    @Step
    public static void toCustomBlockchainSoftwareDevelopment(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/custom-blockchain-solutions");}

    @Step
    public static void toFinancialServicesFintech(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/fintech");}

    @Step
    public static void toAlternativeLendingSoftware(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/fintech/andersen-alternative-lending-software");}

    @Step
    public static void toCloudFintechSolutions(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/fintech/andersen-cloud-fintech-solutions");}

    @Step
    public static void toCryptocurrencyDevelopmentServices(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/fintech/andersen-cryptocurrency-development-services");}

    @Step
    public static void toCustomDigitalWalletDevelopment(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/fintech/andersen-custom-digital-wallet-development");}

    @Step
    public static void toFintechPaymentSolutions(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/fintech/andersen-fintech-payment-solutions");}

    @Step
    public static void toPersonalFinanceSolutions(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/fintech/andersen-it-personal-finance-solutions");}

    @Step
    public static void toFinancialServicesInvestment(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/investment");}

    @Step
    public static void toAssetManagementSoftware(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/investment/andersen-asset-management-software");}

    @Step
    public static void toCustomTradingSoftware(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/investment/andersen-custom-trading-software");}

    @Step
    public static void toFinancialAnalysisSoftware(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/investment/andersen-finance-analysis-software");}

    @Step
    public static void toInvestmentComplianceDevelopment(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/investment/andersen-investment-compliance-development");}

    @Step
    public static void toMobileInvestmentSoftware(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/investment/andersen-mobile-investment-software");}

    @Step
    public static void toTradingApiDevelopment(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/investment/andersen-trading-api-development");}

    @Step
    public static void toFinancialServicesInsurance(){
        open(BASE + INDUSTRIES + FINANCIAL_SERVICES + "/insurance");}

    @Step
    public static void toMedicalPracticeManagementSoftware(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/medical-practice-management");}

    @Step
    public static void toHealthcareSoftwareDevelopers(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/healthcare-software-developers");}

    @Step
    public static void toRevenueCycleManagementSoftware(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/revenue-cycle-management");}

    @Step
    public static void toRemotePatientMonitoringSoftware(){
        open(BASE + INDUSTRIES + HEALTHCARE+ "/remote-patient-monitoring");}

    @Step
    public static void toPacsDicomSoftware(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/pacs-dicom-software");}

    @Step
    public static void toHealthInformationManagementSoftware(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/health-information-management");}

    @Step
    public static void toHealthcareAISoftwareSolutions(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/ai-software-solutions");}

    @Step
    public static void toCustomAssistiveTechnologySoftwareSolutions(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/assistive-technology-software");}

    @Step
    public static void toMobileHealthcareApplications(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/mobile-healthcare-applications");}

    @Step
    public static void toMentalHealthDigitalSolutions(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/mental-health-digital");}

    @Step
    public static void toHealthInformationExchangeSoftware(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/health-information-exchange");}

    @Step
    public static void toHealthInformationSecurityAndCompliance(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/health-information-security-and-compliance");}

    @Step
    public static void toHospitalManagementSoftware(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/hospital-management-software");}

    @Step
    public static void toEmrSolutions(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/emr-solutions");}

    @Step
    public static void toCustomEHRDevelopment(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/emr-solutions/andersen-custom-ehr-emr-development");}

    @Step
    public static void toEHRCustomization(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/emr-solutions/andersen-ehr-emr-customization");}

    @Step
    public static void toEHRIntegration(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/emr-solutions/andersen-ehr-emr-integration");}

    @Step
    public static void toDanielKraftOnHealthTechsFuture(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/health-tech-future");}

    @Step
    public static void toTelehealthSolutions(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/telehealth-solutions");}

    @Step
    public static void toDataAnalyticsAndIOMT(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/data-analytics-and-iomt");}

    @Step
    public static void toCustomMedicalSoftware(){
        open(BASE + INDUSTRIES + HEALTHCARE + "/custom-medical-software");}

    @Step
    public static void toOrderManagementSoftwareDevelopment(){
        open(BASE + INDUSTRIES + "/logistics/order-management");}

    @Step
    public static void toTransportationManagementSoftwareDevelopment(){
        open(BASE + INDUSTRIES + "/logistics/transport-management");}

    @Step
    public static void toWarehouseManagementSoftwareDevelopment(){
        open(BASE + INDUSTRIES + "/logistics/warehouse-management");}

    @Step
    public static void toInventoryManagementSoftwareDevelopment(){
        open(BASE + INDUSTRIES + "/logistics/inventory-management");}


    /** Techstack */
    /** Frontend */
    @Step
    public static void toFrontEnd() {open(BASE + TECHSTACK + "/front-end");}

    @Step
    public static void toAngular() {open(BASE + TECHSTACK + "/angular");}

    @Step
    public static void toJavascript(){open(BASE + TECHSTACK + "/js");}

    @Step
    public static void toReactJS(){open(BASE + TECHSTACK + "/react-js");}

    @Step
    public static void toVueJS(){open(BASE + TECHSTACK + "/vue-js");}

    /** Backend */
    @Step
    public static void toBackEnd(){open(BASE + TECHSTACK + "/back-end");}

    @Step
    public static void toJava(){open(BASE + TECHSTACK + "/java");}

    @Step
    public static void toDotNet(){open(BASE + TECHSTACK + "/dot-net");}

    @Step
    public static void toPHP(){open(BASE + TECHSTACK + "/php");}

    @Step
    public static void toPython(){open(BASE + TECHSTACK + "/python");}

    @Step
    public static void toRuby(){open(BASE + TECHSTACK + "/ruby");}

    @Step
    public static void toRust(){open(BASE + TECHSTACK + "/rust");}

    @Step
    public static void toNodeJS(){open(BASE + TECHSTACK + "/node-js");}

    @Step
    public static void toScala(){open(BASE + TECHSTACK + "/scala");}

    @Step
    public static void toGolang(){open(BASE + TECHSTACK + "/golang");}

    @Step
    public static void toCandCPP(){open(BASE + TECHSTACK + "/c-c-plus-plus");}

    /** Mobile */
    @Step
    public static void toMobile(){open(BASE + TECHSTACK + "/mobile");}

    @Step
    public static void toAndroid(){open(BASE + TECHSTACK + "/android");}

    @Step
    public static void toIOS(){open(BASE + TECHSTACK + "/ios");}

    @Step
    public static void toXamarin(){open(BASE + TECHSTACK + "/xamarin");}

    @Step
    public static void toReactNative(){open(BASE + TECHSTACK + "/react-native");}

    @Step
    public static void toIonic(){open(BASE + TECHSTACK + "/ionic");}

    @Step
    public static void toFlutter(){open(BASE + TECHSTACK + "/flutter");}

    @Step
    public static void toMeetUsTomorrow() {open(BASE + "/meet-us-tomorrow");}

    @Step
    public static HomePage openHomePageObjUrl() {
        openHomeDev();
        return new HomePage();
    }
}


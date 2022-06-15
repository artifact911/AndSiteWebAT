package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class CompanyOfExpertsData {
    protected static String BASE_ROUTE = "https://d3jqtupnzefbtn.cloudfront.net/andersenlab/new-andersensite/icons";
    protected static String TECHNOLOGIES_ROUTE = BASE_ROUTE + "/technologies";
    protected static String LOGOS_ROUTE = BASE_ROUTE + "/logos";
    public enum Clouds{
        TITLE("Clouds We Partner With:",
                "Our Multimedia and Entertainment experts are trained and certified by the biggest cloud providers and are ready to bring unprecedented quality and speed to your solutions and your end users."),
        ORACLE(TECHNOLOGIES_ROUTE + "/oracle-cloud-white.svg", "ORACLE"),
        AZURE(TECHNOLOGIES_ROUTE + "/azure-white.svg", "AZURE"),
        SALESFORCE(TECHNOLOGIES_ROUTE + "/salesforce-white.svg", "SALESFORCE"),
        RED_HAT(TECHNOLOGIES_ROUTE + "/red-hat-white.svg", "RED HAT"),
        ALIBABA(TECHNOLOGIES_ROUTE + "/alibaba-white.svg", "ALIBABA"),
        AWS(TECHNOLOGIES_ROUTE + "/aws-white.svg", "AWS"),
        GOOGLE(TECHNOLOGIES_ROUTE + "/google-white.svg", "GOOGLE"),
        DIGITAL_OCEAN(TECHNOLOGIES_ROUTE + "/digital-ocean-white.svg", "DIGITAL OCEAN");
        @Getter private final List<String> el;
        Clouds(String title, String subtitle){
            this.el = Arrays.asList(title, subtitle);
        }
    }
    public enum HealthcareExperts{
        TITLE("Company of healthcare software experts",
                "The confirmation of our experts’ knowledge, qualification and professional skills is reflected in company’s achievements shown below."),
        HIPAA(LOGOS_ROUTE + "/hipaa-compliant-logo-white.svg", ""),
        CLUTCH_TOP_STAFF(LOGOS_ROUTE + "/clutch-top-staff-aug-services.svg", ""),
        CLUTCH_TOP_SOFT_DEV(LOGOS_ROUTE + "/clutch-top-soft-dev-2019-white.svg", ""),
        ISO_9001(LOGOS_ROUTE + "/iso-9001-logo-white.svg", ""),
        ISO_IEC_27001(LOGOS_ROUTE + "/iso-iec-27001-logo-white.svg", ""),
        CLUTCH_TOP_1000(LOGOS_ROUTE + "/clutch-top-1000-2019-logo-white.svg", "");
        @Getter private final List<String> el;
        HealthcareExperts(String title, String subtitle){
            this.el = Arrays.asList(title, subtitle);
        }
    }
}

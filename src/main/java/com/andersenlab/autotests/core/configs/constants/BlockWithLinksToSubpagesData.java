package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class BlockWithLinksToSubpagesData {
    public enum Igaming{

    }

    public enum Healthcare{
        HEALTHCARE_IT_SERVICES("Healthcare Software Solutions and Services",
                "Realize the full potential of healthcare software to empower your healthcare business",
                "Healthcare software solutions can optimize delivery of care and drive down costs - while improving patient outcomes. Healthcare software plays an increasingly prominent role in R&D and accelerated innovation. Andersen’s mission is to help healthcare stakeholders become highly efficient at saving and improving people’s lives, deliver a seamless patient experience, and ensure value-based care with innovative solutions. Discover how our healthcare software solutions can help your organization achieve digital transformation with greater speed and impact than you thought possible."
        ),
        MORE_SERVICES("Healthcare Software Solutions and Services",
                "Realize the full potential of healthcare software to empower your healthcare business",
                "Healthcare software solutions can optimize delivery of care and drive down costs - while improving patient outcomes. Healthcare software plays an increasingly prominent role in R&D and accelerated innovation. Andersen’s mission is to help healthcare stakeholders become highly efficient at saving and improving people’s lives, deliver a seamless patient experience, and ensure value-based care with innovative solutions. Discover how our healthcare software solutions can help your organization achieve digital transformation with greater speed and impact than you thought possible."),
        EMR_CARD("Electronic Health Records (EHR/EMR)", SvgIcons.healthFolder, "/industries/healthcare/emr-solutions"),
        DA_AND_IOMT("Healthcare Data Analytics Software", SvgIcons.dataAnalytics, "/industries/healthcare/data-analytics-and-iomt"),
        CUSTOM_SOFT_DEV("Custom Healthcare Software Development", SvgIcons.healthWirl, "/industries/healthcare/custom-medical-software"),
        TELEHEATH("Telehealth & Telemedicine", SvgIcons.phoneTonometer, "/industries/healthcare/telehealth-solutions"),
        SOFT_SOL("Healthcare Software Solutions", SvgIcons.healthcareHeart, "/industries/healthcare"),

        CONSULTANCY_SERVICES("Check out our consultancy services", "", ""),
        BUSINESS_RECONSTRUCTION("Business process reconstruction", SvgIcons.featureSuccess, "/services/business-analysts"),
        IT_SECURITY("Cyber and IT security", SvgIcons.itSecurity, "/services/security-management"),
        CI_CD_PRACTICES("Establishment of CI/CD practices", SvgIcons.practicesCICD, "/services/devops"),
        DESIGN("Design and redesign", SvgIcons.designPage, "/services/design-studio"),
        AQA("Quality assurance automation", SvgIcons.featureFavorite, "/services/quality-assurance-services"),
        BIG_DATA_AND_DA("Big Data and Analytics", SvgIcons.scaleglass, "/services/data-science"),
        LINK_TO_MAIN("Return to Healthcare page","","/industries/healthcare");

        @Getter private final List<String> data;

        Healthcare(String title, String image, String link){
            this.data = Arrays.asList(title, image, link);
        }
    }
}

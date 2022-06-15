package com.andersenlab.autotests.site.page.services.customsoftware.blocks.intro;

import com.andersenlab.autotests.site.utility.Warp;
import org.openqa.selenium.By;

public interface IntroLocators {
    String BASE = "//section[contains(@class, 'intro')]";
    By HEADING = By.xpath(BASE + "//h1[contains(@class, 'title')]");
    By WIDGETS = By.xpath(BASE + "//img[contains(@src, '.svg') and contains(@src, 'icons')]");
    By LINK_PHONE = By.xpath("//span[@class='phone']");

    default String textTitle(){
        //дописывать по необходимости
        switch (Warp.tabTitle()) {
            //services
            case "Custom Software Development Company - Andersen":
                return "Premier Custom Software Development Company";
            case "Mobile App Design & Development Company - Andersen":
                return "Mobile application development services";
            case "Web Development Company - Web App Development Services - Andersen":
                return "Web Development Services";
            case "QA in full-cycle of software development":
                return "Software Testing and QA Services";
            case "Professional Business Analysts":
                return "Business Analysis Services";
            case "Application Maintenance and Support Services":
                return "Outsourced Corporate IT Support Services";
            case "Custom Salesforce development services - Andersen":
                return "Salesforce Consulting and Development Services";
            case "Data Science & Big Data Consulting And Development Services - Andersen":
                return "Data Science & Big Data: Consulting and Development Services";
            case "Get qualified software developers & engineers":
                return "Find Developers";

            //tech stack
            //front-end
            case "Hire Experienced Front-end Developers - Andersen":
                return "Work With Top Front-end Developers";
            case "Hire Experienced Angular Developers - Andersen":
                return "Work with Top Angular Developers";
            case "Hire Experienced JavaScript Developers - Andersen":
                return "Work with Top JavaScript Developers";
            case "Hire Experienced React.js Developers - Andersen":
                return "Work with Top React.js Developers";
            case "Hire Experienced Vue.js Developers - Andersen":
                return "Work with Top Vue.js Developers";

            //back-end
            case "Hire Experienced Back-end Developers - Andersen":
                return "Work With Top Back-end Developers";
            case "Hire Experienced Java Developers - Andersen":
                return "Work with Top Java Developers";
            case "Hire Experienced .NET Developers - Andersen":
                return "Work with Top .NET Developers";
            case "Hire Experienced PHP Developers - Andersen":
                return "Work with Top PHP Developers";
            case "Hire Experienced Python Developers - Andersen":
                return "Work with Top Python Developers";
            case "Hire Experienced Ruby Developers - Andersen":
                return "Work with Top Ruby Developers";
            case "Hire Experienced Node.js Developers - Andersen":
                return "Work with Top Node.js Developers";
            case "Hire Experienced Scala Developers - Andersen":
                return "Work with Top Scala Developers";
            case "Hire Experienced Golang Developers - Andersen":
                return "Work with Top Golang Developers";
            case "Hire Experienced C/C++ Developers - Andersen":
                return "Work with Top C&C++ Developers";

            //mobile
            case "Hire Experienced Mobile Developers - Andersen":
                return "Work With Top Mobile Developers";
            case "Hire Experienced Android Developers - Andersen":
                return "Work With Top Android Developers";
            case "Hire Experienced iOS Developers - Andersen":
                return "Work with Top iOS Developers";
            case "Hire Experienced Xamarin Developers - Andersen":
                return "Work with Top Xamarin Developers";
            case "Hire Experienced React Native Developers - Andersen":
                return "Work with Top React Native Developers";
            case "Hire Experienced Ionic Developers - Andersen":
                return "Work With Top Ionic Developers";
            case "Flutter App Development | Andersen":
                return "Work With Top Flutter Developers";

            //industries
            case "Custom eLearning Development Services - Andersen":
                return "eLearning Software Development Services";
            case "E-commerce Website Development Services - Andersen":
                return "eCommerce Development Services";
            case "Software development for Banks and Financial companies":
                return "Custom Financial Software Development";
            case "Qualitative software development":
                return "eLearning Software Development Services";
            case "Travel Software Development - Custom Travel Solutions - Andersen":
                return "Custom Travel & Hospitality Software Development";
            case "Healthcare Software Development Company - Andersen":
                return "Healthcare Software Solutions";
            case "Custom Software Development for Media & Entertainment | Andersen":
                return "Multimedia & Entertainment Software Development Services";
            case "Real Estate Software Development - Custom Real Estate Solutions - Andersen":
                return "Real Estate Software Development";
            case "Telecom Software Development - Custom Telecom Solutions - Andersen":
                return "Telecom Software Development";
            case "Software Development for the Online Gambling Industry | Andersenlab":
                return "Custom iGaming Software Development";
            case "Logistics Software Development | Andersen":
                return "Custom Logistics Software Development";
            case "Custom Enterprise Software for Your Growth":
                return "Custom Enterprise Software Development";
            case "Retail Software Development | Andersen":
                return "Custom Retail Software Development";

            //industries subpages
            case "Custom sports betting software solutions and development":
                return "Sports Betting Software Development";
            case "iGaming software development & consulting":
                return "iGaming Platform Development";
            case "Custom EMR Software Development":
                return "Electronic Health Record (EHR/EMR) Software Solutions";
            case "IoMT and Healthcare Data Analytics solutions | Andersen":
                return "Healthcare Data Analytics Software";
            case "Custom Healthcare and Medical Software Development":
                return "Custom Healthcare Software Development";
            case "Telemedicine software development":
                return "Telehealth & Telemedicine Software Development";
            default:
                throw new IllegalArgumentException();
        }
    }
}

package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class OurProjectsBlockData {
    public enum Igaming{
        IGAMING("Our projects",
                "We provide a full range of custom software development services. Our engineers can help you create best-in-class software solutions for your business that perfectly fit your needs. The best results are reflected in our projects",
                ""),
        BETTING("Our Sports Betting Services",
                "We provide a full range of custom software development services. Our engineers can help you create best-in-class software solutions for your business that perfectly fit your needs. The best results are reflected in our projects",
                ""),
        IGAMING_PLATFORM_DEVELOPMENT("Our projects",
                "We provide a full range of custom software development services. Our engineers can help you create best-in-class software solutions for your business that perfectly fit your needs. The best results are reflected in our projects",
                ""),
        RUSH_CASINO("Innovative gambling company",
                "Game aggregator integration via API",
                "/cases/gambling/real-money-casino-vc-preview"),
        SOCIAL_CASINO("Social casino",
                "Development of admin panel for Loot-boxes",
                "/cases/gambling/social-casino-vc-preview"),
        MB("Integrator of bookmakers",
                "Sports, technology, casino games, and betting into a single solution",
                "/cases/monbet/monbet-vc-preview"),
        BET_LAKES("App for gambling while watching sporting events",
                "A system that allows for high-quality live streaming and includes functions for real-time interaction",
                "/cases/betlakes/betlakes-vc-preview");

        @Getter private final List<String> data;

        Igaming(String title, String subtitle, String image){
            this.data = Arrays.asList(title, subtitle, image);
        }
    }

    public enum Logistics{
        LOGISTICS("Our projects",
                "Providing full range of Logistics services, we help you create best-in-class software solutions for your business that perfectly fit your needs. The best results are reflected in our projects",
                ""),
        TRANSPOREON("Web logistics platform",
                "A solution for ensuring efficient transportation of goods.",
                "/cases/transporeon/transporeon-preview"),
        NEXXIOT("IoT and Big Data for railcars & tanktainers",
                "The interface to manage assets and goods or provide data-driven services to supply chain participants.",
                "/cases/nexxiot/nexxiot-preview"),
        OURCNC("Car rental software",
                "A functional mobile app that allows customers to book a car, use it, and pay for car rental services.",
                "/cases/our-cnc/our-cnc-preview");
        @Getter private final List<String> data;

        Logistics(String title, String subtitle, String image){
            this.data = Arrays.asList(title, subtitle, image);
        }
    }

    public enum Retail{
        RETAIL("Our projects",
                "Regardless of the size and complexity of a project, our specialists will get things done professionally . You can see this by reviewing our portfolio",
                ""),
        EXIGO("EXIGO",
                "eCommerce development services that maximize your earnings",
                "/cases/exigo/exigo-vc-preview"),
        MEDIA_MARKT("Media Markt",
                "Europe's largest consumer electronics retailer, with over 750 stores and millions of happy customers.",
                "/cases/media-markt/visual-concept/mediamarkt-vc-preview"),
        SALE_GROUP("Large distribution network solution",
                "Mobile and desktop application for organizing the process of selling goods through various distribution channels",
                "/cases/sale-group/sale-group-preview");
        @Getter private final List<String> data;

        Retail(String title, String subtitle, String image){
            this.data = Arrays.asList(title, subtitle, image);
        }

    }

    public enum VideoEntertainment{
        VIDEO_ENTERTAINMENT("Our projects",
                "Providing full range of multimedia services, we help you create best-in-class software solutions for your business that perfectly fit your needs. The best results reflected in our projects.",
                ""),
        ORIGAMI("Online cinema",
                "A home theater platform for demonstrating various video content on Smart TV or mobile devices.",
                "/cases/origami/origami-vc-preview"),
        CINEMEYE("Video streaming, smart TV",
                "An application that allows watching a large number of TV channels, as well as movies and TV series in digital and HD quality.",
                "/cases/cinemeye/cinemaeye-vc-preview"),
        MERCEDES_ME("Interactive Café",
                "High-tech entertainment space in the form of a café for car presentations.",
                "/cases/mercedes-me/mercedes-vc-preview"),
        GLOBE_CHANNEL("App for global TV channel",
                "Transferring the function of watching TV to users' phones",
                "/cases/globe-channel/globe-vc-preview"),
        SAMSUNG("App for Smart TVs",
                "The application for watching video content on Smart TVs",
                "/cases/samsung/samsung-vc-preview"),
        WINNERS("Sports streaming platform",
                "Digital venue streaming solution to utilise TV and social media",
                "/cases/winners/winners-vc-preview");
        @Getter private final List<String> data;

        VideoEntertainment(String title, String subtitle, String image){
            this.data = Arrays.asList(title, subtitle, image);
        }
    }

    public enum Healthcare{
        OUR_PROJECTS("Our projects",
                "Customers from the USA, Europe, Middle East and other regions rely on our Healthcare software development services",
                "",
                ""),
        JOHNSON_JOHNSON("Medical imaging software for surgery assistance",
                "An interoperable solution aimed at helping during complicated joint surgical operations",
                "/cases/healthcare/johnsson-preview",
                ""),
        META("EHR system",
                "A web-based EHR platform with a set of essential functionalities",
                "/cases/healthcare/ehr-system-preview",
                ""),
        UNIVERSKIN("Data-driven skin-care solution",
                "A revolutionary tool for effective diagnoses of skin conditions and related diseases with a further treatment routine",
                "/cases/healthcare/universkin-preview",
                ""),
        TIGERCCONNECT("Healthcare communication platform",
                "One of the most widely adopted Healthcare communication platforms in USA",
                "/cases/healthcare/tigerconnect-preview",
                ""),
        EMFIT("IoT-powered heart rate monitor",
                "Effective tool for precise monitoring of the heart muscle recovery level, respiratory rate and physical activity",
                "/cases/healthcare/emfit-preview",
                ""),
        BLAZE_NOW("Custom medical application",
                "A interactive service that allows its users to find medical cannabis businesses and corresponding doctors",
                "/cases/healthcare/blazenow-preview",
                ""),
        TELEMDECINE("In-hospital Telemedicine platform",
                "TeleMedicine platform with rich functionality and HIPAA compliant communication tools",
                "/cases/patient-monitoring/patient-monitoring-vc-preview",
                ""),
        DOCTOR_PLUS("Multiplatform telemedicine solution",
                "KBV regulations compliant application with wide range of functions",
                "/cases/healthcare/visual-concept-case-2/healthcare-case-2-vc-preview",
                ""),
        ONLINE_CLINIC("Online clinic for the period of the pandemic",
                "An application that covers all standard clinic workflow processes",
                "/cases/healthcare/visual-concept-case-3/healthcare-case-3-vc-preview",
                ""),
        AI_COVID("AI-powered intelligent platform for COVID-19 test results verification",
                "The system that simplifies the work of lab operators who deal with qPCR analyses.",
                "/cases/covid-ai-platform/covid-ai-platform-preview",
                ""),

        SMTHNG_TO_THINK("Something to think about",
                "Speed of program development and its safety are the main criteria when working with Healthcare outsourcing, from the service desk to the support of the new application. And Andersen experts take care of all these.",
                "",
                ""),
        ROLE_OF_CONNECTED_DEVICES("The Role Of Connected Devices In Modern Healthcare",
                "Benefits IT brings to healthcare industry through software and connected devices",
                "/blueprint/connected-devices-in-healthcare/connected-devices-in-healthcare-preview",
                "https://www.forbes.com/sites/forbesbusinessdevelopmentcouncil/2021/01/20/the-role-of-connected-devices-in-modern-healthcare/?sh=5e55ae7e567d"),
        TELEMDEDICINE_2dot0("TeleMedicine 2.0",
                "Doing The Right Things Right" ,
                "/blueprint/telemedicine-2/telemedicine-2-preview",
                "https://www.forbes.com/sites/forbesbusinessdevelopmentcouncil/2021/12/29/telemedicine-20-doing-the-right-things-right/?sh=33c64af31d23"),
        BENEFITS_OF_IoT("The Benefits of the Internet of Things (IoT) for Healthcare",
                "IoT for diagnostics and monitoring of patients' condition and other applications of the Internet of Things in modern medicine." ,
                "/blueprint/3-iot-highlights/3-iot-highlights-preview",
                "https://andersenlab.com/blueprint/3-iot-highlights"),
        INFLUENCE_OF_COVID_AT_IT("How COVID-19 Has Influenced Health IT?",
                "Coronavirus-fueled tech trends for healthcare IT companies to follow",
                "/blueprint/covid-and-health-it/covid-and-health-it",
                "https://andersenlab.com/blueprint/how-covid-19-has-influenced-health-it"),
        PROSPECTS_FOR_DEVELOPMENT_OF_TELEMEDICINE("Prospects for Development of TeleMedicine and TeleMedicine IT Solutions",
                "The advantages and benefits of TeleMedicine and the technologies for integrating it",
                "/blueprint/telemedicine/telemedicine-preview",
                "https://andersenlab.com/blueprint/telemedicine-development-prospects-and-it-solutions");
        @Getter private final List<String> data;

        Healthcare(String title, String subtitle, String image, String link){
            this.data = Arrays.asList(title, subtitle, image, link);
        }
    }
}

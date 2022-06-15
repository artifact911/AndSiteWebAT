package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class CostCalcData {
    public final static String radiobtns = "radioBtn";
    public final static String checkboxes = "checkbox";
    public final static String slider = "slider";
    public final static String plusMinusCounter = "counter";

    public enum Page {
        //title, subtitle, desktopPriceButton, mobilePriceButton - List
        //desktopSectionsTitles - List
        //desktopSectionsSubtitles - List
        //mobileSectionsTitles - List
        //budget - List
        //type - List
        VIDEO_ENTERTAINMENT(Arrays.asList(
                Arrays.asList("Your price calculator",
                        "Please provide the core details of your project so we’ll be able to calculate the service price for you as soon as possible. If you can’t provide them yet for any reason then don’t hesitate to contact us to get an individual consultancy based on your specific case.",
                        "Get price", "Calculate"),
                Arrays.asList("01. Select services",
                        "02. Select the type",
                        "03. Select additional services",
                        "04. Select estimated budget"),
                Arrays.asList("What services do you require?",
                        "Select the type of application",
                        "Specify additional services you may be interested in",
                        "Select the estimated budget range for your project in USD"),
                Arrays.asList("Select services", "Select the type", "Select additional services", "Select estimated budget"),
                Arrays.asList("up to 25K", "25-50K", "50-100K", "100-200K", "Over 200K"),
                Arrays.asList(checkboxes, radiobtns, checkboxes, slider)
        )),
        TELEHEATH(Arrays.asList(
                Arrays.asList("Your price calculator",
                        "Please provide the core details of your demand so we’ll be able to calculate the service price for you as soon as possible. If you can’t provide them yet for any reason then don’t hesitate to contact us to get an individual consultancy based on your specific case.",
                        "Get price", "Calculate"),
                Arrays.asList("01. Business type",
                        "02. Application type",
                        "03. Select services",
                        "04. Select estimated budget"),
                Arrays.asList("Specify the business type you are.",
                        "Select the type of application.",
                        "Specify the types of services you need.",
                        "Select the estimated budget range for your project in USD"),
                Arrays.asList("Business type", "Application type", "Select services", "Select estimated budget"),
                Arrays.asList("up to 25K", "25-50K", "50-100K", "100-200K", "Over 200K"),
                Arrays.asList(checkboxes, checkboxes, checkboxes, slider)
        )),
        HEALTHCARE_SOFT_DEV(Arrays.asList(
                Arrays.asList("Your price calculator",
                        "Please provide the core details of your demand so we’ll be able to calculate the service price for you as soon as possible. If you can’t provide them yet for any reason then don’t hesitate to contact us to get an individual consultancy based on your specific case.",
                        "Get price", "Calculate"),
                Arrays.asList("01. Business type",
                        "02. Application type",
                        "03. Select services",
                        "04. Select other services",
                        "05. Select estimated budget"),
                Arrays.asList("Specify the business type you are.",
                        "Select the type of application.",
                        "Choose the type of service you are looking for.",
                        "Choose additional services you might be interested in.",
                        "Select the estimated budget range for your project in USD"),
                Arrays.asList("Business type", "Application type", "Select services", "Select other services", "Select estimated budget"),
                Arrays.asList("up to 25K", "25-50K", "50-100K", "100-200K", "Over 200K"),
                Arrays.asList(checkboxes, checkboxes, checkboxes, checkboxes, slider)
        )),
        ELEARNING(Arrays.asList(
                Arrays.asList("Get a quote for your eLearning solution",
                        "Fill out the form below for us to provide you with a custom offer.",
                        "Get price", "Calculate"),
                Arrays.asList("01. Select type of business",
                        "02. Specify your request",
                        "03. Select services",
                        "04. Select other services",
                        "05. Select estimated budget"),
                Arrays.asList("Indicate what type of business you are",
                        "Select the type of IT service you are looking for",
                        "What services do you need?",
                        "If required, you may choose additional services",
                        "Select the estimated budget range for your project in USD"),
                Arrays.asList("Select type of business",
                        "Specify your request",
                        "Select services",
                        "Select other services",
                        "Select estimated budget"),
                Arrays.asList("up to 25K", "25-50K", "50-100K", "100-200K", "Over 200K"),
                Arrays.asList(radiobtns, checkboxes, checkboxes, checkboxes, slider)
        ));

        @Getter private final List<List<String>> data;

        Page(List<List<String>> data){
            this.data = data;
        }
    }
}

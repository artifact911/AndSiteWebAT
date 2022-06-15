package com.andersenlab.autotests.site.page.techstack.calculators;

import lombok.Getter;

@Getter
public enum Industries {
    Financial_Services("Financial Services"),
    eCommerce("eCommerce"),
    Travel_And_Hospitality("Travel & Hospitality"),
    Telecom("Telecom"),
    Media_And_Entertainment("Media & Entertainment"),
    Enterprise("Enterprise"),
    Real_Estate("Real Estate"),
    Healthcare("Healthcare"),
    iGaming("iGaming"),
    Logistics("Logistics"),
    eLearning("eLearning"),
    Retail("Retail"),
    Automotive("Automotive");

    String text;

    Industries(String text) {
        this.text = text;
    }
}

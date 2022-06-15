package com.andersenlab.autotests.site.page.industries.ecommerce.calculator;

import lombok.Getter;

@Getter
public enum TypeOfIndustries {
    B2B("B2B"),
    B2C("B2C"),
    C2C("C2C"),
    Automotive("C2B");

    String text;

    TypeOfIndustries(String text) {
        this.text = text;
    }
}

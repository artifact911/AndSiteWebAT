package com.andersenlab.autotests.site.page.industries.ecommerce.calculator;

import lombok.Getter;

@Getter
public enum RevenueModels {
    Dropshipping("Dropshipping"),
    Subscription("Subscription"),
    Manufacturing("Manufacturing"),
    White_labeling("White labeling"),
    Wholesaling("Wholesaling"),
    Rent_and_loan("Rent and loan"),
    Freemium("Freemium");

    String text;

    RevenueModels(String text) {
        this.text = text;
    }
}

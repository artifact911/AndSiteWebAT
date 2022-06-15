package com.andersenlab.autotests.site.page.industries.ecommerce.calculator;

import lombok.Getter;

@Getter
public enum SelectServices {
    Web_and_Mobile_development("Web and Mobile development"),
    UI_UX_design("UI/UX design"),
    Marketing("Marketing"),
    Security("Security"),
    Cloud_development("Cloud development"),
    Quality_Assurance("Quality Assurance"),
    Freemium("Project management"),
    Business_Analysis("Business Analysis");

    String text;

    SelectServices(String text) {
        this.text = text;
    }
}

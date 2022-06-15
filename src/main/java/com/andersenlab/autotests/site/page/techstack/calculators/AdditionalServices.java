package com.andersenlab.autotests.site.page.techstack.calculators;

import lombok.Getter;

@Getter
public enum AdditionalServices {
    Project_management("Project management"),
    Business_analysis("Business analysis"),
    UI_UX_design("UI/UX design"),
    Quality_assurance("Quality assurance"),
    Cloud_development("Cloud development"),
    IT_security("IT security"),
    DevOps("DevOps"),
    Marketing_services("Marketing services"),
    Architecture_planning("Architecture planning");

    String text;

    AdditionalServices(String text) {
        this.text = text;
    }
}

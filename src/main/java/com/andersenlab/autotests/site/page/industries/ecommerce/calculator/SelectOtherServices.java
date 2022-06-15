package com.andersenlab.autotests.site.page.industries.ecommerce.calculator;

import lombok.Getter;

@Getter
public enum SelectOtherServices {
    Architecture_planning("Architecture planning"),
    Data_Science("Data Science"),
    DevOps("DevOps"),
    CRM("CRM"),
    IT_support("IT support"),
    ERP("ERP"),
    Customer_support("Customer support"),
    Integration("Integration");

    String text;

    SelectOtherServices(String text) {
        this.text = text;
    }
}

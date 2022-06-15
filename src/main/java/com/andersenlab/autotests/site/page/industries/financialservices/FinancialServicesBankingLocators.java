package com.andersenlab.autotests.site.page.industries.financialservices;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class FinancialServicesBankingLocators {
    static final By TITLE = By.xpath("//h1[contains(@class,'fintech-banking-page')]");
}

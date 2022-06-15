package com.andersenlab.autotests.site.page.homepage.blocks.topcompaniescards;

import org.openqa.selenium.By;

public class CardsTopCompaniesLocators {
    static final By SAMSUNG_CARD = By.xpath("//button[contains(@data-object,'Samsung')][2]");
    static final By MARVEL_CARD =By.xpath("//button[contains(@data-object,'Marvel')][2]");
    static final By MERCEDES_CARD =By.xpath("//button[contains(@data-object,'Mercedes ')][2]");
    static final By GLOBE_PAYROLL_CARD =By.xpath("//button[contains(@data-object,'GlobePayroll')][2]");
    static final By IHS_CARD =By.xpath("//button[contains(@data-object,'IHS')]");
    static final By BNP_CARD =By.xpath("//button[contains(@data-object,'BNP Paribas')]");
    static final By TUI_CARD =By.xpath("//button[contains(@data-object,'TUI')]");
    static final By PURITY_CARD =By.xpath("//button[contains(@data-object,'Purity')]");
    static final By MOGO_FINANCE_CARD =By.xpath("//button[contains(@data-object,'MogoFinance')]");
//    static final By MOGO_FINANCE_CARD =By.xpath("/html/body/main/section[6]/div/div[2]/div/div/div/button[13]");
    static final By SIEMENS_CARD =By.xpath("//button[contains(@data-object,'Siemens')][2]");
    static final By BEELINE_CARD =By.xpath("//button[contains(@data-object,'Beeline')][2]");
    static final By ALFA_BANK_CARD =By.xpath("//button[contains(@data-object,'Alfa-Bank')][2]");
    static final By MOMOOK_ERP = By.xpath("//button[contains(@data-object, 'Momook')][2]");
    static final By POP_UP_CLOSE = By.xpath("//*[@id='popup-description']/div/div/span");
    static final By POP_UP_DISPLAYED = By.xpath("//section[contains(@class,'popup__section')]//div[@class = 'popup__wrap']");
}

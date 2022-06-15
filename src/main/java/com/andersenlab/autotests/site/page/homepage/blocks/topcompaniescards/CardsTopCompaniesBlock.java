package com.andersenlab.autotests.site.page.homepage.blocks.topcompaniescards;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.homepage.blocks.topcompaniescards.CardsTopCompaniesLocators.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Карточки блока "Top companies rely on Andersen"
 */

@Getter
public class CardsTopCompaniesBlock {
    private SelenideElement samsungCard = $(SAMSUNG_CARD);
    private SelenideElement marvelCard = $(MARVEL_CARD);
    private SelenideElement mercedesCard = $(MERCEDES_CARD);
    private SelenideElement globePayrollCard = $(GLOBE_PAYROLL_CARD);
    private SelenideElement ihsCard = $(IHS_CARD);
    private SelenideElement bnpCard = $(BNP_CARD);
    private SelenideElement tuiCard = $(TUI_CARD);
    private SelenideElement purityCard = $(PURITY_CARD);
    private SelenideElement mogoFinanceCard = $(MOGO_FINANCE_CARD);
    private SelenideElement siemensCard = $(SIEMENS_CARD);
    private SelenideElement beelineCard = $(BEELINE_CARD);
    private SelenideElement alfaBankCard = $(ALFA_BANK_CARD);
    private SelenideElement momookERP = $(MOMOOK_ERP);
    private SelenideElement closePopUps = $(POP_UP_CLOSE);
    private SelenideElement displayedPopUps = $(POP_UP_DISPLAYED);
}

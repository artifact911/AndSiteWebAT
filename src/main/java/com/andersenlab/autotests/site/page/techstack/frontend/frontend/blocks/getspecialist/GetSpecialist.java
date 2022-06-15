package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.getspecialist;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
@Getter
public class GetSpecialist implements GetSpecialistLocators{
    private SelenideElement ButtonReqSpec = $(BUTTON_REQ_SPEC);
}

package com.andersenlab.autotests.site.page.industries.ecommerce.blocks.letstalk;

import com.andersenlab.autotests.core.utils.utility.Utility;
import com.codeborne.selenide.Selenide;

import static com.andersenlab.autotests.site.page.industries.ecommerce.blocks.letstalk.LetsTalkLocators.NO_EMAIL_ERROR;


public class LetsTalkOperations {

    public String getNoEmailError() {
        return Utility.operations.getPseudoElementContent(NO_EMAIL_ERROR);
    }
}

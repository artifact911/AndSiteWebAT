package com.andersenlab.autotests.site.page.services.customsoftware.blocks.developmentservices;

import com.codeborne.selenide.Condition;

import static com.andersenlab.autotests.site.page.services.customsoftware.blocks.developmentservices.DevServicesLocators.*;
import static com.codeborne.selenide.Selenide.$$;

public class DevServicesOperations  {

    public void openSeeMoreItemByName(String itemName) {
        $$(DEV_ITEMS).
                filter(Condition.text(itemName)).
                first().
                $(DEV_LINK).
                click();
    }
}

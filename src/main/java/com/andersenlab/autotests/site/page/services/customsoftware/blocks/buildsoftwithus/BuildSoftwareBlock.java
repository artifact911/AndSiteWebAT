package com.andersenlab.autotests.site.page.services.customsoftware.blocks.buildsoftwithus;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.services.customsoftware.blocks.buildsoftwithus.BuildSoftwareLocators.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Блок Look Who’s Built Custom Software with Us
 */
@Getter
public class BuildSoftwareBlock {
   private ElementsCollection darkCases = $$(DARK_CASES);
   private SelenideElement showMoreButton = $(SHOW_MORE_BUTTON);
}

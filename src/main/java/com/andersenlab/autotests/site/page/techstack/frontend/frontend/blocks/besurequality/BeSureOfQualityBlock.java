package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.besurequality;

import com.andersenlab.autotests.site.page.techstack.BaseTechPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.besurequality.BeSureOfQualityLocators.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Блок "Be sure of 100% quality"
 */
@Getter
public class BeSureOfQualityBlock extends BaseTechPage {
    private ElementsCollection examplePdfItems = $$(EXAMPLE_PDF_ITEMS);
    private SelenideElement titleDevQuality = $(TITLE_DEV_QUALITY);
//    private SelenideElement jsSpecialistsCount = $(JS_DEV_COUNT);
//    private SelenideElement frontEndDevReset = $(FRONT_END_DEV_RESET);
}

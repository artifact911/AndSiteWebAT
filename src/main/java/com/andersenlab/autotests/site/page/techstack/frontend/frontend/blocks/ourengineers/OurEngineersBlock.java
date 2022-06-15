package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.ourengineers;

import com.andersenlab.autotests.site.page.techstack.BaseTechPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;


import static com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.ourengineers.OurEngineersLocators.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Блок "Our Engineers"
 */
@Getter
public class OurEngineersBlock extends BaseTechPage {
    private SelenideElement requestButton = $(REQUEST_BUTTON);
    private SelenideElement popupRequest = $(POPUP_REQUEST);
    private ElementsCollection resumeItems = $$(RESUME_ITEMS);
    private SelenideElement showMoreButton = $(SHOW_MORE_BUTTON);

}

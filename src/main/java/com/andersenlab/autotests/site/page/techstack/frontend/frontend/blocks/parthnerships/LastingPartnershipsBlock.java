package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.parthnerships;

import com.andersenlab.autotests.site.page.techstack.BaseTechPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.parthnerships.LastingPartnershipsLocators.PROJECTS_PREVIEWS;
import static com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.parthnerships.LastingPartnershipsLocators.SHOW_MORE_BUTTON;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Блок "Lasting partnerships"
 */
@Getter
public class LastingPartnershipsBlock extends BaseTechPage {
    private ElementsCollection projectsPreviews = $$(PROJECTS_PREVIEWS);
    private SelenideElement  showMoreButton = $(SHOW_MORE_BUTTON);

}

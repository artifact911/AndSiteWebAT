package com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.fullcycleteams;

import com.andersenlab.autotests.site.page.techstack.BaseTechPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.fullcycleteams.FullCycleTeamsLocators.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Блок "Full-cycle development teams"
 */
@Getter
public class FullCycleTeamsBlock extends BaseTechPage {
    private ElementsCollection seeMoreLinks = $$(SEE_MORE_LINKS);
    private SelenideElement requestTeamButton = $(REQUEST_TEAM_BUTTON);
    private SelenideElement popupRequest = $(POPUP_REQUEST);
}

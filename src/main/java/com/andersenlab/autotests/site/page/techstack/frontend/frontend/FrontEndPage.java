package com.andersenlab.autotests.site.page.techstack.frontend.frontend;

import com.andersenlab.autotests.site.page.homepage.blocks.clients.OurSatisfiedClientsBlock;
import com.andersenlab.autotests.site.page.techstack.BaseTechPage;
import com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.besurequality.BeSureOfQualityBlock;
import com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.fullcycleteams.FullCycleTeamsBlock;
import com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.getspecialist.GetSpecialist;
import com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.knowrealprice.KnowRealPriceBlock;
import com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.ourengineers.OurEngineersBlock;
import com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.parthnerships.LastingPartnershipsBlock;
import com.andersenlab.autotests.site.page.techstack.frontend.frontend.blocks.versatiletools.VersatileToolsBlock;
import lombok.Getter;

/**
 * Front-end // ________ https://andersenlab.com/find-developers/front-end
 */
@Getter
public class FrontEndPage extends BaseTechPage {
    GetSpecialist getSpecialist = new GetSpecialist();
    VersatileToolsBlock versatileTools = new VersatileToolsBlock();
    KnowRealPriceBlock knowRealPrice = new KnowRealPriceBlock();
    OurEngineersBlock ourEngineers = new OurEngineersBlock();
    BeSureOfQualityBlock beSureOfQuality = new BeSureOfQualityBlock();
    OurSatisfiedClientsBlock ourSatisfiedClients = new OurSatisfiedClientsBlock();
    LastingPartnershipsBlock lastingPartnerships = new LastingPartnershipsBlock();
    FullCycleTeamsBlock fullCycleTeams = new FullCycleTeamsBlock();
}


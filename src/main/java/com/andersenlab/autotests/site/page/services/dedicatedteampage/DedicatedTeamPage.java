package com.andersenlab.autotests.site.page.services.dedicatedteampage;


import com.andersenlab.autotests.site.page.services.dedicatedteampage.blocks.technologies.TechnologiesBlock;
import com.andersenlab.autotests.site.page.services.dedicatedteampage.blocks.specialists.RequestSpecialistsBlock;
import lombok.Getter;

/**
 *Dedicated team  https://andersenlab.com/services/dedicated-team
 */
@Getter
public class DedicatedTeamPage {
    private RequestSpecialistsBlock requestSpecialists = new RequestSpecialistsBlock();
    private TechnologiesBlock technologiesBlock = new TechnologiesBlock();
}

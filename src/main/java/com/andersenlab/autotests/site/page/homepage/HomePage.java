package com.andersenlab.autotests.site.page.homepage;

import com.andersenlab.autotests.site.page.homepage.blocks.heading.HeadingBlock;
import com.andersenlab.autotests.site.page.homepage.blocks.clients.OurSatisfiedClientsBlock;
import com.andersenlab.autotests.site.page.homepage.blocks.meetustomorrow.MeetUsTomorrowBlock;
import com.andersenlab.autotests.site.page.homepage.blocks.navbar.NavBarBlock;
import com.andersenlab.autotests.site.page.homepage.blocks.startproject.StartProjectBlock;
import com.andersenlab.autotests.site.page.homepage.blocks.technologies.TechnologiesBlock;
import com.andersenlab.autotests.site.page.homepage.blocks.topcompanies.TopCompaniesBlock;
import com.andersenlab.autotests.site.page.homepage.blocks.topcompaniescards.CardsTopCompaniesBlock;
import lombok.Getter;
/**
 * Andersen Home page  https://www.andersenlab.com/
 */
@Getter
public class HomePage {
    private TechnologiesBlock technologies = new TechnologiesBlock();
    private TopCompaniesBlock topCompanies = new TopCompaniesBlock();
    private OurSatisfiedClientsBlock ourSatisfiedClients = new OurSatisfiedClientsBlock();
    private HeadingBlock headingBlock = new HeadingBlock();
    private StartProjectBlock startProject = new StartProjectBlock();
    private CardsTopCompaniesBlock cardsTopCompaniesBlock = new CardsTopCompaniesBlock();
    private MeetUsTomorrowBlock meetUsTomorrowBlock = new MeetUsTomorrowBlock();
    private NavBarBlock navBarBlock = new NavBarBlock();
}

package com.andersenlab.autotests.site.page.industries.ecommerce;

import com.andersenlab.autotests.site.page.industries.ecommerce.blocks.attractsell.AttractSellBlock;
import com.andersenlab.autotests.site.page.industries.ecommerce.blocks.heading.HeadingBlock;
import com.andersenlab.autotests.site.page.industries.ecommerce.blocks.industryleaders.IndustryLeadersBlock;
import com.andersenlab.autotests.site.page.industries.ecommerce.blocks.letstalk.LetsTalkBlock;
import com.andersenlab.autotests.site.page.industries.ecommerce.blocks.reachout.ReachBlock;
import lombok.Getter;

/**
 * Custom eCommerce development services https://andersenlab.com/industries/ecommerce
 */
@Getter
public class EcommercePage {
    private HeadingBlock headingBlock = new HeadingBlock();
    private AttractSellBlock attractSellBlock = new AttractSellBlock();
    private IndustryLeadersBlock industryLeadersBlock = new IndustryLeadersBlock();
    private LetsTalkBlock letsTalkBlock = new LetsTalkBlock();
    private ReachBlock reachBlock = new ReachBlock();


}

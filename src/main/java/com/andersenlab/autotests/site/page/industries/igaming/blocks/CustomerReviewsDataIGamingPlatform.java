package com.andersenlab.autotests.site.page.industries.igaming.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataIGamingPlatform implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Mark Halla", "Product owner", "", "I'd love to recommend Andersen based on our experience. We've had really challenging work for them with a very limited budget and timelines. Solutions that they recommended to our Online Casino based on deep analysis of our business saved us a lot of time and money. Everything was done in time and the result fully satisfied us. MuleSoft and Tableau were new products for us but we already see great value to use them as a part of the Salesforce ecosystem.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

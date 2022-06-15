package com.andersenlab.autotests.site.page.services.salesforce.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataSalesForce implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Riley Stone", "Product manager", "", "Good teamwork and excellent result! Andersen helped us with the migration of our data and business to new platform. They helped us with sales cloud settings and adopted our sales process to the salesforce standards. As well they recommended us to move our marketing campaigns to Pardot which was fantastic decision as well. All our employees are happy with the result and our main metrics are growing! Strongly recommended!", ""},
            {"Jacqueline Moore", "Business relationship manager", "", "Andersen did a great job and helped us a lot with deep integration of our offline stores into our Salesforce CRM. Good work, team!", ""},
            {"Mark Halla", "Product owner", "", "I'd love to recommend Andersen based on our experience. We've had really challangable work for them with very limited budget and timelines. Solutions that they recommended based on deep analysis of our business saved us a lot of time and money. Everything was done in time and the result fully satisfied us. MuleSoft and Tableu was new products for us but we already see great value to use them as a part of Salesforce ecosystem.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

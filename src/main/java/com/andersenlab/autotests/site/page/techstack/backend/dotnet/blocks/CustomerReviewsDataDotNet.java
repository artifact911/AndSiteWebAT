package com.andersenlab.autotests.site.page.techstack.backend.dotnet.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataDotNet implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Maxim Ezerskiy", "Vice-president at GMCS", "", "I didn’t believe that a domestic outsourcing vendor could create a qualitative bug-free software product, but the work performed by Andersen’s developers and their dedication made me change my mind. The Point-of-Sale software delivered by Andersen works smoothly and error-free, allowing me and my employees to relax and rely entirely on it.", START_WITH + "/our-projects/software-for-pos-terminal"},
            {"Peter Zielke", "CEO at Exigo", "", "As with any solution delivery and operations support project, unforeseen problems arise that have to be addressed. The manner in which the Andersen team rectified even the smallest issue is indeed a tribute to your organization. In addition, we really appreciate an opportunity to be agile in terms of changing needs, because your company was able to provide highly professional engineers able to address new challenges.", START_WITH + "/our-projects/platform-for-direct-sales-companies"},
            {"Peter Richardson", "Executive Director at Vivadigi", "", "We have had a 2 year-long collaboration with Andersen. It has been a good and effective process despite the distance between the countries. The web product for staff department automation was satisfactory. Feedback is positive so far, even though the app is still in beta. The team is not only cost-effective but also punctual while delivering high-quality work and providing solutions.", ""},
            {"Gaj Varma", "Communication manager at Frugl", "", "We’ve been fortunate to work with Andersen on our money-saving application. We saw their professionalism, communicative and technical skills, which make the entire team personable and enjoyable to work with. Thank you for your diligent work and the responsibility you showed during the project development.", START_WITH + "/our-projects/app-for-groceries-price-comparison"},
            {"Doug McDaniel", "Senior Facilities Manager at Walmart", "", "So far, Andersen has proven that they’re the perfect partner and have built a workforce management platform per requirements. The team was communicative, dedicated, and responsive. Consistent updates, prompt bug fixing, and their emphasis on taking care of their customers make Andersen a top-notch vendor.", ""},
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

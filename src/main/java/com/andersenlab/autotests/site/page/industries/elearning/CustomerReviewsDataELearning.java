package com.andersenlab.autotests.site.page.industries.elearning;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataELearning implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Karey Patterson", "Chairman and Managing Director at eReserve", "", "We work with multiple vendors, and Andersen became the fourth software agency we hired to find solutions needed for our research app. Now their PHP team is the first in the number of engineers and performance, helping us to configure infrastructure and model of cooperation to make all the vendors work a single standard. Currently, we are able to measure the work of all developers from our vendors.", ""},
            {"", "Managing Director at an eLearning Firm", "", "By testing our library catalog systems, Andersen enabled us to focus on clients and deliver more effective service. This company earned recognition for its transparency, responsiveness, and proactive project management. They explained each task clearly and immediately addressed any issues.", ""},
            {"", "CEO at a Learning Materials Company", "", "While the work is ongoing, the development of our booking system and learning platform allows us to react quickly to customer's needs and requirements. Andersen is communicative and organized in a smooth workflow establishing driven by its hard-working, reliable, and dedicated team.", ""},
            {"", "Project manager", "", "Andersen’s team provides high-quality services, as it was with our ERP app. They are available for comfortable communication, rely on daily scrums and bi-weekly progress reviews to stay on track.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

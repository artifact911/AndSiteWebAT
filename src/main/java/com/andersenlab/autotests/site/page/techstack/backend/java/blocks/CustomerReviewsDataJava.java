package com.andersenlab.autotests.site.page.techstack.backend.java.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataJava implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Yury Galustov", "Regional Director at IG Soft", "", "To begin with, I would like to mention that Andersen makes the development process absolutely clear. We were able to interview the React team provided and check their skills. They worked according to best practices accepted in our company, communication was comfortable for both sides, and we obtained full information about our payment app development. It was a pleasure doing business with you.", ""},
            {"Luis Urcia", "Regional Business Delivery manager at Technaura Systems", "", "We requested Andersen to provide us with developers who can transfer our digital platform for online investments to modern technology and help our team with the extension of the functionality. IT-specialists offered by the company successfully coped with all the tasks. Also, special thanks for the development of the calculators which are the key features of the platform.", START_WITH + "/our-projects/digital-platform-for-online-investments"},
            {"Bob Gifford", "Engineering & Product Manager at Greenwald Industries", "", "Andersen provided us with experts who were professional in taking business goals in mind, creative in giving multiple design options, sensitive to cost considerations, and sensitive to details. We were glad to work with Andersen’s Back-End development team and would recommend this company as a trusted and highly responsible outsourcing vendor.", START_WITH + "/our-projects/solution-for-laundry-services"},
            {"Laura Stevens", "Communication manager", "", "We are very pleased with the professional standards applied to our medical supplier development project by all of your team members. All work was timely, right to the budget, and the real proof is the feedback from our employees and clients who use this system every day. We truly hope for further partnership with Andersen.", START_WITH + "/our-projects/web-based-version-of-ehr-system"},
            {"Adrian Dickerson", "Senior delivery manager", "", "We hear a lot of stories about outsourcing vendors who ask a lot of money for their services and then leave their customers with nothing. Fortunately, Andersen is not the case. We have our high-functional mobile platform improved right the way we expected, and the price for that was reasonable. I can say that Andersen is one of those outsourcing vendors that take a responsible approach to the given task, regardless of its size or level of difficulty.", START_WITH + "/our-projects/platform-for-virtual-mobile-network-operators"},
            {"Donna Goodman", "Business relationship manager", "", "Andersen's team developed an excellent analytical web application and showed a genuine interest in producing great results. All the problems that we faced during the development process were addressed quickly and professionally.", START_WITH + "/our-projects/application-for-marketing-analysis"},
            {"Robert Flynn", "Product owner Ericcson", "", "We set the goal of solving the problem with low water quality, and since the problem is serious, we needed the most skilled and motivated developers that would be able to provide a really good code. That’s why it was decided to include Andersen’s Back-End engineers in our large team. We believe that together we will be one step closer to clean water provision.", START_WITH + "/our-projects/iot-solution-for-water-quality-monitoring"}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}
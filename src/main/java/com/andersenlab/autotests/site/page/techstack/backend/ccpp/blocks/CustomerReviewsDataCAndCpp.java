package com.andersenlab.autotests.site.page.techstack.backend.ccpp.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataCAndCpp implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Yury Galustov", "Regional Director at IG Soft", "", "To begin with, I would like to mention that Andersen makes the development process absolutely clear. We were able to interview the React team provided and check their skills. They worked according to best practices accepted in our company, communication was comfortable for both sides, and we obtained full information about our payment app development. It was a pleasure doing business with you.", ""},
            {"John Specter", "Deputy Director at Samsung electronics", "", "There were some difficulties at the start of the project because we had to spend much time on requirements elicitation. But then Andersen suggested us to add a business analyst and the job went well. Finally, I was able to focus on business objectives instead of project control. Andersen showed us how can outsource vendors develop an expensive solution with high quality.", START_WITH + "/our-projects/application-for-smart-tvs"},
            {"Robert Flynn", "Product owner Ericcson", "", "We set the goal of solving the problem with low water quality, and since the problem is serious, we needed the most skilled and motivated developers that would be able to provide a really good code. That’s why it was decided to include Andersen’s Back-End engineers in our large team. We believe that together we will be one step closer to clean water provision.", START_WITH + "/our-projects/iot-solution-for-water-quality-monitoring"},
            {"Raymond Green", "PR manager", "", "We are really grateful to Andersen's Back-End engineers for the help they provided to us. Without you, guys, we wouldn’t be able to release the desired and so much needed optimization solution. We appreciate your efforts, dedication, and deep knowledge of smart technologies. Thank you again!", START_WITH + "/our-projects/smart-waste-management"},
            {"Laura Stevens", "Communication manager", "", "We are very pleased with the professional standards applied to our medical supplier development project by all of your team members. All work was timely, right to the budget, and the real proof is the feedback from our employees and clients who use this system every day. We truly hope for further partnership with Andersen.", START_WITH + "/our-projects/web-based-version-of-ehr-system"}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

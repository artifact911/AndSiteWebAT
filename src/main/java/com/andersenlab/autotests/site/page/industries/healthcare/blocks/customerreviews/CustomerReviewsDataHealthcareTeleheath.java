package com.andersenlab.autotests.site.page.industries.healthcare.blocks.customerreviews;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataHealthcareTeleheath implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Laura Stevens", "Communication manager", "", "We are very pleased with the professional standards applied to our medical supplier development project by all of your team members. All work was timely, right to the budget, and the real proof is the feedback from our employees and clients who use this system every day. We truly hope for further partnership with Andersen.", START_WITH + "/our-projects/web-based-version-of-ehr-system"},
            {"Heikki Räisänen", "CEO at Emfit", "", "We are completely satisfied with Andersen as a partner. We are happy with the effective and innovative interface that Andersen has developed for our healthcare app. Thank you and hope our further cooperation will remain fruitful.", START_WITH + "/our-projects/iot-solution-for-monitoring-sleep-quality"},
            {"Daniel Gibbs", "Public Relations Manager", "", "We set a goal to create a highly efficient digital assistant aimed at helping in surgical practice. Obviously, the software for that system was expected to be high profile too. Andersen has not only delivered the software that fully meets the requirements but also helped us improve the idea by suggesting to implement several additional features and develop a corresponding mobile app for remote control.", START_WITH + "/our-projects/software-for-a-surgery-visualization-system"},
            {"Ethan Kelley", "Product manager", "", "We decided to launch such a service to help people who fight with severe diseases find medical cannabis, as well as nearby dispensaries, vape accessory shops, and doctors easily, with the help of functional and user-friendly web and mobile applications. And we managed to achieve our goal with the help of a software team from Andersen. The developers conducted diligent work to make the services even more convenient.", START_WITH + "/our-projects/app-for-medical-cannabis-search"}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

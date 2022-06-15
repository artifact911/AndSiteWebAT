package com.andersenlab.autotests.site.page.techstack.mobile.ionic.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataIonic implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Heikki Räisänen", "CEO at Emfit", "", "We are completely satisfied with Andersen as a partner. We are happy with the effective and innovative interface that Andersen has developed for our healthcare app. Thank you and hope our further cooperation will remain fruitful.", START_WITH + "/our-projects/iot-solution-for-monitoring-sleep-quality"},
            {"Ted R. Nelson", "Chief Information Officer at East Coast Warehouse & Distribution", "", "Within a short amount of time, Andersen's team met all goals and deadlines, delivering a high-quality internal mobile app that met all our requirements and features. They demonstrated professionalism, giving responsible feedback, good ideas, and held in-person meetings during all stages of the project. They handled everything needed and came up with additional features and solutions.", ""},
            {"Niko Järvinen", "Founder & CTO at Naava", "", "Andersen provided us with two brainy cross-platform developers who made a really cool mobile application. According to the feedback received, our clients love the app, claiming its efficiency and ease of use. In fact, we have nothing to complain about. All we can do is just thank Andersen’s IT guys for their work.", START_WITH + "/our-projects/application-for-smart-green-walls"}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

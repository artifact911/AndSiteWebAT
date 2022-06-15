package com.andersenlab.autotests.site.page.techstack.frontend.reactjs.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataReactJS implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Heikki Räisänen", "CEO at Emfit", "", "We are completely satisfied with Andersen as a partner. We are happy with the effective and innovative interface that Andersen has developed for our healthcare app. Thank you and hope our further cooperation will remain fruitful.", START_WITH + "/our-projects/iot-solution-for-monitoring-sleep-quality"},
            {"Christian A. Mathiesen", "Head of Research and Development at Purity IT AS", "", "Our partnership with Andersen started 3 years ago, and for all this time the company has never failed us or made us doubt our choice of outsourcing vendor. We are quite satisfied with our cooperation and going to extend the development team.", START_WITH + "/our-projects/reporting-and-administration-software"},
            {"Karey Patterson", "Chairman and Managing Director at eReserve", "", "We work with multiple vendors, and Andersen became the fourth software company we hired. Now their PHP team is the first in amount of engineers and performance. Moreover, Andersen helped us to configure infrastructure and model of cooperation in a way to make all the vendors work a single standard. And now we are able to measure the work of all developers from our vendors.", ""},
            {"Yury Galustov", "Regional Director at IG Soft", "", "To begin with, I would like to mention that Andersen makes development process absolutely clear. We were able to interview the React team provided and check their skills. They worked according to best practices accepted in our company, communication was comfortable for both sides, and we obtained full information about the project. It's been a pleasure doing business with you.", ""},
            {"Sergey Korenev", "Head designer of internet projects at National Cable Networks", "", "We needed a mobile solution for inner use that would work with both Android and iOS. As we didn’t have such specialists in our company, we decided to outsource the cross-platform development to Andersen. Their specialists created an amazing app that our employees love, so we are really pleased with the results. I would say that your cross-platform developers made a miracle, as it has helped us to double our working efficiency. So many many thanks to you.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

package com.andersenlab.autotests.site.page.techstack.mobile.xamarin.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsXamarin implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Sergey Korenev", "Head designer of internet projects at National Cable Networks", "", "We needed a mobile solution for inner use that would work with both Android and iOS. As we didn’t have such specialists in our company, we decided to outsource the cross-platform development to Andersen. Their specialists created an amazing app that our customers love, and we are pleased with the results too. I would say that your cross-platform developers made a miracle, as it has helped us to double our working efficiency. So many many thanks to you.", ""},
            {"Peter Ollikainen", "Chairman at Centa Solutions", "", "Our business relations with Andersen started only a few months ago, but I already see that their engineers are really masters of their craft, especially developers of Xamarin for our mobile application. So far, the results are satisfactory: the interface is user-friendly, intuitive, and works the way we need, plus the new portion of functionality is delivered quite fast. We are glad to cooperate with them.", ""},
            {"Daniel Gibbs", "Public Relations Manager", "", "We set a goal to create a highly efficient digital assistant aimed at helping in surgical practice. Obviously, the software for that system was expected to be high profile too. Andersen has not only delivered the software that fully meets the requirements but also helped us improve the idea by suggesting to implement several additional features and develop a corresponding mobile app for remote control.", START_WITH + "/our-projects/software-for-a-surgery-visualization-system"}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

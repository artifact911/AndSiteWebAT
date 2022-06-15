package com.andersenlab.autotests.site.page.techstack.mobile.reactnative.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsReactNative implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Jouni Stam", "CTO at Yonoton", "", "The company made a great first impression with the business analyst who gathered requirements, measured the scope, and asked about our other needs. The project manager and other team members kept us informed about the business app's schedule and progress and made sure that everything was going according to our expectations. Andersen stands out where it comes to communication and planning.", START_WITH + "/our-projects/app-for-ordering-tickets-and-meal-during-matches"},
            {"Doug McDaniel", "Senior Facilities Manager at Walmart", "", "So far, Andersen has proven that they’re the perfect partner and have built a workforce management platform per requirements. The team was communicative, dedicated, and responsive. Consistent updates, prompt bug fixing, and their emphasis on taking care of their customers make Andersen a top-notch vendor.", ""},
            {"Bonnie Steinlein", "Director Of Information Technology at Costco Wholesale", "", "Andersen's efforts to our marketing analysis platform development successfully decreased spending and increased data collection. They are personable specialists with a tendency to exceed expectations. Their depth of knowledge has been a highlight. We highly recommend Andersen.", ""},
            {"Kristian Karimo", "President of OurCnC", "", "We have been cooperating with Andersen for more than 3 years. I'm convinced that Andersen's specialists are trustworthy and skillful. They have designed a management panel and a mobile application for our company. Every comment from us was taken into account to create a design that looks perfect and fits all our needs. During the project, we involve UI/UX specialists from Andersen to create our website design as well. I admire the hard-working team that helps me to improve the product. Hope for maintaining our successful collaboration! Thanks a lot!", ""},
            {"Dr. Mirko Jaumann", "COO at Doppelgänger", "", "Andersen successfully executed a mobile app for our startup, that serves as the client's core offering. We were always kept well informed of the project progress. Additionally, the team was friendly and easy to work with, their response rate and the quality of code were particularly impressive.", ""},
            {"Gert Becker", "PR Manager", "", "Establishing this partnership, we planned to give Andersen a try and pass them the development of one subproject to see their performance. The work was done well enough, so we gave these guys another task. And thus, step by step, Andersen’s engineers won our confidence with their clean code, business-friendly ideas, and full transparency. Our cooperation extended to the work on four subprojects in the travel industry, and we are ready to entrust them with a task of any complexity.", START_WITH + "/our-projects/solutions-for-travel-services"},
            {"Niko Järvinen", "Founder & CTO at Naava", "", "Andersen provided us with two brainy cross-platform developers who made a really cool mobile application. According to the feedback received, our clients love the app, claiming its efficiency and ease of use. In fact, we have nothing to complain about. All we can do is just thank Andersen’s IT guys for their work.", START_WITH + "/our-projects/application-for-smart-green-walls"},
            {"Pauline Byrd", "Business relationship manager", "", "12-month cooperation between our company and Andersen’s user interface development team was incredibly friendly and fruitful. Together we managed to build a truly modern and high-profile system that provides the opportunity for the successful development of our business and simple procedure for car renting.", START_WITH + "/our-projects/digital-platform-for-car-rental"}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

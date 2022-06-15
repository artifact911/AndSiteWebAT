package com.andersenlab.autotests.site.page.services.qa.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataQA implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Sören Andersson", "Scrum Master at Yonoton", "", "As a fast growing startup with a small team but rapidly growing client base we were in dire need of professional QA services to ensure our developed products meet the required standards. The QA services provided by Andersen has proven to be of very high quality and has improved the quality of our products in a very short time. The QA team at Andersen aided us to improve our workflow and focus a lot more on development processes and our core business. The QA team members have excellent communication skills and are alway ready to give suggestions on how to further improve our processes, something we highly value in our team.", ""},
            {"Kirill Frolov", "Product Leader at IBS", "https://clutch.co/profile/andersen#review-1510028", "The engagement successfully reduced the time spent testing, meeting the expectations of the internal team. Andersen establishes a smooth workflow through consistent communication. The team is hard-working and driven.", ""},
            {"Pär-Olof Hjorth", "CEO at Uniter", "", "The quality of the application is significantly increased, clients give the positive feedback and the team gives good statistics in the performance report. Well-coordinated work of the team helps to develop valuable features, which attract the potential clients. As a result, it was decided to focus on the UI part of the application to make it more user-friendly, new tasks for development are defined. The problems with task description are still actual because the BA is not introduced to the project, but these problems are not so major because of the well-established communication of the team with the customer's representatives. The customer is completely satisfied with the work of QA and AQA, notes their professional skills.", ""},
            {"Oleg Nikolaev", "Head of BA and QA Department", "", "1. I would like to admit the team's quick start. Actually, in the first two sprints, the guys were already involved in the production process and took over some of the tasks that were in production 2. High quality of test documentation that will be used for regression testing and onboarding of new employees (both analysts and testers) 3. Willingness to share the experience in building the testing process 4. Consistency in the implementation of changes in the production process 5. Open-mindedness", ""},
            {"Dmitry Guralnik", "Program manager", "", "Andersen's QA team has proven to be a very professional automated testing partner. The onboarding process was fast enough to get started quickly. The Andersen QA team proposes improvements to process and tech solutions. Recommended for cooperation.", ""},
            {"", "Chief Technology Officer", "https://clutch.co/profile/andersen#review-1387331", "Andersen’s QA team has been the difference between failure and success for our development process. The QA team catches the vast majority of bugs before they get to our clients. Their experience has helped increase the amount of features we can deliver to our clients in each development cycle.", ""},
            {"", "CEO at RideShare", "https://clutch.co/profile/andersen#review-1167401", "Andersen has proven itself to be a solid and reliable partner in software development and testing. From day one, the QA team have shown a huge amount of professionalism and drive to deliver great results. The team ensure that they deeply understand the platform, they are always on hand to answer questions, they provide incredibly detailed test/regression reports and create detailed videos & demos.", ""},
            {"", "Chief Technology Office", "https://clutch.co/profile/andersen#review-1172730", "Flexible and innovative, Andersen provides industry-leading QA solutions. Their transparent communication style, coupled with their dedicated approach, sets them apart from other firms.", ""},
            {"", "Owner", "https://clutch.co/profile/andersen#review-1534589", "Qualified resources using best practices (Development, QA and AQA Engineers), Reporting. Andersen team helped with realization of 5-6 main features, QA & AQA increased coverage, etc.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

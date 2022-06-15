package com.andersenlab.autotests.site.page.services.businessanalysts.blocks;

import com.andersenlab.autotests.core.utils.PropertiesReader;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataBA implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Philip Bishop", "Delivery manager", "", "We heard from our business partners that Andersen is a trusted outsourcing vendor that provides truly qualitative software development services. That’s why we decided to contact Andersen when realized that there is an urgent need in the app improvements. And the team that was provided for our project didn’t disappoint us. So we can confirm that Andersen is a good choice for your software project.", START_WITH + "/our-projects/app-for-making-payments-and-managing-paperwork"},
            {"Janis Staseluns", "Group Head of IT Service Management", "", "Andersen, having huge experience in lending solutions, provides cross-functional team that created solution from scratch and customized it to use in more than 11 different region. Andersen is quick to respond to business requests, and they have a deep talent bench to pull from. Customers can expect a professional and timely partner.", START_WITH + "/our-projects/system-for-issuing-short-term-loans"},
            {"Laura Stevens", "Communication manager", "", "We are very pleased with the professional standards applied to this project by all of your team members. All of the work was timely, right to the budget, and the real proof is the feedback from our employees and clients who use this system every day. We really hope for further partnership with Andersen.", START_WITH + "/our-projects/web-based-version-of-ehr-system"},
            {"Heikki Räisänen", "CEO at Emfit", "", "We are completely satisfied with having Andersen as a partner. We believe that Andersen is the right outsourcing vendor for our company, which can develop truly effective and innovative solutions that are so crucial for the healthcare industry. Thank you and hope our further cooperation will remain fruitful.", START_WITH + "/our-projects/iot-solution-for-monitoring-sleep-quality"},
            {"Jeffrey Reyes", "Head of Testing 3D4Medical Limited", "", "We have just started our relationship with Andersen, and they have proven to be a professional and effective organization. To date, my needs have been in the area of Quality Assurance. Projects were organized quickly, delivered successfully and to a high standard. Working with a remote contractor, communication is key, and this Andersen excels in. I would highly recommend Andersen to deliver a quality product, to specification, on time.", ""},
            {"Barak Aviv", "QA Manager Top Image Systems", "", "We hired 5 QA engineers from Andersen for functional mobile testing of the application for image capture and processing. The app has web and mobile versions and is designed to make mobile check deposit, enrollment, account opening, bill payment and other mobile-initiated processes simple and fun.", ""},
            {"Julia Pokhodina", "Senior Project Manager Anima Interactive Agency", "", "We asked Andersen to conduct a complex testing of our developed website. During the communication Andersen specialists offered us an efficient and cost-effective option that allowed us to save money for testing. From the very beginning of our cooperation the communication with experts was at a good level, and in the course of testing, Andersen proved their professionalism, providing quality work on time. Thank you!", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

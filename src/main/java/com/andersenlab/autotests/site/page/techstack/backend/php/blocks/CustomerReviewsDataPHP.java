package com.andersenlab.autotests.site.page.techstack.backend.php.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataPHP implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Sören Andersson", "Scrum Master at Yonoton", "", "Our ordering platform development was successful, resulting in quick growth for the company. Andersen provides quality results on time, adhering to set deadlines. The team is hard-working, dedicated, and professional.", ""},
            {"Jouni Stam", "CTO at Yonoton", "", "The company made a great first impression with the business analyst who gathered requirements, measured the scope, and asked about our other needs. The project manager and other team members kept us informed about the business app's schedule and progress and made sure that everything was going according to our expectations. Andersen stands out where it comes to communication and planning.", START_WITH + "/our-projects/app-for-ordering-tickets-and-meal-during-matches"},
            {"Jeffrey Reyes", "Head of Testing at 3D4Medical Limited", "", "We have just started our relationship with Andersen, and they have proven to be a professional and effective organization. To date, my needs have been in the area of our healthcare consulting app's Quality Assurance. Projects were organized quickly, delivered successfully, and to a high standard. Working with a remote contractor, communication is key, and this Andersen excels in. I would highly recommend Andersen as a supplier of a quality product that meets specifications and is always ready on time.", ""},
            {"Christian A. Mathiesen", "Head of Research and Development at Purity IT AS", "", "Our partnership with Andersen started 3 years ago, and for all this time the company neither failed us during the reporting and administration system development process nor made us doubt our choice of outsourcing vendor. We are quite satisfied with our cooperation and going to extend the development team.", START_WITH + "/our-projects/reporting-and-administration-software"},
            {"Luther Monson", "Lead Programmer and CTO at BCL Soft", "", "I wanted to express our appreciation for the excellent services that we received from the Andersen company in the development of our barter platform. It was a pleasure to work with your professionals that are interested to create a high-quality application and treated the project as if it were their own.", START_WITH + "/our-projects/web-application-for-barter-transactions"},
            {"Christine Jarro", "General Manager at Stiles", "", "Andersen's ability to translate an innovative idea into functional technology has played a critical part in our business growth. The team executed efficient Agile project management, communicated effectively, and regularly provided thorough explanations in both technical and non-technical terms. We have full trust in their work and we can only wish there were more companies like them.", ""},
            {"Heikki Räisänen", "CEO at Emfit", "", "We are completely satisfied with Andersen as a partner. We are happy with the effective and innovative interface that Andersen has developed for our healthcare app. Thank you and hope our further cooperation will remain fruitful.", START_WITH + "/our-projects/iot-solution-for-monitoring-sleep-quality"},
            {"Jessica Bourne", "Chief of Staff Team at AT&T", "", "Developers from Andersen are brilliant in their expertise. Great communication skills, reporting various challenges ahead of time. Andersen’s commitment to our information system development project allowed us to consult changes and track the progress on a regular basis. Given the complexity of the project, we're very happy with their output thus far.", ""},
            {"Jonas Rosat", "Sr. Product Owner at FedEx Ground", "", "Andersen delivered a top-quality platform that accommodates high influxes of site traffic. They've done an excellent job thus far of complying with the requirements of the scope of work and meeting deadlines. Given the complexity of this time tracking project, we're very happy with their output thus far.", ""},
            {"Andrei Kashutin", "Deputy Director at United Electronic Market Place", "", "We developed an Electronic marketplace with Andersen. There were some difficulties at the start of the project but finally, we got exactly what expected. I’d like to stress the experience of the team in general and Vitaly in particular, who was a PHP developer. He made much more than expected and demonstrated a high level of proficiency at PHP 7 and Symfony 4. I'm also satisfied with qualitative testing and error absence at the delivered software.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}
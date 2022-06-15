package com.andersenlab.autotests.site.page.industries.logistics;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataLogistics implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Kristian Karimo", "President of OurCnC", "", "We have been cooperating with Andersen for more than 3 years. I'm convinced that Andersen's specialists are trustworthy and skillful. They have designed a management panel and a mobile application for our company. Every comment from us was taken into account to create a design that looks perfect and fits all our needs. During the project, we involve UI/UX specialists from Andersen to create our website design as well. I admire the hard-working team that helps me to improve the product. Hope for maintaining our successful collaboration! Thanks a lot!", ""},
            {"Jonas Rosat", "Sr. Product Owner at FedEx Ground", "", "Andersen delivered a top-quality platform that accommodates high influxes of site traffic. They've done an excellent job thus far of complying with the requirements of the scope of work and meeting deadlines. Given the complexity of this time tracking project, we're very happy with their output thus far.", ""},
            {"Jeff Buschelmann", "Chief Operating Officer at TMS Logistics", "", "Bringing on Andersen's team helped boost the development rate and quality of the software, meeting the expectations of the internal team. At every stage of the production logistics management service development, it was demonstrated that Andersen doesn’t only focus on programming, but works to become a trusted consultant, one that doesn’t hesitate to suggest better solutions.", ""},
            {"Dave Meirick", "Director - Business Strategy and Development at RoadSafe Traffic Systems", "", "We were looking for an experienced development partner to expand our project further and we can't imagine not working with Andersen. Their professionalism, flexibility, and expertise are undeniable. This traffic monitoring app’s design elements and functionalities align with the original requirements. Andersen’s smooth and organized workflow laid grounds for a successful project and lasting partnership.", ""},
            {"Ted R. Nelson", "Chief Information Officer at East Coast Warehouse & Distribution", "", "Within a short amount of time, Andersen's team met all goals and deadlines, delivering a high-quality internal mobile app that met all our requirements and features. They demonstrated professionalism, giving responsible feedback, good ideas, and held in-person meetings during all stages of the project. They handled everything needed and came up with additional features and solutions.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

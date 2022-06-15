package com.andersenlab.autotests.site.page.industries.travelandhospitality.blocks.heading;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataTravelAndHospitality implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Dalia Burack", "Vice President at Bluegreen Vacations", "", "Resources Andersen provided were capable, reliable, and committed. They demonstrated best-in-class communication to offset challenges inherent to remote collaboration. They understood project goals well and did great at developing a functional back-end for data storage and analysis. The team performed very thorough testing, which has resulted in good customer satisfaction rates.", ""},
            {"David Smiley", "General Manager at Gurney's Newport Resort & Marina", "", "The company helped us with creating the concept of the web application from scratch. The team executed efficient Agile project management, communicated effectively, and regularly provided thorough explanations in both technical and non-technical terms. On a consistent basis, their strong work ethic included proactive effort.", ""},
            {"Gert Becker", "PR Manager", "", "Establishing this partnership, we planned to give Andersen a try and pass them the development of one subproject to see their performance. The work was done well enough, so we gave these guys another task. And thus, step by step, Andersen’s engineers won our confidence with their clean code, business-friendly ideas, and full transparency. Our cooperation extended to the work on four subprojects in the travel industry, and we are ready to entrust them with a task of any complexity.", START_WITH + "/our-projects/solutions-for-travel-services"},
            {"Elisabeth Langenberg", "Public Relations Manager", "", "We heard about Andersen from our partners and decided to give them a try, as the rates they suggest are truly favorable. In a couple of weeks working together, it became clear that the quality of their job is no less favorable: all three modules are bug-free and run like clockwork, the specialists are full of ideas how to turn a good thing into the best one, the whole development process is transparent. Hence I do recommend considering Andersen as your next software vendor.", START_WITH + "/our-projects/discount-calculator-and-hotel-selection"},
            {"", "Technical Lead at TUI Deutschland", "", "The Front-End development team provided helped us push out high-quality products in a timely manner, meeting our expectations, so we could fully focus on our clients. Andersen's hard-working and talented people establish open and honest communication to ensure a smooth workflow.", ""},
            {"", "Product Owner at FTI", "", "Andersen satisfied the requirements by designing our outsourcing services and adhering to the budget and schedule. They helped us define project goals and provided some actionable insights. The team handled project management seamlessly and worked quickly to deliver the final product in just a few months.", ""},
            {"Bartosz Nowak", "Head of Development", "", "We were looking for an outsourcing partner able to make updates to our travel application tool with the highest level of quality. The outcome was very good as well as the cooperation process itself.", ""},
            {"", "CTO at Alchimea", "", "So far, Andersen's team do their best to integrate our travel platform into a global distribution system. Going the extra mile, Back-End engineers provide expert advice, assistance, and support. They are a team of intelligent, businesslike developers who produce high-quality work within the project timeline and are dedicated to achieving business goals.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

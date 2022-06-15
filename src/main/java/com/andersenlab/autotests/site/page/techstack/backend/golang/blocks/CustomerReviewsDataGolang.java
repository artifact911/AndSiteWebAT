package com.andersenlab.autotests.site.page.techstack.backend.golang.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataGolang implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Vladimir Kovalenko", "Head of software development at Tinkoff Insurance", "", "We have been working with Andersen for more than 4.5 years. They provide us with scrum teams and consulting services. Working together, we have created hundreds of new features and improvements for the banking software. They helped us to establish a very efficient quality assurance process, as well as to move forward in the field of quality control automation. We are completely satisfied with our cooperation and can definitely recommend Andersen as a reliable partner.", START_WITH + "/our-projects/solution-for-a-virtual-bank"},
            {"Heikki Räisänen", "CEO at Emfit", "", "We are completely satisfied with Andersen as a partner. We are happy with the effective and innovative interface that Andersen has developed for our healthcare app. Thank you and hope our further cooperation will remain fruitful.", START_WITH + "/our-projects/iot-solution-for-monitoring-sleep-quality"},
            {"David Smiley", "General Manager at Gurney's Newport Resort & Marina", "", "The company helped us with creating the concept of the web application from scratch. The team executed efficient Agile project management, communicated effectively, and regularly provided thorough explanations in both technical and non-technical terms. On a consistent basis, their strong work ethic included proactive effort.", ""},
            {"Neil Kelly", "Engineering Director at Yellow Card", "", "Andersen's engineering team knows our business very well. They create architecture and cover mobile software development. Their skilled expertise supplemented ongoing engagement and partnership. The team at Andersen is communicative and responsive. They act as part of the team, going above & beyond to develop our Cryptocurrency Exchange Platform. Their professionalism is top-notch as well.", ""},
            {"", "Technical Lead at TUI Deutschland", "", "The Front-End development team provided helped us push out high-quality products in a timely manner, meeting our expectations, so we could fully focus on our clients. Andersen's hard-working and talented people establish open and honest communication to ensure a smooth workflow.", ""},
            {"Elisabeth Langenberg", "Public Relations Manager", "", "We heard about Andersen from our partners and decided to give them a try, as the rates they suggest are truly favorable. In a couple of weeks working together, it became clear that the quality of their job is no less favorable: all three modules are bug-free and run like clockwork, the specialists are full of ideas how to turn a good thing into the best one, the whole development process is transparent. Hence I do recommend considering Andersen as your next software vendor.", START_WITH + "/our-projects/discount-calculator-and-hotel-selection"},
            {"Dalia Burack", "Vice President at Bluegreen Vacations", "", "Resources Andersen provided were capable, reliable, and committed. They demonstrated best-in-class communication to offset challenges inherent to remote collaboration. They understood project goals well and did great at developing a functional back-end for data storage and analysis. The team performed very thorough testing, which has resulted in good customer satisfaction rates.", ""}
    };

    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

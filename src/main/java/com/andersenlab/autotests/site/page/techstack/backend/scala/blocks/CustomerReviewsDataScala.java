package com.andersenlab.autotests.site.page.techstack.backend.scala.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataScala implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Vladimir Kovalenko", "Head of software development at Tinkoff Insurance", "", "We have been working with Andersen for more than 4.5 years. They provide us with scrum teams and consulting services. Working together, we have created hundreds of new features and improvements for the banking software. They helped us to establish a very efficient quality assurance process, as well as to move forward in the field of quality control automation. We are completely satisfied with our cooperation and can definitely recommend Andersen as a reliable partner.", START_WITH + "/our-projects/solution-for-a-virtual-bank"},
            {"Heloïse Pinette", "Public relations expert at BNP Paribas", "", "Experts from Andersen showed incredible dedication and creativity while helping us meet this challenge. We discussed what was expected from the product with Business Analysts, and the result didn’t disappoint us: the solution includes all the necessary modules and functionality to cope with banking regulatory documents analysis effectively.", START_WITH + "/our-projects/solution-for-legislation-changes-monitoring"},
            {"Luis Urcia", "Regional Business Delivery manager at Technaura Systems", "", "We requested Andersen to provide us with developers who can transfer our digital platform for online investments to modern technology and help our team with the extension of the functionality. IT-specialists offered by the company successfully coped with all the tasks. Also, special thanks for the development of the calculators which are the key features of the platform.", START_WITH + "/our-projects/digital-platform-for-online-investments"},
            {"", "CEO at a Learning Materials Company", "", "While the work is ongoing, the development of our booking system and learning platform allows us to react quickly to customer's needs and requirements. Andersen is communicative and organized in a smooth workflow establishing driven by its hard-working, reliable, and dedicated team.", ""},
            {"", "Head of projects", "", "They’re very professional, well organized, and a pleasure to work with. Solid engineering skills and vast experience in the investment area were the key factors to select Andersen as our software development provider. We’ve already done several projects together. Their quality compares favorably with other providers. The team is proactive, and they reach out when they need guidance to keep the project moving forward. Their project management is outstanding.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

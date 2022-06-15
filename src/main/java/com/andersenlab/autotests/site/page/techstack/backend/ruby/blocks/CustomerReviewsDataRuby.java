package com.andersenlab.autotests.site.page.techstack.backend.ruby.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataRuby implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Karey Patterson", "Chairman and Managing Director at eReserve", "", "We work with multiple vendors, and Andersen became the fourth software agency we hired to find solutions needed for our research app. Now their PHP team is the first in the number of engineers and performance, helping us to configure infrastructure and model of cooperation to make all the vendors work a single standard. Currently, we are able to measure the work of all developers from our vendors.", ""},
            {"Alexander Turner", "Product manager", "", "Initially, we hired only two developers to try out our platform for data analysis, but then, after realizing Andersen’s staff consists of truly top-notch specialists, we decided to expand the development team and establish a long-term partnership. I would say that every single Andersen's specialist, from a developer to a project manager, is a seasoned expert.", START_WITH + "/our-projects/improvement-of-a-data-analysis-platform"},
            {"", "Managing Director at an eLearning Firm", "", "By testing our library catalog systems, Andersen enabled us to focus on clients and deliver more effective service. This company earned recognition for its transparency, responsiveness, and proactive project management. They explained each task clearly and immediately addressed any issues.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}
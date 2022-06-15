package com.andersenlab.autotests.site.page.industries.igaming.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataIGaming implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Maxim Khorev", "Product owner", "", "Having worked with Andersen's team for more than a year, I would say that this is a professional firm that knows its business pretty well. This vendor offers skilled developers that have great ideas, provide innovative solutions, and truly care about doing a good job. Thank you, guys, for everything you have done for our online movie theatre!", START_WITH + "/our-projects/platform-for-watching-videos-on-smart-tvs"},
            {"Hilda Randall", "Business relationship manager", "", "Andersen was a great business partner to work with. Its team provided expert advice on all phases of our analytical app development, were extremely supportive and responsive to all the queries, and delivered a high-quality market product.", START_WITH + "/our-projects/application-for-marketing-analytics"},
            {"Antti Paukku", "Software Architect at Management Events", "", "Throughout the duration of the project, from requirements gathering to implementation, the Front-End engineers of Andersen have conducted themselves with the utmost professionalism and dedication to the process transformation project. The people at Andersen fulfilled their obligations taking into account our best interests. Their sincere interest in wanting to help us achieve our goals was readily apparent throughout the development process.", START_WITH + "/our-projects/system-for-managing-events"},
            {"Roger Lawson", "Product manager", "", "IT guys from Andersen grasp things in a single flash! During our cooperation, we had to change requirements to our secure sharing product hundreds of times, and fortunately, it didn’t cause any trouble, so we received quality software at the end. You are amazing, guys!", START_WITH + "/our-projects/application-for-encrypted-message-communication"},
            {"Gleb Smorodkin", "CTO", "", "I want to express my gratitude to Andersen company and each member of the team we were lucky enough to work with. I should note not only their excellent technical skills but also very good competencies in the payments and cards area. We are glad to have Andersen as a partner and hope our cooperation will be strengthened each day.", START_WITH + "/our-projects/solution-for-internet-acquiring"}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

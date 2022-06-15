package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataMobileDevelopment implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Robert Gifford", "Senior Software Engineer at Greenwald Industries", "https://clutch.co/profile/andersen#review-1493024", "The app has earned a positive response so far, securing large orders from end clients. Moreover, Andersen’s team has established a streamlined ticketing process to ensure timely delivery. They’re communicative, deliver high-quality work, and even recommend alternative solutions to improve the app.", ""},
            {"Sören Andersson", "Scrum Master at Yonoton", "https://clutch.co/profile/andersen#review-1465673", "The project was successful, resulting in quick growth for the client's company. Andersen provides quality results in a timely manner, adhering to set deadlines. The team is hard-working, dedicated, and professional.", ""},
            {"Yuriy Kartsev", "Mobile Dev Lead at Alfa Capital", "https://clutch.co/profile/andersen#review-1198314", "Both internal and external stakeholders are pleased with the new chat feature. Regular communication and rapid problem resolutions were hallmarks of the engagement. Andersen's development expertise sets it apart from other providers.", ""},
            {"Christian Johnsson", "CEO at Ventunix Consulting", "https://clutch.co/profile/andersen#review-1260974", "Andersen delivered the app to expectations. Their swift workflow complemented their professional management style. They're available for their clients.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

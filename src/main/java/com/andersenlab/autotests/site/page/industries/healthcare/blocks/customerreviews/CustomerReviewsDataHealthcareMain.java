package com.andersenlab.autotests.site.page.industries.healthcare.blocks.customerreviews;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataHealthcareMain implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Jeffrey Reyes", "Head of Testing at 3D4Medical Limited", "", "We have just started our relationship with Andersen, and they have proven to be a professional and effective organization. To date, my needs have been in the area of our healthcare consulting app's Quality Assurance. Projects were organized quickly, delivered successfully, and to a high standard. Working with a remote contractor, communication is key, and this Andersen excels in. I would highly recommend Andersen as a supplier of a quality product that meets specifications and is always ready on time.", ""},
            {"Heikki Räisänen", "CEO at Emfit", "", "We are completely satisfied with Andersen as a partner. We are happy with the effective and innovative interface that Andersen has developed for our healthcare app. Thank you and hope our further cooperation will remain fruitful.", START_WITH + "/our-projects/iot-solution-for-monitoring-sleep-quality"},
            {"Cameron Champion", "Executive Director at Parallel", "", "This life improvement app is very user-friendly, customers and third parties are impressed by how functional and pertinent the platform is. Andersen’s commitment to the project allowed us to consult changes and track the progress on a regular basis. Timely and client-oriented, the team takes ownership of their work.", ""},
            {"Ethan Kelley", "Product manager", "", "We decided to launch such a service to help people who fight with severe diseases find medical cannabis, as well as nearby dispensaries, vape accessory shops, and doctors easily, with the help of functional and user-friendly web and mobile applications. And we managed to achieve our goal with the help of a software team from Andersen. The developers conducted diligent work to make the services even more convenient.", START_WITH + "/our-projects/app-for-medical-cannabis-search"},
            {"John Farmer", "Product owner at BT Internet", "", "Andersen’s Front-End development team built an excellent web-center that facilitates our certain business processes. We didn’t face any problems with communication, deadlines, or code quality: the process went smoothly, and the result was more than satisfactory. Thank you, guys, for your dedicated work!", START_WITH + "/our-projects/software-for-certificates-storage"},
            {"Daniel Gibbs", "Public Relations Manager", "", "We set a goal to create a highly efficient digital assistant aimed at helping in surgical practice. Obviously, the software for that system was expected to be high profile too. Andersen has not only delivered the software that fully meets the requirements but also helped us improve the idea by suggesting to implement several additional features and develop a corresponding mobile app for remote control.", START_WITH + "/our-projects/software-for-a-surgery-visualization-system"},
            {"Lee Cheng", "Director of services", "", "One of our partners recommended Andersen as a good customer support partner so once we faced the necessity to get some technical support we decided to contact them first. The combination of their rates and the value provided within their services look valuable for us and we’re glad they were able to cover all range of technical support required by our customers. The development of our medicine app is still in progress and new features are added regularly but we see that Andersen's team has the skills and attitude to support them as well. We like the cooperation with Andersen and rate them as a trusted partner.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

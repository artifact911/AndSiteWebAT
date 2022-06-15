package com.andersenlab.autotests.site.page.techstack.backend.python.blocks;

import com.andersenlab.autotests.site.page.services.customsoftware.blocks.customerreviews.CustomerReviewsData;
import lombok.Getter;

@Getter
public class CustomerReviewsDataPython implements CustomerReviewsData {
    private final String[][] TEXT_ARTICLES = new String[][]{
            {"Sergey Korenev", "Head designer of internet projects at National Cable Networks", "", "We needed a mobile solution for inner use that would work with both Android and iOS. As we didn’t have such specialists in our company, we decided to outsource the cross-platform development to Andersen. Their specialists created an amazing app that our customers love, and we are pleased with the results too. I would say that your cross-platform developers made a miracle, as it has helped us to double our working efficiency. So many many thanks to you.", ""},
            {"Savraj Singh Dhillon", "Director - Business Strategy and Development at Vaco", "", "Andersen establishes a smooth workflow, utilizing project management software. The team is hard-working, experienced, and innovative. The recruitment website is well received by its users and it fulfills all the initial requirements of the project. The admin panel they included has helped save time as well.", ""},
            {"Dalia Burack", "Vice President at Bluegreen Vacations", "", "Resources Andersen provided were capable, reliable, and committed. They demonstrated best-in-class communication to offset challenges inherent to remote collaboration. They understood project goals well and did great at developing a functional back-end for data storage and analysis. The team performed very thorough testing, which has resulted in good customer satisfaction rates.", ""},
            {"Anna Sinyakova", "Procurement manager at Nexign", "", "Andersen quickly and seamlessly integrated all changes into the existed architecture. Providing confident and experienced assistance, the team implemented upgrades to our accommodating software that has reduced the testing time of new products and increased the speed of implementing new services.", START_WITH + "/our-projects/solution-for-software-testing"},
            {"Julia Pokhodina", "Senior Project Manager at Anima Interactive Agency", "", "We asked Andersen to conduct complex testing of the website we developed. During the communication, Andersen specialists offered us an efficient and cost-effective option that allowed us to save money. From the very beginning of our cooperation, the communication with experts was at a good level, and in the course of testing, Andersen proved their professionalism, providing quality work on time. Thank you!", ""},
            {"Christof Bitschnau", "CEO at Quantics", "", "We recently finalized the design phase for the frontend of our advanced analytics solution. We very much appreciate the collaboration with Andersen Lab. The process was professionally managed, we could closely monitor all changes in the design process, propose required changes, discuss new ideas, and adaptions were swiftly incorporated. We particularly like the flexible, quick, and uncomplicated way of cooperation with Andersen Lab.", ""},
            {"Collin Fletcher", "Product manager", "", "I would like to leave only positive feedback upon our close collaboration with the Andersen team in the recruiting software development operation. Resource allocation and development processes were well managed. Team members were goal-oriented and responsive, always completed their tasks within deadlines.", START_WITH + "/our-projects/recruitment-software-solution"},
            {"Gleb Smorodkin", "CTO", "", "I want to express my gratitude to Andersen company and each member of the team we were lucky enough to work with. I should note not only their excellent technical skills but also very good competencies in the payments and cards area. We are glad to have Andersen as a partner and hope our cooperation will be strengthened each day.", START_WITH + "/our-projects/solution-for-internet-acquiring"},
            {"Raymond Green", "PR manager", "", "We are really grateful to Andersen's Back-End engineers for the help they provided to us. Without you, guys, we wouldn’t be able to release the desired and so much needed optimization solution. We appreciate your efforts, dedication, and deep knowledge of smart technologies. Thank you again!", START_WITH + "/our-projects/smart-waste-management"},
            {"", "Head of projects", "", "They’re very professional, well organized, and a pleasure to work with. Solid engineering skills and vast experience in the investment area were the key factors to select Andersen as our software development provider. We’ve already done several projects together. Their quality compares favorably with other providers. The team is proactive, and they reach out when they need guidance to keep the project moving forward. Their project management is outstanding.", ""}
    };
    private final int artsQuantity = TEXT_ARTICLES.length;
    private final Boolean buttonSlick = true;
}

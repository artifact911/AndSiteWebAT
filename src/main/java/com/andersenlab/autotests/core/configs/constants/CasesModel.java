package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class CasesModel {
    protected static String BASE_ROUTE = "https://d3jqtupnzefbtn.cloudfront.net/andersenlab/new-andersensite/cases";
    protected static String ORIGAMI_ROUTE = "/origami/visual-concept-extended";
    protected static String CINEMEYE_ROUTE = "/cinemeye/visual-concept-extended";
    protected static String MERCEDES_ME_ROUTE = "/mercedes-me/visual-concept-extended";
    protected static String GLOBE_CHANNEL_ROUTE = "/globe-channel/visual-concept-extended";
    protected static String SAMSUNG_ROUTE = "/samsung/visual-concept-extended";
    protected static String WINNERS_ROUTE = "/winners/visual-concept-extended";

    public enum SectionTitles{
        CONCEPT("Visual concept"),
        ABOUT("About the project"),
        FUNCTIONALITY("Application functionality"),
        SOLUTION("Solution"),
        RESULTS("Project Results"),
        CONTACT_US("Contact us to learn more and receive a free consultation");
        @Getter private final String text;
        SectionTitles(String text){
            this.text = text;
        }
    }

    public enum ImageLinks{
        ORIGAMI(Arrays.asList(
                BASE_ROUTE + ORIGAMI_ROUTE + "/origami-vc-1-1200.png",
                BASE_ROUTE + ORIGAMI_ROUTE + "/origami-vc-2-1200.png",
                BASE_ROUTE + ORIGAMI_ROUTE + "/origami-vc-3-1200.png",
                BASE_ROUTE + ORIGAMI_ROUTE + "/origami-vc-4-1200.png",
                BASE_ROUTE + ORIGAMI_ROUTE + "/origami-vc-5-1200.png")),
        CINEMEYE(Arrays.asList(
                BASE_ROUTE + CINEMEYE_ROUTE + "/cinemaeye-vc-1-1200.png",
                BASE_ROUTE + CINEMEYE_ROUTE + "/cinemaeye-vc-2-1200.png",
                BASE_ROUTE + CINEMEYE_ROUTE + "/cinemaeye-vc-3-1200.png",
                BASE_ROUTE + CINEMEYE_ROUTE + "/cinemaeye-vc-4-1200.png",
                BASE_ROUTE + CINEMEYE_ROUTE + "/cinemaeye-vc-5-1200.png")),
        MERCEDES_ME(Arrays.asList(
                BASE_ROUTE + MERCEDES_ME_ROUTE + "/mercedes-vc-1-1200.jpg",
                BASE_ROUTE + MERCEDES_ME_ROUTE + "/mercedes-vc-2-1200.jpg",
                BASE_ROUTE + MERCEDES_ME_ROUTE + "/mercedes-vc-3-1200.jpg",
                BASE_ROUTE + MERCEDES_ME_ROUTE + "/mercedes-vc-4-1200.jpg",
                BASE_ROUTE + MERCEDES_ME_ROUTE + "/mercedes-vc-5-1200.jpg")),
        GLOBE_CHANNEL(Arrays.asList(
                BASE_ROUTE + GLOBE_CHANNEL_ROUTE + "/globe-vc-1-1200.jpg",
                BASE_ROUTE + GLOBE_CHANNEL_ROUTE + "/globe-vc-2-1200.jpg",
                BASE_ROUTE + GLOBE_CHANNEL_ROUTE + "/globe-vc-3-1200.jpg",
                BASE_ROUTE + GLOBE_CHANNEL_ROUTE + "/globe-vc-4-1200.jpg",
                BASE_ROUTE + GLOBE_CHANNEL_ROUTE + "/globe-vc-5-1200.jpg")),
        SAMSUNG(Arrays.asList(
                BASE_ROUTE + SAMSUNG_ROUTE + "/samsung-vc-1-1200.jpg",
                BASE_ROUTE + SAMSUNG_ROUTE + "/samsung-vc-2-1200.jpg",
                BASE_ROUTE + SAMSUNG_ROUTE + "/samsung-vc-3-1200.jpg",
                BASE_ROUTE + SAMSUNG_ROUTE + "/samsung-vc-4-1200.jpg",
                BASE_ROUTE + SAMSUNG_ROUTE + "/samsung-vc-5-1200.jpg")),
        WINNERS(Arrays.asList(
                BASE_ROUTE + WINNERS_ROUTE + "/winners-vc-1-1200.jpg",
                BASE_ROUTE + WINNERS_ROUTE + "/winners-vc-2-1200.jpg",
                BASE_ROUTE + WINNERS_ROUTE + "/winners-vc-3-1200.jpg",
                BASE_ROUTE + WINNERS_ROUTE + "/winners-vc-4-1200.jpg",
                BASE_ROUTE + WINNERS_ROUTE + "/winners-vc-5-1200.jpg"));
        @Getter private final List<String> links;
        ImageLinks(List<String> links){
            this.links = links;
        }
    }

    public enum SEOOptimization {
        ORIGAMI(Arrays.asList("Desktop", "Diligent work of experts to enhance the needs of million audience.",
                "Sign in page", "Home page", "Movies page", "Content page", "Catalog page", "Profile page", "Subscriptions page", "Cross-platform"
        )),
        CINEMEYE(Arrays.asList(
                "Watch the latest episodes of your favorite TV show or pick some good old films to favorite with a quick and convenient filter search - Cinemeye is an streaming service that can offer you both the ultra-convenient functionality and the huge collection of the award-winning TV shows, movies, documentaries, and more.",
                "Since this project was being created for millions of users, the main task was to create the most convenient interface, supported by a powerful development solution. Carefully chosen colors and shapes have also become the hallmarks that together created the exciting atmosphere of the modern cinema.",
                "Cinemeye is a cross-platform application, so you can enjoy your favorite movies using any device convenient for you. Sitcom or comedy, tablet or laptop - whatever you choose, with Cinemeye you always get the highest quality and the perfect usability.",
                "Forming the concept of the future design and structure of the Cinemeye project, we’ve done a great work defining this small piece of space, where everything moves in harmony.",
                "Admiring the vastness of space, its unreal flares and the pure white glow of billions of stars, we have created this stunning deep design that beckons to dive into it headlong.",
                "The logo is not only the face of the company, but also its main adornment. Therefore, it is imperative to take branding as seriously as possible.",
                "Get a deep sense of the dark aesthetic accented with these vibrant neon bursts of color. The color palette was hand-picked specifically for this project.",
                "Using the results of the user testing made it possible to deeply understand the target audience and create a truly in-demand and convenient product, increasing conversion by 35%."
        )),
        MERCEDES_ME(Arrays.asList(
                "Having developed a unique user experience, Andersen has won the competition for the right to develop a software product for MERCEDES ME CAFÉ. The world-renowned car manufacturer has chosen us due to our expertise in delivering interactive solutions in the Entertainment and Media industry",
                "Two main requirements for the product were the ability to order meals and drinks from the electronic menu and interact with the multimedia marketing materials. Every order, placed in the system, is uploaded to the working terminals of the Café, where personnel can then process it.",
                "Andersen’s experts divide each creative process into stages in order to take into account all the important details in the course of work. Considering the peculiarities of the UCD approach, we decided to implement flexible analytics, making it possible to analyze the actions and behavior of users at different stages.",
                "The main characteristics of the personas were one of the key elements deciding the product's success. In order to ensure the effectiveness of the personas, we conducted a thorough investigation highlighting potential Café visitors, their main goals and problems. In fact, we paid more attention to personas than usual, and this allowed us to build an excellent user experience.",
                "Roman is the CEO of a large marketing company. He lives in the center of Moscow with his wife and child in his own apartment. Roman drives a Mercedes CLS-Class Coupé. He values his time. He is looking for a café with delicious food where he can have a snack during his break. The opportunity to check the condition of his car and book a service would be nice bonuses.",
                "Marina is a blogger. An extrovert. She lives in the center of Moscow with her husband and child in her own apartment. Marina drives a Mercedes GLA-Class . She does household chores and takes her child to school. In her free time, she meets with her friends or goes to the gym.",
                "To analyze user actions and further flow testing, we highlighted a project map that grew into a flow later. This solution made it possible to track the location of users and activity at one or another level of interaction. As a result, we were immediately ready for testing and, thanks to analytics, did not miss a single click.",
                "Home Page", "Menu", "Models", "Customize", "Service", "Dealers"
        )),
        GLOBE_CHANNEL(Arrays.asList("Overview", "User Flow", "Style", "Home Page", "Live", "Channel Guide", "VOD",
                "A team of our UI designers worked on an app for Globe - a global TV channel dedicated to the theme of our planet. We were tasked with making a convenient and functional application that allows users to transfer the function of watching TV to their phones.",
                "The designers took this step out for a comprehensive UX study to further design the app, navigation through it, and how the end user will use the product.",
                "In our work, we used the channel\\'s corporate colors and fonts, as well as got inspiration from the natural palette that correlates with the theme of the channel and does not distract the user from the content.",
                "On the main page, the entire program of the TV channel for the current day is presented in the form of circles. When clicking on the circle, the user is immediately directed to the video player. The main page also contains a selection of movies of different categories and genres.",
                "As we mentioned above, the user can watch on the phone those programs that are currently on the air on TV. The full-format player is built into the app, and below the player, there is a page that tells you which programs will be on the air next.",
                "We also worked on a user-friendly interface for the TV program. There is a schedule with small text descriptions and previews, as well as detailed full-screen descriptions of individual programs with ratings.",
                "Thanks to the integration of VOD (personal delivery of media content to the subscriber), the user of the mobile app can use the fast rewind programs. There is an opportunity to pause or save the movie on the air in the record. The user can also make a personal list of programs that they want to watch or have already seen. All movies are categorized. Plus, there is a personal list that the user makes themselves by marking movies with the heart button."
        )),
        SAMSUNG(Arrays.asList("Visual Style", "Home Page", "TV Channels", "Movie / Series page", "Player", "Library",
                "An affiliate that produces equipment for Samsung appealed to Andersen’s team for the implementation of an innovative entertainment solution. The solution was intended to improve the user experience of Samsung’s customers who use Samsung’s smart TVs. After the launch of the application, sales of customer’s TVs increased by 1.1%. In this respect, almost 4% of clients started to use the application on their smart TVs as the main. In 6 months since the app was launched, the customer satisfaction score reached 83%.",
                "The team was inspired by this year\\'s fashionable gradient (transition of colors), which brands of multimedia applications use in their visual communication. The designers settled on rich blueberry, muted grays, and bright pink.",
                "The UI/UX specialists made the homepage intuitive and user-friendly: the screen is divided into several blocks, where you can select series or shows from bookmarks, popular now, etc. The ficher with the suggested shows is tapped, the menu does not draw attention to itself, but it is noticeable and located on the side.",
                "The detailed program of TV channels is also designed by the feeder with previews in circles. Below the block, there are programs that are currently on the air. When you click on the specific channel, you see a page with a detailed description of the TV programs of the channel you chose.",
                "The page with TV series and movies is also divided into two blocks: one is large and detailed, about the current movie, and the other one below - a ficher with all episodes of the TV-show in chronological order.",
                "When the user clicks the play button, they get to an expanded window of the built-in multimedia player.",
                "The library page is divided into several sections: downloaded movies, fiches, and TV show recordings. Each of the fiches has a small clickable preview."
        )),
        WINNERS(Arrays.asList("User Flow", "Home Page", "Events", "Channels", "Player", "Selected Channel",
                "Winners is a digital venue marketing and commercial grade live streaming solution that utilises your existing TVs and social media to drive footfall and sales – one easy to use platform that helps you get payback on your sports subscription costs.",
                "Having 75+ channels streaming live sports, from Winners on your TV in should be the most awesome digital experience in world.",
                "The team conducted research within the UX realm to make the user experience intuitive and logically aligned. All stages of the user path are presented in the blocks below.",
                "The home page is designed in the customer\\'s corporate colors (muted blue and deep orange). It presents a preview of the current game that the user is interested in. A block below is a feeder, where you can scroll through other live broadcasts or upcoming game broadcasts.",
                "On the event page, you can select the sport you are interested in and the day you want to check out the game. On the right side, there is a detailed schedule on a semi-transparent backing so as not to distract the user\\'s attention.",
                "With the channels, we followed a tabular logic, where the time and a brief description of the broadcasts are placed according to the week\\'s grid. When you click on the air of a particular channel, you have the option to record the broadcast or go directly to the channel.",
                "In the built-in player, all classic multimedia functions are available (full screen, rewind, pause, record, etc.). Plus, by clicking on \\'more\\' in the menu located on the left side, the user can select broadcasts from other TV channels without switching to other pages.",
                "When you click on \\'selected channel\\', the screen becomes divided into two visual blocks: the block with what is currently playing and the block with programs you might want to watch or your library of recordings."
        ));
        @Getter private final List<String> hiddenText;
        SEOOptimization(List<String> hiddenText){
            this.hiddenText = hiddenText;
        }
    }
}

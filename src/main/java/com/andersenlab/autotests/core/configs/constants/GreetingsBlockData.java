package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GreetingsBlockData {
    public enum Page {
        LOGISTICS(createMap(Arrays.asList(
                "Greetings,\n\nI’m proud to introduce Andersen's team of Logistics development and tell you about our Services. By drawing upon the extensive expertise in the area of software development, based on cutting-edge technologies and individual approach we are able to support you in the successful digital business transformation. Our company offers a wide spectrum of fast and competitive services. \n\nLet us guide you on attaining your goals and put your organization ahead of competitors in the logistics and supply chain market. You are always welcome to send me your request.",
                "Nice to meet you!",
                "Evgeniy Busleyko",
                "Head of Logistics Technologies",
                "https://www.linkedin.com/in/evgenibusleyko",
                ""))),
        HEALTHCARE(createMap(Arrays.asList(
                "Dear Business Partner,\n\nI am delighted to introduce Andersen's Healthcare development team and guide you through the complex world of digital transformation in Healthcare. I am happy to assist you in your aspiration to improve the quality, efficiency, and coordination of patient care. Feel free to contact me for healthcare software solutions. Best wishes and thank you for reaching out to Andersen!",
                "Nice to meet you!",
                "Sergey Avdeychik",
                "Director of Healthcare Technologies",
                "https://www.linkedin.com/in/sergey-avdeychik-2b8ba973/",
                "https://profiles.forbes.com/members/bizdev/profile/Sergey-Avdeychik-Director-Healthcare-Technologies-Andersen/91e701c7-77dd-4224-9cd6-4258bc2ade26")));

        @Getter private final HashMap<String, String> str;

        Page(HashMap<String, String> str){
            this.str = str;
        }
        static HashMap<String, String> createMap(List<String> V){
            List<String> K = Arrays.asList("message", "title", "name", "position", "linkedin", "forbes");
            HashMap<String, String> map = new HashMap<>();
            for (int index = 0; index < K.size(); index++){
                map.put(K.get(index), V.get(index));
            }
            return map;
        }
    }
}
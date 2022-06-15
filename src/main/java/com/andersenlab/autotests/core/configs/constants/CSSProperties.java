package com.andersenlab.autotests.core.configs.constants;

import lombok.Getter;

public class CSSProperties {
    public enum Color{
        INVISIBLE("rgba(0, 0, 0, 0)"),
        BLACK_LINK("rgba(2, 3, 3, 1)"),
        WHITE("rgba(250, 250, 250, 1)"),
        GRAY("rgba(224, 224, 224, 1)"),
        YELLOW("rgba(255, 219, 0, 1)"),
        YELLOW_RGB("rgb(254, 218, 0)"),
        LIGHT_YELLOW("rgba(255, 233, 99, 1)"),
        BRIGHT_LIGHT_YELLOW("rgba(255, 219, 0, 1)");
        @Getter private final String code;
        Color(String code){
            this.code = code;
        }
    }

    public enum TextDecoration {
        BLACK_UNDERLINE("none solid rgb(2, 3, 3)"),
        BLUE_UNDERLINE("none solid rgb(85, 97, 112)");
        @Getter private final String code;
        TextDecoration(String code)
        {
            this.code = code;
        }
    }

    public enum Animation {
        DEFAULT("none 0s ease 0s 1 normal none running");
        @Getter private final String code;
        Animation(String code){
            this.code = code;
        }
    }
}
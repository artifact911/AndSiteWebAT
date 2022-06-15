package com.andersenlab.autotests.core.configs.constants;

public enum DTFPatterns {
    DEFAULT("HH:mm:ss SSS");

    private final String pattern;

    DTFPatterns(String pattern){
        this.pattern = pattern;
    }

    public String getPattern(){
        return this.pattern;
    }
}

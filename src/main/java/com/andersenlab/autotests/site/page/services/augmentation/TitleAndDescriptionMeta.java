package com.andersenlab.autotests.site.page.services.augmentation;

public enum TitleAndDescriptionMeta {

    TEAM_AUGMENTATION("dedicated-team",
            "Get qualified software developers & engineers",
            "Hire Andersen’s software developers to augment your existing team and ensure high quality! Reduce costs on management and hiring!");

    private final String url;
    private final String title;
    private final String description;

    TitleAndDescriptionMeta(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

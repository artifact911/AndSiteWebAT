package com.andersenlab.autotests.site.page.services.mobiledevelopment.blocks.techexpertise;

public class ProblemsTextsC implements ProblemsTexts {
    private String base;
    private final String BASE_QA = "//section[contains(@class, 'development-services')]";
    private final String BASE_MOB_DEV = "//h2[contains(text(), 'Andersen Mobile Tech Expertise')]//..//..//..";
    private final String BASE_BA_3_GROUPS = "(//section[contains(@class, 'what-we-do')])[1]";
    private final String BASE_BA_OUR_SERV = "(//section[contains(@class, 'what-we-do')])[2]";

    public ProblemsTextsC(String base) {
        this.base = base;
    }

    @Override
    public String getTEXT_TITLE() {
        switch (base) {
            case BASE_QA:
                return "Most common problems in testing that affect software products";
            case BASE_MOB_DEV:
                return "Andersen Mobile Tech Expertise";
            case BASE_BA_3_GROUPS:
                return "There are 3 groups of typical problems a Business Analyst solves";
            case BASE_BA_OUR_SERV:
                return "What we do";
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String[] getTEXT_ARTICLES_TITLE() {
        switch (base) {
            case BASE_QA:
                return new String[]{
                        "Low product quality:",
                        "Shortage of QA resources:",
                        "Testing process immaturity:"
                };
            case BASE_MOB_DEV:
                return new String[]{
                        "iOS",
                        "Android",
                        "Cross-platform"
                };
            case BASE_BA_3_GROUPS:
                return new String[]{
                        "Requirements complexity",
                        "No project documentation",
                        "Issues while launching"
                };

            case BASE_BA_OUR_SERV:
                return new String[]{
                        "Discovery phase",
                        "BA audit",
                        "Project documentation",
                        "Benchmarking",
                        "Consulting",
                        "Project support"
                };
            default:
                throw new IllegalArgumentException();
        }
    }

}

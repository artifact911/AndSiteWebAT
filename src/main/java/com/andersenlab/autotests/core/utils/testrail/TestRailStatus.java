package com.andersenlab.autotests.core.utils.testrail;

public enum TestRailStatus {

    PASSED(1, "Passed "),
    FAILED(5, "Failed "),
    BUG(8, "Bug "),
    IN_PROGRESS(6, "In progress ");

    private int id;
    private String comment;

    TestRailStatus(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    /**
     * Get status ID
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Get status comment
     *
     * @return
     */
    public String getComment() {
        return comment;
    }
}

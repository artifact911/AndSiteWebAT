package com.andersenlab.autotests.site.page.company.meetustomorrow;

import com.andersenlab.autotests.core.utils.utility.Utility;

import static com.andersenlab.autotests.site.page.company.meetustomorrow.MeetUsTomorrowLocators.PAGINATION_NEXT;
import static com.andersenlab.autotests.site.page.company.meetustomorrow.MeetUsTomorrowLocators.PAGINATION_PREV;

public class MeetUsTomorrowOperations {

    public void paginationNextClick() {  //todo разобрать случай использования
        Utility.operations.jsExecutorClick(PAGINATION_NEXT);
    }

    public void paginationPrevClick() {
        Utility.operations.jsExecutorClick(PAGINATION_PREV);
    }
}

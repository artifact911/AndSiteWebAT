package com.andersenlab.autotests.site.page.services.qa.blocks;

import com.andersenlab.autotests.site.form.commonforms.FormPopUp;
import com.andersenlab.autotests.site.page.services.customsoftware.blocks.softdevreach.SoftDevReach;
import com.andersenlab.autotests.site.utility.Warp;

public class SoftDevReachPlusLink extends SoftDevReach {
    private final String LINK_AUDIT = super.BASE + "//button[contains(@class, 'soft-dev-reach__additional-link')]";
    private final String LINK_AUDIT_HREF = Warp.currentURL();

    public SoftDevReachPlusLink(FormPopUp formPopUp) {
        super(formPopUp);
    }

    @Override
    public void displayingElements() {
        super.displayingElements();
//        Warp.checkLinkThisTab(LINK_AUDIT, LINK_AUDIT_HREF);  теперь кнопка не ведет на pdf, а открывает pop-up
    }

}

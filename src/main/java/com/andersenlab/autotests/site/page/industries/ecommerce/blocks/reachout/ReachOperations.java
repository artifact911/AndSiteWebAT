package com.andersenlab.autotests.site.page.industries.ecommerce.blocks.reachout;

import com.andersenlab.autotests.core.utils.utility.Utility;
import lombok.Getter;

import static com.andersenlab.autotests.site.page.industries.ecommerce.blocks.reachout.ReachLocators.*;

@Getter
public class ReachOperations {
    public String getNoEmailReachFormError() {
        return Utility.operations.getPseudoElementContent(FORM_ERROR_NO_EMAIL);
    }

    public String getNoPhoneReachFormError() {
        return Utility.operations.getPseudoElementContent(FORM_ERROR_NO_PHONE);
    }

}

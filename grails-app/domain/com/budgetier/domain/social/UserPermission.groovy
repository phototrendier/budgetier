package com.budgetier.domain.social

import com.budgetier.enums.social.SocialNetworkType
import com.budgetier.enums.social.SocialPermissionStatus

class UserPermission extends Permission {

    SocialPermissionStatus socialPermissionStatus = SocialPermissionStatus.DECLINED

    static constraints = {
        socialPermissionStatus nullable: false
    }
}

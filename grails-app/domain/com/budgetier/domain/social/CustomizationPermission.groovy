package com.budgetier.domain.social

import com.budgetier.enums.social.SocialNetworkType

class CustomizationPermission extends Permission {

    SocialNetworkType socialNetworkType = SocialNetworkType.FACEBOOK

    static constraints = {
        socialNetworkType nullable: false
    }
}

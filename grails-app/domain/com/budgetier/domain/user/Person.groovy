package com.budgetier.domain.user

import com.budgetier.domain.MongoBaseRecord
import com.budgetier.enums.management.LocaleType
import com.budgetier.enums.user.SocialNetworkType
import com.budgetier.enums.user.UserGenderType

/**
 * This class models a physical user in the application.
 */
class Person extends MongoBaseRecord {

    String firstName
    String lastName

    String email

    Boolean receiveNotifications

    SocialNetworkType socialNetworkType
    String socialNetworkId

    Boolean userVerified

    LocaleType userLocale = LocaleType.ENGLISH
    UserGenderType genderType = UserGenderType.OTHER

    static constraints = {
        firstName nullable: true
        lastName nullable: true

        email nullable: true, email: true

        receiveNotifications nullable: true

        socialNetworkType nullable: false
        socialNetworkId nullable: true

        userVerified nullable: true

        userLocale nullable: false
        genderType nullable: false
    }
}

package com.budgetier.domain.user

import com.budgetier.domain.MongoBaseRecord
import com.budgetier.domain.media.Photo
import com.budgetier.domain.social.UserPermission
import com.budgetier.enums.management.LocaleType
import com.budgetier.enums.social.SocialNetworkType
import com.budgetier.enums.user.UserGenderType

/**
 * This class models a physical user in the application.
 */
class Person extends MongoBaseRecord {

    String firstName                                    // user first name
    String lastName                                     // user last name

    String email                                        // user email

    Boolean receiveNotifications                        // defines if user accepts notifications

    SocialNetworkType socialNetworkType                 // from which social network the user logged in
    String socialNetworkId                              // the social network user id

    Boolean userVerified                                // if the user is verified

    LocaleType userLocale = LocaleType.ENGLISH          // user language preference
    UserGenderType genderType = UserGenderType.OTHER    // user gender type

    Photo profilePhoto                                  // user profile photo

    static hasMany = [permissions: UserPermission]      // permissions: social network permissions on the user

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

        profilePhoto nullable: true

        permissions nullable: true
    }
}

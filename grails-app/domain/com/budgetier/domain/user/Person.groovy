package com.budgetier.domain.user

import com.budgetier.enums.user.SocialNetworkType

/**
 * This class models a physical user in the application.
 */
class Person {

    String username                         // the account name used to login and be identified

    String firstName                        // user real first name, or whatever retrieved from social network
    String lastName                         // user real last name, or whatever defined from social network

    String email                            // user email retrieved from social network. if none is defined
                                            // then user information retrieve flow is shown in case the user
                                            // has requested to be notified by email

    Boolean receiveNotifications            // global flag on user level to enable/disable email notifications.
                                            // can be null which defaults to disabled email notifications

    SocialNetworkType socialNetworkType     // defines the social network the user selected
                                            // to login in the system

    static constraints = {
        username nullable: false, email: true

        firstName nullable: true
        lastName nullable: true

        email nullable: false, email: true

        receiveNotifications nullable: true

        socialNetworkType nullable: false
    }
}

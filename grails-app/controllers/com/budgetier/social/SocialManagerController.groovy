package com.budgetier.social

import com.budgetier.domain.user.Person

class SocialManagerController {

    def facebookService

    /**
     * This action controls the facebook success login meta events.
     * One event to occur is to check if the user has logged in before
     * with the application and if not to retrieve his information.
     */
    def facebookSuccessHandler() {
        flash.success = 'Successfully authenticated with facebook.'
        Person person = facebookService.getUserInformation(session["facebook:oasAccessToken"].token)
        session["logged_in_user"] = person
        render (view: '/index')
    }

    def facebookFailureHandler() {
        flash.error = 'Failed to authenticate with facebook.'
        render (view: '/index')
    }

    def twitterSuccessHandler() {
        flash.success = 'Successfully authenticated with twitter.'
        render (view: '/index')
    }

    def twitterFailureHandler() {
        flash.error = 'Failed to authenticate with twitter.'
        render (view: '/index')
    }
}

package com.budgetier.social

import com.budgetier.domain.user.Person
import com.budgetier.enums.social.SocialNetworkType
import org.scribe.model.Token

class SocialManagerController {

    def grailsApplication
    def grailsLinkGenerator

    def facebookService
    def oauthService
    def customOAuthService

    /**
     * This action controls the facebook success login meta events.
     * One event to occur is to check if the user has logged in before
     * with the application and if so to retrieve his information.
     * Otherwise, a new person instance must be created after retrieving
     * user information from facebook.
     */
    def facebookSuccessHandler() {
        flash.success = 'Successfully authenticated with facebook.'
        Person person = facebookService.getUserInformation(session["facebook:oasAccessToken"].token)
        session["logged_in_user"] = person
        render (view: '/index')
    }

    def facebookEmailPermissionGranted() {
        Person person = facebookService.requestUserEmail(session["facebook:oasAccessToken"].token)
        if (!person) {
            flash.error = "Your email information could not be updated."
        }
        redirect(controller: "myProfile", action: "profileManagement")
    }

    /**
     * This action controls the facebook failure login meta events. A
     * failure can mean that something went wrong or that the user
     * doesn't won't to login after all.
     */
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

    /**
     * This action controls the request of permissions. For
     * facebook a permission parameter must exist in the
     * list of parameters when the action is called.
     */
    def requestUserPermissions() {
        Person person = (Person) session["logged_in_user"];

        if (!person) {
            flash.error = message (code: "user.message.no.logged.in.user.found")

            // TODO redirect to previous action
            redirect (controller: "landing", action: "index")
        }

        String successCallback
        String failureCallback

        String providerName = person.socialNetworkType.toString().toLowerCase()

        // generate a request token if one doesn't already exist
        Token requestToken = new Token('', '')
        if (!session[oauthService.findSessionKeyForRequestToken(providerName)]) {
            session[oauthService.findSessionKeyForRequestToken(providerName)] = requestToken
        } else {
            requestToken = session[oauthService.findSessionKeyForRequestToken(providerName)]
        }

        String authorizationUrl
        switch(person.socialNetworkType) {
            case SocialNetworkType.FACEBOOK:
                successCallback = grailsLinkGenerator.link(controller: "socialManager", action: "facebookEmailPermissionGranted")
                failureCallback = grailsLinkGenerator.link(controller: "socialManager", action: "facebookFailureHandler")
                break;
            case SocialNetworkType.TWITTER:
                break;
            case SocialNetworkType.GOOGLE_PLUS:
                break;
            default:
                // TODO throw exception
                break;
        }

        authorizationUrl = customOAuthService.getAuthorizationUrl(providerName, successCallback, failureCallback, params.permission, requestToken)
        log.error "Authorization url is: " + authorizationUrl

        redirect(url: authorizationUrl)
    }
}

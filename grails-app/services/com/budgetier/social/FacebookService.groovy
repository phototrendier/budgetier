package com.budgetier.social

import com.budgetier.domain.user.Person
import com.budgetier.enums.management.LocaleType
import com.budgetier.enums.social.SocialNetworkType
import com.budgetier.enums.user.UserGenderType
import com.budgetier.utilities.EnumUtilityMethods
import grails.transaction.Transactional
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

@Transactional
class FacebookService extends ISocialNetwork {

    def grailsApplication
    def grailsLinkGenerator

    def requestPermissions(String permissions, String controller, String action) {
        String redirectUrl = grailsLinkGenerator.link(controller: controller, action: action)
        def http = new HTTPBuilder(grailsApplication.config.oauth.providers.facebook.facebookUrl)
        http.request(Method.GET, "application/json") {
            uri.path = "/"
            uri.query = [client_id: grailsApplication.config.oauth.providers.facebook.key,
                         redirect_uri: redirectUrl,
                         scope: permissions]

            response.success = { resp, json ->
                log.error resp.statusLine
                log.error json
            }

            response.failure = { resp ->
                log.error resp
            }
        }
    }

    def requestUserEmail() {
        def http = new HTTPBuilder(grailsApplication.config.oauth.providers.facebook.graphApi)
        http.request(Method.GET, "application/json") {
            uri.path = "/me"
            uri.query = [access_token: accessToken,
                         fields: "id,email"]

            response.success = { resp, json ->
                log.error resp.statusLine

                if (json.id) {
                    Person person = Person.findBySocialNetworkId(json.id)
                    if (person) {
                        if (json.email) {
                            person.email = json.email
                        }

                        if (!person.save()) {
                            log.error 'Failed to persist person instance.'
                            person.errors.each {
                                log.error it
                            }
                        }
                    }
                    return person
                }
            }

            // handler for any failure status code:
            response.failure = { resp ->
                log.error uri
                log.error "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                return null
            }
        }
    }

    @Override
    def getUserInformation(String accessToken) {
        def http = new HTTPBuilder(grailsApplication.config.oauth.providers.facebook.graphApi)
        http.request(Method.GET, "application/json") {
            uri.path = "/me"
            uri.query = [access_token: accessToken,
                         fields: "id,email,first_name,last_name,verified,gender,locale,picture"]

            response.success = { resp, json ->
                log.error resp.statusLine

                if (json.id) {
                    Person person = Person.findBySocialNetworkId(json.id)
                    if (!person) {
                        person = new Person()
                        person.firstName = json.first_name
                        person.lastName = json.last_name

                        person.socialNetworkType = SocialNetworkType.FACEBOOK
                        person.socialNetworkId = json.id

                        person.userVerified = json.verified ? Boolean.TRUE : Boolean.FALSE

                        if (json.email) {
                            person.email = json.email
                        }

                        // person gender
                        if (json.gender && EnumUtilityMethods.getEnumFromString(json.gender, UserGenderType)) {
                            person.genderType = EnumUtilityMethods.getEnumFromString(json.gender, UserGenderType)
                        }

                        // person locale
                        LocaleType localeType = LocaleType.ENGLISH
                        if (json.locale && EnumUtilityMethods.getEnumFromString(json.locale, LocaleType)) {
                            person.userLocale = EnumUtilityMethods.getEnumFromString(json.locale, LocaleType)
                        }

                        if (!person.save()) {
                            log.error 'Failed to persist person instance.'
                            person.errors.each {
                                log.error it
                            }
                        }
                    }
                    return person
                }
            }

            // handler for any failure status code:
            response.failure = { resp ->
                log.error uri
                log.error "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
            }
        }
    }

    @Override
    def getUserFriendsList(String accessToken) {
        return null
    }
}

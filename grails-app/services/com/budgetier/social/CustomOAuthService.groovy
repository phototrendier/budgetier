package com.budgetier.social

import org.scribe.builder.ServiceBuilder
import org.scribe.model.SignatureType
import org.scribe.model.Token
import uk.co.desirableobjects.oauth.scribe.OauthProvider
import uk.co.desirableobjects.oauth.scribe.SupportedOauthVersion

class CustomOAuthService {

    def oauthService

    def grailsApplication
    def grailsLinkGenerator

    private OauthProvider getServiceProvider(String providerName, String successCallback, String failureCallback, String permissions) {

        // retrieve provider configuration
        LinkedHashMap providerConfig = grailsApplication.config.oauth.providers[providerName]

        log.error providerConfig.callback
        log.error providerConfig.api

        Class api = providerConfig.api
        String callback = providerConfig.containsKey('callback') ? providerConfig.callback : null
        SignatureType signatureType = providerConfig.containsKey('signatureType') ? providerConfig.signatureType : null
        String scope = providerConfig.containsKey('scope') ? providerConfig.scope : null

        ServiceBuilder serviceBuilder = new ServiceBuilder()
                .provider(api)
                .apiKey(providerConfig.key as String)
                .apiSecret(providerConfig.secret as String)

        if (callback) {
            serviceBuilder.callback(callback)
        }

        if (permissions) {
            serviceBuilder.scope(permissions)
        }

        OauthProvider provider = new OauthProvider(
                service: serviceBuilder.build(),
                successUri: successCallback,
                failureUri: failureCallback
        )

        return provider
    }

    def getAuthorizationUrl(String providerName, String successCallback, String failureCallback, String permissions, Token token) {
        OauthProvider provider = this.getServiceProvider(providerName, successCallback, failureCallback, permissions)
        return provider.service.getAuthorizationUrl(token)
    }
}

<g:if test="${com.budgetier.enums.social.SocialNetworkType.FACEBOOK == person?.socialNetworkType}">
    <g:link class="btn btn-primary"
                  url="${grailsApplication.config.oauth.providers.facebook.facebookUrl}"
                  params="['client_id'      : grailsApplication.config.oauth.providers.facebook.key,
                           'app_id'         : grailsApplication.config.oauth.providers.facebook.secret,
                           'redirect_url'   : redirectUrl,
                           'scope'          : 'email']">
        <g:message code="button.label.refresh.from.social" args="[socialNetworkType]"/>
   </g:link>
</g:if>
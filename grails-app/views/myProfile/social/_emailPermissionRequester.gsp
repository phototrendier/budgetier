<g:if test="${com.budgetier.enums.social.SocialNetworkType.FACEBOOK == person?.socialNetworkType}">
    <g:link class="btn btn-primary pull-right" controller="socialManager" action="requestUserPermissions" params="['permission' : 'email']">
        <g:message code="button.label.refresh.from.social" args="[socialNetworkType]"/>
   </g:link>
</g:if>
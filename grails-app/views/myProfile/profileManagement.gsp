<%--
  Created by IntelliJ IDEA.
  User: vbledar
  Date: 10/10/14
  Time: 18:30
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta name="layout" content="main"/>

    <title>
        <g:message code="page.title.profile.management" default="Profile Management"/>
    </title>
</head>

<body>

    <g:set var="socialNetworkType" value="${message(code: person?.socialNetworkType?.i18nDescriptive)}"/>

    <div class="page-header">
        <h1>
            <g:message code="profile.management.header"/>
            <br />
            <small>
                <g:message code="profile.management.sub.header"/>
            </small>
        </h1>
    </div>


    <div class="row">
        <div class="col-sm-2 text-center">
            <h3>
                <g:message code="profile.management.profile.picture"/>
            </h3>
            <g:if test="${person?.profilePhoto}">
                <g:img uri="${person?.profilePhoto?.photoUrl}" class="img-responsive"/>
            </g:if>
            <g:else>
                <g:set var="socialNetworkType" value="${message(code: person?.socialNetworkType?.i18nDescriptive)}"/>
                <button class="btn btn-primary btn-sm">
                    <g:message code="button.label.load.from.social" args="[socialNetworkType]"/>
                </button>
            </g:else>
        </div>
        <div class="col-sm-10">
            <g:form controller="myProfile" action="updateProfile">
                <blockquote>
                    <label class="text-muted"><g:message code="form.field.first.name"/></label>
                    <strong>
                        ${person?.firstName}
                    </strong>
                </blockquote>
                <blockquote>
                    <label class="text-muted"><g:message code="form.field.last.name"/></label>
                    <strong>
                        ${person?.lastName}
                    </strong>
                </blockquote>
                <blockquote>
                    <label class="text-muted"><g:message code="form.field.email"/></label>
                    %{--<button class="btn btn-primary btn-sm pull-right">--}%
                        %{--<g:message code="button.label.refresh.from.social" args="[socialNetworkType]"/>--}%
                    %{--</button>--}%

                    <g:render template="social/emailPermissionRequester" model="[person: person]"/>

                    <div class="spacer10"></div>

                    <input id="email" name="email" type="email" class="form-control" placeholder="Enter your email" value="${person?.email}">

                    <div class="spacer10"></div>

                    <div class="alert alert-warning">
                        <h5>
                            <g:message code="profile.management.email.from.social.message" args="[socialNetworkType]"/>
                        </h5>
                    </div>
                </blockquote>
                <blockquote>
                    <div class="checkbox">
                        <label>
                            <input name="receiveNotifications" type="checkbox" ${person.receiveNotifications ? 'checked': ''}> <g:message code="profile.management.receive.email.notifications"/>
                        </label>
                    </div>
                </blockquote>
                <blockquote>
                    <label class="text-muted"><g:message code="form.field.user.gender"/></label>
                    <g:select name="genderType"
                              from="${com.budgetier.enums.user.UserGenderType.values()*.getDescriptive()}"
                              keys="${com.budgetier.enums.user.UserGenderType.values()*.name()}"
                              value="${person?.genderType?.name()}"
                              class="form-control"/>
                </blockquote>
                <blockquote>
                    <label class="text-muted"><g:message code="form.field.locale"/></label>
                    <g:select name="userLocale"
                              from="${com.budgetier.enums.management.LocaleType.values()*.getDescriptive()}"
                              keys="${com.budgetier.enums.management.LocaleType.values()*.name()}"
                              value="${person?.userLocale?.name()}"
                              class="form-control"/>
                </blockquote>
                <div class="row">
                    <div class="col-sm-12">
                        <button class="btn btn-primary pull-right">
                            <g:message code="button.label.update"/>
                        </button>
                    </div>
                </div>
            </g:form>
        </div>
    </div>

</body>
</html>
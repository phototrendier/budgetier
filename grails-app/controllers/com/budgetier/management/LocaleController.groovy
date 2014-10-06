package com.budgetier.management

import com.budgetier.enums.management.LocaleType
import com.budgetier.utilities.EnumUtilityMethods

class LocaleController {

    /**
     * Set the session locale to the selected locale.
     *
     * TODO if the user is logged in then save the selected locale in a cookie so that it doesn't get lost when the session expires.
     */
    def ajaxSetSessionLocale() {

        // check for the locale parameter in the request
        if (!params.locale) {
            log.error "Request to set the locale in the session failed because the lang parameter was not present."
            log.error "Received parameters were: " + params
            render (contentType: "application/json") {
                ['success': false, 'message': message(code: 'request.lacked.parameter')]
            }
            return
        }

        if (params.locale) {
            // check if the locale defined by the locale parameter is defined and supported
            LocaleType localeType = EnumUtilityMethods.getEnumFromString(params.locale, LocaleType)
            if (!localeType) {
                render (contentType: "application/json") {
                    ['success': false, 'message': message(code: 'request.locale.not.found', args: [params.locale])]
                }
                return
            }

            // set the selected locale to session
            session["locale"] = localeType

            render (contentType: 'application/json') {
                ['success': true, 'message': message(code: 'request.locale.changed', args: [message(code: localeType.getI18nDescriptive())])]
            }
        }
    }
}

package filters

import com.budgetier.enums.management.LocaleType

class LocaleFilters {

    def filters = {
        def filters = {
            all(controller:'*', action:'*') {
                before = {
                    // set the locale based on session selection
                    if (session["locale"]) {
                        LocaleType localeType = session["locale"]
                        params.lang = localeType.getLocalIsoValue()
                    } else {
                        // TODO check if user is logged in and retrieve locale configuration selection

                        // TODO set default filter by user location

                        params.lang = LocaleType.ENGLISH.getLocalIsoValue()
                    }
                }
                after = { Map model ->

                }
                afterView = { Exception e ->

                }
            }
        }
    }
}

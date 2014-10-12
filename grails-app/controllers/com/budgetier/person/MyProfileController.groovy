package com.budgetier.person

import com.budgetier.domain.user.Person

class MyProfileController {

    def profileManagement() {
        Person person = (Person) session["logged_in_user"]
        if (!person) {
            flash.error = message (code: "user.message.no.logged.in.user.found")
        }
        log.error message(code: person?.socialNetworkType?.i18nDescriptive)

        [person: person]
    }
}

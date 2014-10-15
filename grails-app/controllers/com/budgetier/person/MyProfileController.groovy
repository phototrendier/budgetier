package com.budgetier.person

import com.budgetier.domain.user.Person
import com.budgetier.enums.social.SocialNetworkType

class MyProfileController {

    def facebookService

    /**
     * Render person's profile management screen.
     */
    def profileManagement() {
        Person person = (Person) session["logged_in_user"]
        if (!person) {
            flash.error = message (code: "user.message.no.logged.in.user.found")
        }

        render (view: "profileManagement", model: [person: person])
    }

    /**
     * Update request on person's profile management form handler.
     */
    def updateProfile() {
        Person person = (Person) session["logged_in_user"]
        if (!person) {
            redirect(action: "profileManagement")
            return
        }

        // apply parameters retrieved from form submission
        bindData(person, params)

        // custom handling of receiveNotifications field
        // since an unchecked checkbox is not submit along
        // with other parameters so we assume that if it
        // is missing the user has deselected it
        if (!params.receiveNotifications)
            person.receiveNotifications = Boolean.FALSE

        // persist the person's instance and handle any errors
        if (!person.save()) {
            log.error "Unable to persist person instance."
            log.error "Person instance is " + person?.id
            person.errors.each {
                log.error it
            }
            flash.error = message(code: "user.message.profile.update.failed")
            redirect(action: "profileManagement")
            return
        }

        flash.success = message (code: "user.message.profile.update.successful")
        redirect(action: "profileManagement")
    }

    def ajaxRequestUserPermissions() {
        Person person = (Person) session["logged_in_user"]
        if (person?.socialNetworkType == SocialNetworkType.FACEBOOK) {

        }
    }
}

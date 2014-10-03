package com.budgetier.social

class SocialManagerController {

    def index() {}

    def facebookSuccessHandler() {
        flash.success = 'Successfully authenticated with facebook.'
        render (view: '/index')
    }

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
}

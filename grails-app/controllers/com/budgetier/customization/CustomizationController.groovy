package com.budgetier.customization

class CustomizationController {

    def customizationService

    def manageTransactionCategories() {
        log.error params
        def transactionCategories = customizationService.findTransactionCategories(params, false)
    }
}

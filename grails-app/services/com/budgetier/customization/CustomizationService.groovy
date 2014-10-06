package com.budgetier.customization

import com.budgetier.customization.exceptions.PersistEntityException
import com.budgetier.domain.customization.TransactionCategory
import grails.transaction.Transactional

@Transactional
class CustomizationService {

    def findTransactionCategories(params, boolean count) {
        def criteria = TransactionCategory.createCriteria()
        def results = criteria.list(max: 10, offset: 0) {

        }
    }

    def createTransactionCategory(TransactionCategory transactionCategory) {
        if (!transactionCategory.save()) {
            log.error "Failed to create transaction category."
            transactionCategory.errors.each {
                log.error it
            }
            throw new PersistEntityException(transactionCategory)
        }
    }
}

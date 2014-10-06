package com.budgetier.domain.customization

import com.budgetier.enums.transaction.MoneyFlowType

class TransactionCategory {

    String name
    String description

    MoneyFlowType moneyFlowType = MoneyFlowType.EXPENSE

    static hasMany = [children: TransactionCategory]
    static belongsTo = [parent: TransactionCategory]

    static constraints = {
        name nullable: false
        description nullable: true
        moneyFlowType nullable: false
        children nullable: true
        parent nullable: true
    }
}

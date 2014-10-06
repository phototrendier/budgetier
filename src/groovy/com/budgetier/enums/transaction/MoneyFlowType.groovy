package com.budgetier.enums.transaction

/**
 * Created by vbledar on 10/2/14.
 *
 * This enumeration defines the money flow in a transaction. Money flow
 * is defined in respect to user's wallet, that is, either is filling
 * the wallet (increase) in which case is an income, or thins the wallet
 * in which case is an expense.
 */
public enum MoneyFlowType {

    INCOME ("Income", "money.flow.type.income"),            // income money flow
    EXPENSE ("Expense", "money.flow.type.expense")          // expense money flow

    private String descriptive                              // default human readable representation
    private String i18nDescriptive                          // i18n representation

    /**
     * Enumeration instance constructor. This constructor
     * will initialize the enumeration instance descriptive
     * value.
     *
     * @param descriptive, the value to set.
     */
    public MoneyFlowType(String descriptive, String i18nDescriptive) {
        this.descriptive = descriptive
        this.i18nDescriptive = i18nDescriptive
    }

    /**
     * Retrieve the descriptive information of this enumeration
     * instance.
     *
     * @return <code>String</code> the descriptive value of the
     * enumeration instance.
     */
    public String getDescriptive() {
        return this.descriptive
    }

    /**
     * Retrieve the i18n descriptive information of this enumeration
     * instance.
     *
     * @return <code>String</code> the i18n descriptive value of the
     * enumeration instance.
     */
    public String getI18nDescriptive() {
        return this.i18nDescriptive
    }
}
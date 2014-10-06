package com.budgetier.customization.exceptions

/**
 * Created by vbledar on 10/6/14.
 */
class PersistEntityException extends Exception {

    def entity

    public PersistEntityException(def entity) {
        this.entity = entity
    }

    def getEntity() {
        return this.entity
    }
}

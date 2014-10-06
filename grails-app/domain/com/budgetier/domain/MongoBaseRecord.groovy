package com.budgetier.domain

import org.bson.types.ObjectId

abstract class MongoBaseRecord {

    ObjectId id

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}

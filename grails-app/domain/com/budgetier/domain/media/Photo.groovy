package com.budgetier.domain.media

class Photo {

    String photoUrl

    static constraints = {
        photoUrl nullable: false, url: true
    }
}

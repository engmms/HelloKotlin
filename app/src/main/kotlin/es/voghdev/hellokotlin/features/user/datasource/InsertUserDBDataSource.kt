package es.voghdev.hellokotlin.features.user.datasource

import es.voghdev.hellokotlin.features.user.User
import es.voghdev.hellokotlin.features.user.UserDBEntry
import es.voghdev.hellokotlin.features.user.usecase.InsertUser

class InsertUserDBDataSource : InsertUser {
    override fun insertUser(user: User) {
        UserDBEntry(user).save()
    }
}
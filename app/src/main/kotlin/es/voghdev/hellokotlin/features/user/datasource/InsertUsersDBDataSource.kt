package es.voghdev.hellokotlin.features.user.datasource

import com.raizlabs.android.dbflow.config.FlowManager
import es.voghdev.hellokotlin.features.user.User
import es.voghdev.hellokotlin.features.user.UserDBEntry
import es.voghdev.hellokotlin.features.user.usecase.InsertUsers
import es.voghdev.hellokotlin.global.AppDatabase

class InsertUsersDBDataSource : InsertUsers {
    override fun insertUsers(users: List<User>) {
        FlowManager.getDatabase(AppDatabase.javaClass)
                .beginTransactionAsync {
                    users.forEach { user ->
                        UserDBEntry(user).save()
                    }
                }.build().execute()
    }
}
package es.voghdev.hellokotlin.features.user.datasource

import com.raizlabs.android.dbflow.sql.language.SQLite
import es.voghdev.hellokotlin.features.user.User
import es.voghdev.hellokotlin.features.user.UserDBEntry
import es.voghdev.hellokotlin.features.user.UserDBEntry_Table

class GetUsersByAgeDBDataSource {
    fun getUsersByName(name: String): List<User> {
        return SQLite.select()
                .from(UserDBEntry::class.java)
                .where(UserDBEntry_Table.name.`is`(name))
                .queryList()
                .map { it.toDomain() }
    }
}

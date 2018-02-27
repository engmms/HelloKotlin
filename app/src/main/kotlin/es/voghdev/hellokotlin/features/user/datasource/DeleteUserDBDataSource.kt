package es.voghdev.hellokotlin.features.user.datasource

import android.util.Log
import com.raizlabs.android.dbflow.sql.language.SQLite
import es.voghdev.hellokotlin.features.user.UserDBEntry
import es.voghdev.hellokotlin.features.user.UserDBEntry_Table
import es.voghdev.hellokotlin.features.user.usecase.DeleteUser

class DeleteUserDBDataSource : DeleteUser {
    override fun deleteUser(email: String) {
        SQLite.delete(UserDBEntry::class.java)
                .where(UserDBEntry_Table.email.`is`(email))
                .async()
                .success { transaction ->
                    Log.d("Ok", "SUCCESS")
                }
                .error { transaction, error ->
                    Log.d("No", "Error")
                }
                .execute()
    }
}

/*
 * Copyright (C) 2018 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.hellokotlin.features.user

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import es.voghdev.hellokotlin.global.AppDatabase

@Table(database = AppDatabase::class)
class UserDBEntry : BaseModel {
    @Column @PrimaryKey
    val id: Long? = 0L
    @Column
    var name: String? = ""
    @Column
    var address: String? = ""
    @Column
    var username: String? = ""
    @Column
    var email: String? = ""
    @Column
    var thumbnail: String? = ""

    constructor() {
        // Mandatory for DBFlow
    }

    constructor(user: User) {
        user.let {
            this.name = name
            this.address = address
            this.username = username
            this.email = email
            this.thumbnail = thumbnail
        }
    }

    fun toDomain(): User {
        return User(
                name ?: "",
                address ?: "",
                username ?: "",
                email ?: "",
                thumbnail ?: ""
        )
    }
}

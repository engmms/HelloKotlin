/*
 * Copyright (C) 2017 Olmo Gallegos Hernández.
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
package es.voghdev.hellokotlin

import java.util.*

class UserRepository(val getUsersApiDataSource: GetUsers?, val getUsersDbDataSource: GetUsers?, val insertUserApi: InsertUser?) : GetUsers, InsertUser {
    var cachePolicy : CachePolicy? = null
    var cache : MutableList<User> = ArrayList<User>()

    override fun getUsers(): List<User> {
        if(cachePolicy?.isCacheDirty() ?: false)
            cache.clear()

        cache = getUsersApiDataSource?.getUsers() as MutableList<User>
        Thread.sleep(3000) // Test if coroutines are blocking or not
        cachePolicy = TimedCachePolicy(15000)

        return cache
    }

    override fun insertUser() {
        insertUserApi?.insertUser()
    }
}

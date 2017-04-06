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

import android.content.Context
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class UserDetailPresenter(val context: Context, val userRepository: UserRepository) : Presenter<UserDetailPresenter.MVPView, UserDetailPresenter.Navigator>() {

    interface MVPView {
        fun showUserCount(size: Int)
        fun hideLoading()

    }

    interface Navigator {

    }

    override fun initialize() = launch(CommonPool) {
        val users = userRepository.getUsers()
        val user = users.filter { it.name.contains("John") }

//        launch(UI) {
            view?.hideLoading()
            view?.showUserCount(users.size)
//        }
    }

}

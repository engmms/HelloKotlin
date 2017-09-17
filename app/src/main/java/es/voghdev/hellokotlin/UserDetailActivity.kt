package es.voghdev.hellokotlin

import android.os.Bundle
import android.view.View.INVISIBLE
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : BaseActivity(), UserDetailPresenter.MVPView, UserDetailPresenter.Navigator {
    var presenter: UserDetailPresenter? = null
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userRepository = UserRepository(
                getUsersApiDataSource = GetUsersApiDataSource(),
                getUsersDbDataSource = GetUsersDBDataSource(),
                insertUserApi = InsertUserApiDataSource())

        presenter = UserDetailPresenter(this, userRepository)
        presenter?.initialize()
        presenter?.view = this
        presenter?.navigator = this

    }

    override fun showUserCount(size: Int) {
        tv_count?.text = "${size} users found"
    }

    override fun hideLoading() {
        progressBar.visibility = INVISIBLE
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_user_detail
    }
}

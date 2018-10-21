package be.rafwillems.beerpoc.ui.login

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface LoginContract {
    interface View : MvpView {
        fun onClickLogin(user: String)
        fun showError()
        fun showLoading()
        fun hideLoading()
        fun showLoginSuccess()
    }

    interface Presenter : MvpPresenter<View> {
        fun login(username: String)
    }
}

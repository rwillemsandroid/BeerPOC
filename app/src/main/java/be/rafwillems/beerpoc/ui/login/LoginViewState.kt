package be.rafwillems.beerpoc.ui.login

import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState

class LoginViewState : ViewState<LoginContract.View> {

    companion object {
        private const val STATE_DO_NOTHING = 0
        private const val STATE_SHOW_LOADING = 1
        private const val STATE_SHOW_ERROR = 2
    }

    private var state = STATE_DO_NOTHING

    fun setShowLoading() {
        state = STATE_SHOW_LOADING
    }

    fun setShowError() {
        state = STATE_SHOW_ERROR
    }

    override fun apply(view: LoginContract.View?, retained: Boolean) {
        when (state) {
            STATE_SHOW_LOADING -> view?.showLoading()
            STATE_SHOW_ERROR   -> view?.showError()
        }
    }
}

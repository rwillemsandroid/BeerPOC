package be.rafwillems.beerpoc.ui.login

import be.rafwillems.beerpoc.data.model.LoginResult
import be.rafwillems.beerpoc.di.PerScreen
import be.rafwillems.beerpoc.domain.LoginUseCase
import be.rafwillems.beerpoc.mvp.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@PerScreen
class LoginPresenter @Inject constructor(private val loginUseCase: LoginUseCase) : BasePresenter<LoginContract.View>(), LoginContract.Presenter {
    override fun login(username: String)  {
        disposables.add(loginUseCase.login(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { ifViewAttached { view -> view.showLoading() } }
                .doFinally { ifViewAttached { view -> view.hideLoading() } }
                .onErrorReturn { LoginResult(false) }
                .subscribe(this::onLoginResult) )}

    private fun onLoginResult(result: LoginResult) {
        Timber.d("onLoginResult ${result.success}")
        if(result.success){
            view.showLoginSuccess()
        } else {
            view.showError()
        }
    }

}

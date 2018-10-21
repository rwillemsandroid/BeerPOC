package be.rafwillems.beerpoc.ui.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import be.rafwillems.beerpoc.BeerPOCApplication
import be.rafwillems.beerpoc.R
import be.rafwillems.beerpoc.mvp.BaseViewController
import be.rafwillems.beerpoc.ui.brewerylist.BreweryListController
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.bluelinelabs.conductor.RouterTransaction
import timber.log.Timber


class LoginController : BaseViewController<LoginContract.View, LoginContract.Presenter, LoginViewState>(), LoginContract.View {

    lateinit var welcomeText: TextView

    lateinit var userRaf: ImageButton
    lateinit var userBatman: ImageButton
    lateinit var userFreddy: ImageButton


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_login, container, false)
        view.findViewById<TextView>(R.id.tv_title).text = "Who's thirsty?"
        view.findViewById<Button>(R.id.home_button).setOnClickListener { onClickLogin() }
        return view
    }

    override fun createPresenter() = DaggerLoginComponent.builder()
            .appComponent(BeerPOCApplication.component)
            .loginModule(LoginModule())
            .build()
            .presenter()

    override fun createViewState(): LoginViewState = LoginViewState()

    override fun showLoginSuccess() {
        router.pushController(
                RouterTransaction.with(BreweryListController())
                        .pushChangeHandler(FadeChangeHandler())
                        .popChangeHandler(FadeChangeHandler())
        )
    }

    override fun onClickLogin() {
        presenter.login("raf")
    }

    override fun showError() {
        Timber.d("showError")
    }

    override fun showLoading() {
        Timber.d("showLoading")
    }

    override fun hideLoading() {
        Timber.d("hideLoading")
    }

}

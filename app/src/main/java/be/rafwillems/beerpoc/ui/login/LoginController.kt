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
import kotlinx.android.synthetic.main.controller_login.view.*
import timber.log.Timber


class LoginController : BaseViewController<LoginContract.View, LoginContract.Presenter, LoginViewState>(), LoginContract.View {

    lateinit var userRaf: ImageButton
    lateinit var userBatman: ImageButton
    lateinit var userFreddy: ImageButton
    lateinit var errorTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_login, container, false)
        view.findViewById<TextView>(R.id.tv_title).text = applicationContext?.getString(R.string.login_welcome_text)

        initUsers(view)
        errorTextView = view.findViewById(R.id.login_error)

        return view
    }

    /**
     * TODO: Users verhuien naar shared prefs, dynamische tegels zetten in RV of mb viewgroep vanuit code
     */
    private fun initUsers(v :View){
        userRaf = v.findViewById(R.id.login_button_raf)
        userBatman = v.findViewById(R.id.login_button_batman)
        userFreddy = v.findViewById(R.id.login_button_freddy)

        userRaf.setOnClickListener { onClickLogin("raf") }
        userBatman.setOnClickListener { onClickLogin("batman") }
        userFreddy.setOnClickListener { onClickLogin("freddy") }
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

    override fun onClickLogin(user: String) {
        presenter.login(user)
    }

    override fun showError() {
        errorTextView.visibility = View.VISIBLE
    }

    override fun showLoading() {
        userRaf.isEnabled = false
        userBatman.isEnabled = false
        userFreddy.isEnabled=false

        errorTextView.visibility = View.GONE
    }

    override fun hideLoading() {
        userRaf.isEnabled = true
        userBatman.isEnabled = true
        userFreddy.isEnabled=true
    }

}

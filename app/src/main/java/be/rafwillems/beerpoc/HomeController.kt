package be.rafwillems.beerpoc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.bluelinelabs.conductor.RouterTransaction




class HomeController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_home, container, false)

        view.findViewById<TextView>(R.id.tv_title).text = "Hello World"
        view.findViewById<Button>(R.id.home_button).setOnClickListener { onClickLoginButton() }
        return view
    }

    private fun onClickLoginButton() {
        router.pushController(
                RouterTransaction.with(BreweryListController())
                        .pushChangeHandler(FadeChangeHandler())
                        .popChangeHandler(FadeChangeHandler())
        )
    }

}

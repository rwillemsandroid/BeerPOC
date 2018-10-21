package be.rafwillems.beerpoc.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.Conductor
import android.view.ViewGroup
import be.rafwillems.beerpoc.R
import be.rafwillems.beerpoc.ui.login.LoginController


class MainActivity : AppCompatActivity() {
    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val container = findViewById<ViewGroup>(R.id.controller_container)

        router = Conductor.attachRouter(this, container, savedInstanceState)
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(LoginController()))
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

}

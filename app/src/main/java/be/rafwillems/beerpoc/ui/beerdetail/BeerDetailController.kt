package be.rafwillems.beerpoc.ui.beerdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import be.rafwillems.beerpoc.R
import com.bluelinelabs.conductor.Controller

class BeerDetailController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_beerdetail, container, false)
        return view
    }
}

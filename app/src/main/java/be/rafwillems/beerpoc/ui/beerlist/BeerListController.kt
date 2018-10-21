package be.rafwillems.beerpoc.ui.beerlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import be.rafwillems.beerpoc.ui.beerdetail.BeerDetailController
import be.rafwillems.beerpoc.R
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction

class BeerListController : Controller() {

    private lateinit var beerDetailContainer: ViewGroup

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_beerlist, container, false)
        beerDetailContainer = view.findViewById(R.id.beerdetail_container)
        setupDetailController()
        return view
    }

    private fun setupDetailController() {
        getChildRouter(beerDetailContainer).setRoot(RouterTransaction.with(BeerDetailController()))
    }

}

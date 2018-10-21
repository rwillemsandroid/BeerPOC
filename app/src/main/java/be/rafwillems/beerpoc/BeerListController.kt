package be.rafwillems.beerpoc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

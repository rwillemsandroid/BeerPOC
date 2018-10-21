package be.rafwillems.beerpoc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction

class BreweryListController : Controller() {

    private lateinit var beerListContainer: ViewGroup

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_brewerylist, container, false)
        beerListContainer= view.findViewById(R.id.beerlist_container)
        setupBeerListController()
        return view
    }

    private fun setupBeerListController(){
        getChildRouter(beerListContainer).setRoot(RouterTransaction.with(BeerListController()))
    }

}

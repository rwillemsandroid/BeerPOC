package be.rafwillems.beerpoc.ui.brewerylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import be.rafwillems.beerpoc.BeerPOCApplication
import be.rafwillems.beerpoc.R
import be.rafwillems.beerpoc.data.model.Brewery
import be.rafwillems.beerpoc.mvp.BaseViewController
import be.rafwillems.beerpoc.ui.beerlist.BeerListController
import com.bluelinelabs.conductor.RouterTransaction
import timber.log.Timber

class BreweryListController : BaseViewController<BreweryContract.View, BreweryContract.Presenter, BreweryViewState>(), BreweryContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_brewerylist, container, false)
        beerListContainer = view.findViewById(R.id.beerlist_container)
        setupBeerListController()
        return view
    }

    override fun onViewStateInstanceRestored(instanceStateRetained: Boolean) {
        super.onViewStateInstanceRestored(instanceStateRetained)
    }

    override fun createPresenter(): BreweryContract.Presenter = DaggerBreweryComponent
            .builder()
            .appComponent(BeerPOCApplication.component)
            .breweryModule(BreweryModule())
            .build()
            .presenter()

    override fun onNewViewStateInstance() {
        presenter.loadBreweryList()
    }

    override fun createViewState(): BreweryViewState = BreweryViewState()

    private lateinit var beerListContainer: ViewGroup

    private fun setupBeerListController() {
        getChildRouter(beerListContainer).setRoot(RouterTransaction.with(BeerListController()))
    }

    override fun hideLoading() {
        Timber.w("TODO Hide loading")
    }

    override fun showLoading() {
        Timber.w("TODO Show loading")
    }

    override fun showBreweries(breweryList: List<Brewery>) {
        //TODO: Create RV and adapter to display breweryList
        Timber.d("Loaded beweries $breweryList")
    }

    override fun loadBrewery(breweryId: String) {
        Timber.w("TODO loadbrewery")
    }


}

package be.rafwillems.beerpoc.ui.brewerylist

import be.rafwillems.beerpoc.data.model.Brewery
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface BreweryContract {
    interface View : MvpView {
        fun loadBrewery(breweryId: String)
        fun showBreweries(breweryList: List<Brewery>)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter : MvpPresenter<View> {
        fun loadBreweryList()
        fun selectBrewery(breweryId: String)
    }
}

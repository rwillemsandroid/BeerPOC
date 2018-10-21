package be.rafwillems.beerpoc.ui.brewerylist

import be.rafwillems.beerpoc.data.model.Brewery
import be.rafwillems.beerpoc.data.model.LoginResult
import be.rafwillems.beerpoc.di.PerScreen
import be.rafwillems.beerpoc.domain.BreweriesUseCase
import be.rafwillems.beerpoc.domain.LoginUseCase
import be.rafwillems.beerpoc.mvp.BasePresenter
import be.rafwillems.beerpoc.ui.login.LoginContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@PerScreen
class BreweryPresenter @Inject constructor(private val breweriesUseCase: BreweriesUseCase) : BasePresenter<BreweryContract.View>(), BreweryContract.Presenter {
    override fun loadBreweryList()  {
        disposables.add(breweriesUseCase.breweries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { ifViewAttached { view -> view.showLoading() } }
                .doFinally { ifViewAttached { view -> view.hideLoading() } }
                .onErrorReturn { emptyList() }
                .subscribe(this::onBreweriesResult) )}

    fun onBreweriesResult(breweryList: List<Brewery>){
        view.showBreweries(breweryList)
    }

    override fun selectBrewery(breweryId: String) {
        view.loadBrewery(breweryId)
    }
}

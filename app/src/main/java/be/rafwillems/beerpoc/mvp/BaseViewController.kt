package be.rafwillems.beerpoc.mvp

import com.hannesdorfmann.mosby3.conductor.viewstate.MvpViewStateController
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState

abstract class BaseViewController<V : MvpView, P : MvpPresenter<V>, VS : ViewState<V>> : MvpViewStateController<V, P, VS>(){
    override fun onViewStateInstanceRestored(instanceStateRetained: Boolean) {
        //no-op
    }

    override fun onNewViewStateInstance() {
        //no-op
    }
}

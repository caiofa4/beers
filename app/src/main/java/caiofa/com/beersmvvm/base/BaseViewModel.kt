package caiofa.com.beersmvvm.base

import androidx.lifecycle.ViewModel
import caiofa.com.beersmvvm.BeerListViewModel
import caiofa.com.beersmvvm.BeerViewModel
import caiofa.com.beersmvvm.injection.component.ViewModelInjector
import caiofa.com.beersmvvm.injection.module.NetworkModule
import caiofa.com.beersmvvm.injection.component.DaggerViewModelInjector


abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is BeerListViewModel -> injector.inject(this)
            is BeerViewModel -> injector.inject(this)
        }
    }
}
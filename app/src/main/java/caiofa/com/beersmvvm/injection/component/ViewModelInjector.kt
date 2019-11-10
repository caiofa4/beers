package caiofa.com.beersmvvm.injection.component

import caiofa.com.beersmvvm.BeerListViewModel
import caiofa.com.beersmvvm.BeerViewModel
import caiofa.com.beersmvvm.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified BeerListViewModel.
     * @param beerListViewModel BeerListViewModel in which to inject the dependencies
     */
    fun inject(beerListViewModel: BeerListViewModel)
    /**
     * Injects required dependencies into the specified BeerViewModel.
     * @param beerViewModel BeerViewModel in which to inject the dependencies
     */
    fun inject(beerViewModel: BeerViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
package caiofa.com.beersmvvm.network

import caiofa.com.beersmvvm.model.Beer
import io.reactivex.Observable
import retrofit2.http.GET

interface BeerAPI {
    /**
     * Get the list of the pots from the API
     */
    @GET("beers")
    fun getBeers(): Observable<List<Beer>>

    @GET("/beers")
    fun getSingleBeer(): Observable<List<Beer>>

    @GET("/beers/random")
    fun getRandomBeer(): Observable<List<Beer>>
}
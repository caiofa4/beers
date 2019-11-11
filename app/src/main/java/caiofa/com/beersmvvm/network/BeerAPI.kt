package caiofa.com.beersmvvm.network

import caiofa.com.beersmvvm.model.Beer
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerAPI {
    /**
     * Get the list of the pots from the API
     */
    @GET("beers")
    fun getBeers(): Observable<List<Beer>>

    @GET("beers")
    fun getAllBeers(@Query("page") page: Int): Observable<List<Beer>>

    fun getSingleBeer(): Observable<List<Beer>>

    @GET("/beers/random")
    fun getRandomBeer(): Observable<List<Beer>>
}
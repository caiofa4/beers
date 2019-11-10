package caiofa.com.beersmvvm

import androidx.lifecycle.MutableLiveData
import caiofa.com.beersmvvm.base.BaseViewModel
import caiofa.com.beersmvvm.model.Beer

class BeerViewModel : BaseViewModel() {
    private val beerName = MutableLiveData<String>()
    private val beerDescription = MutableLiveData<String>()

    fun bind(beer: Beer){
        beerName.value = beer.name
        beerDescription.value = beer.description
    }

    fun getBeerName():MutableLiveData<String>{
        return beerName
    }

    fun getBeerDescription():MutableLiveData<String>{
        return beerDescription
    }
}
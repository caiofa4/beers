package caiofa.com.beersmvvm

import android.view.View
import androidx.lifecycle.MutableLiveData

import caiofa.com.beersmvvm.base.BaseViewModel
import caiofa.com.beersmvvm.model.Beer
import caiofa.com.beersmvvm.model.BeerDao
import caiofa.com.beersmvvm.network.BeerAPI
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BeerListViewModel(private val beerDao: BeerDao): BaseViewModel() {

    @Inject
    lateinit var beerApi: BeerAPI
    val beerListAdapter: BeerListAdapter = BeerListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadBeers() }

    private lateinit var subscription: Disposable

    init{
        loadBeers()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadBeers(){
        subscription = Observable.fromCallable { beerDao.all }
            .concatMap {
                    dbBeerList ->
                if(dbBeerList.isEmpty())
                    beerApi.getBeers().concatMap {
                            apiBeerList -> beerDao.insertAll(*apiBeerList.toTypedArray())
                        Observable.just(apiBeerList)
                    }
                else
                    Observable.just(dbBeerList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveBeerListStart() }
            .doOnTerminate { onRetrieveBeerListFinish() }
            .subscribe(
                { result -> onRetrieveBeerListSuccess(result) },
                { onRetrieveBeerListError() }
            )
    }

    private fun onRetrieveBeerListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveBeerListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveBeerListSuccess(beerList:List<Beer>){
        beerListAdapter.updateBeerList(beerList)
    }

    private fun onRetrieveBeerListError(){
        errorMessage.value = R.string.post_error
    }



}
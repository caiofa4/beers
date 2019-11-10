package caiofa.com.beersmvvm.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import caiofa.com.beersmvvm.BeerListViewModel
import caiofa.com.beersmvvm.model.database.AppDatabase

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BeerListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "Beer").build()
            @Suppress("UNCHECKED_CAST")
            return BeerListViewModel(db.beerDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}
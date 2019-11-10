package caiofa.com.beersmvvm.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BeerDao {
    @get:Query("SELECT * FROM Beer")
    val all: List<Beer>

    @Insert
    fun insertAll(vararg users: Beer)
}
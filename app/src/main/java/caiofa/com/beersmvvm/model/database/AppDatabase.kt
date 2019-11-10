package caiofa.com.beersmvvm.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import caiofa.com.beersmvvm.model.Beer
import caiofa.com.beersmvvm.model.BeerDao

@Database(entities = [Beer::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun beerDao(): BeerDao
}
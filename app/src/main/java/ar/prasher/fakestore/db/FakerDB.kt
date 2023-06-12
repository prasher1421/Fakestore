package ar.prasher.fakestore.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.prasher.fakestore.models.Product


@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDAO() : FakerDAO

}
//generally we implement a companion object
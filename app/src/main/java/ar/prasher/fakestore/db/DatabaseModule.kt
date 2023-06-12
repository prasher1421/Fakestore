package ar.prasher.fakestore.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesFakerDB(context : Context) : FakerDB{
        return Room.databaseBuilder(
            context,
            FakerDB::class.java,
            "FakerDB"
        ).build()
    }

}
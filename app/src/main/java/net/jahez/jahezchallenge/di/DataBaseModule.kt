package net.jahez.jahezchallenge.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.jahez.jahezchallenge.data.source.local.RestaurantDao
import net.jahez.jahezchallenge.data.source.local.RestaurantDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : RestaurantDatabase =
        Room.databaseBuilder(context, RestaurantDatabase::class.java, "restaurant_database")
            .build()

    @Provides
    @Singleton
    fun provideRestaurantDao(database: RestaurantDatabase) : RestaurantDao =
        database.restaurantDao()

}
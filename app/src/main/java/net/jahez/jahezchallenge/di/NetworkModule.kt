package net.jahez.jahezchallenge.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.jahez.jahezchallenge.data.source.remote.EndPoints
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {



    @Singleton
    @Provides
    fun provideEndPoints(): EndPoints {
        return Retrofit.Builder()
            .baseUrl("https://jahez-other-oniiphi8.s3.eu-central-1.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(EndPoints::class.java)
    }

}
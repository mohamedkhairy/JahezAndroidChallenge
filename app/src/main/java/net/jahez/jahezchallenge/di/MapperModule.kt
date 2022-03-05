package net.jahez.jahezchallenge.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.jahez.jahezchallenge.data.source.mapper.RestaurantToDomainMapper
import net.jahez.jahezchallenge.data.source.mapper.RestaurantToEntityMapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideEntityMapper(): RestaurantToEntityMapper {
        return RestaurantToEntityMapper()
    }

    @Singleton
    @Provides
    fun provideDomainMapper (): RestaurantToDomainMapper {
        return RestaurantToDomainMapper()
    }
}
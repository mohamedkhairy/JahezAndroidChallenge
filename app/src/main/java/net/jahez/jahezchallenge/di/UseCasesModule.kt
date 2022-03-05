package net.jahez.jahezchallenge.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import net.jahez.jahezchallenge.data.repository.RestaurantRepositoryImp
import net.jahez.jahezchallenge.data.source.local.RestaurantDao
import net.jahez.jahezchallenge.data.source.mapper.RestaurantToDomainMapper
import net.jahez.jahezchallenge.data.source.mapper.RestaurantToEntityMapper
import net.jahez.jahezchallenge.data.source.remote.EndPoints
import net.jahez.jahezchallenge.domain.repository.RestaurantRepository
import net.jahez.jahezchallenge.domain.useCases.RestaurantUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {



        @ViewModelScoped
        @Provides
        fun provideRestaurantUseCase(restaurantRepository :RestaurantRepository) : RestaurantUseCase {
            return RestaurantUseCase(restaurantRepository)
        }

}
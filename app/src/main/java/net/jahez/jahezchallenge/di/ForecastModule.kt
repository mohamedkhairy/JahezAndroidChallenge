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


@Module
@InstallIn(ViewModelComponent::class)
object ForecastModule {

    @ViewModelScoped
    @Provides
    fun provideRestaurantRepository(endPoints: EndPoints,
                                  restaurantDao: RestaurantDao,
                                  domainMapper: RestaurantToDomainMapper,
                                  entityMapper: RestaurantToEntityMapper) : RestaurantRepository {
        return RestaurantRepositoryImp(endPoints, restaurantDao, domainMapper, entityMapper)
    }

}
package net.jahez.jahezchallenge.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import net.jahez.jahezchallenge.data.source.local.RestaurantDao
import net.jahez.jahezchallenge.data.source.mapper.RestaurantToDomainMapper
import net.jahez.jahezchallenge.data.source.mapper.RestaurantToEntityMapper
import net.jahez.jahezchallenge.data.source.remote.EndPoints
import net.jahez.jahezchallenge.data.utils.networkBoundResource
import net.jahez.jahezchallenge.domain.core.Resource
import net.jahez.jahezchallenge.domain.entity.Restaurant
import net.jahez.jahezchallenge.domain.repository.RestaurantRepository
import javax.inject.Inject

class RestaurantRepositoryImp @Inject constructor(val endPoints: EndPoints,
                                                val restaurantDao: RestaurantDao,
                                                val domainMapper: RestaurantToDomainMapper,
                                                val entityMapper: RestaurantToEntityMapper) : RestaurantRepository {

    override suspend fun getRestaurant(): Flow<Resource<List<Restaurant>?>> =  networkBoundResource(
        query = {
            restaurantDao.getAll().map {savedData ->

                domainMapper.toDomainList(savedData)
            }
        },
        fetch = {
            val response = endPoints.callRestaurants()
             entityMapper.toEntityList(response)
        },
        saveFetchResult = { data ->
            restaurantDao.deleteAll()
            restaurantDao.save(data)
            domainMapper.toDomainList(data)
        }
    ).onStart {
        emit(Resource.Loading(null))
    }
        .flowOn(Dispatchers.IO)


}
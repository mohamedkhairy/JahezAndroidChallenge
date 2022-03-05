package net.jahez.jahezchallenge.domain.repository

import kotlinx.coroutines.flow.Flow
import net.jahez.jahezchallenge.domain.core.Resource
import net.jahez.jahezchallenge.domain.entity.Restaurant

interface RestaurantRepository {

    suspend fun getRestaurant(): Flow<Resource<List<Restaurant>?>>

}
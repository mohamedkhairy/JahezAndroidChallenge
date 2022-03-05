package net.jahez.jahezchallenge.domain.useCases


import kotlinx.coroutines.flow.Flow
import net.jahez.jahezchallenge.domain.core.Resource
import net.jahez.jahezchallenge.domain.entity.Restaurant
import net.jahez.jahezchallenge.domain.repository.RestaurantRepository
import javax.inject.Inject

class RestaurantUseCase @Inject constructor(
    private val restaurantRepository: RestaurantRepository
) {

    suspend operator fun invoke(): Flow<Resource<List<Restaurant>?>> =
        restaurantRepository.getRestaurant()
}


package net.jahez.jahezchallenge.data.source.mapper

import net.jahez.jahezchallenge.data.source.local.RestaurantEntity
import net.jahez.jahezchallenge.data.source.remote.RestaurantsResponse
import net.jahez.jahezchallenge.data.utils.ModelMapper
import net.jahez.jahezchallenge.domain.entity.Restaurant

class RestaurantToEntityMapper: ModelMapper<RestaurantsResponse, RestaurantEntity>{

    override fun mapToRestaurantModel(model: RestaurantsResponse): RestaurantEntity {
        return RestaurantEntity(
            model.distance,
            model.hours,
            model.id,
            model.image,
            model.name,
            model.rating
        )

    }




    fun toEntityList(initial: List<RestaurantsResponse>): List<RestaurantEntity>{
        return initial.map { mapToRestaurantModel(it) }
    }



}
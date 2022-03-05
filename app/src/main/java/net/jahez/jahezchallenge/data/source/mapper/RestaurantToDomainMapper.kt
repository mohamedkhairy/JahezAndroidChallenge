package net.jahez.jahezchallenge.data.source.mapper

import net.jahez.jahezchallenge.data.source.local.RestaurantEntity
import net.jahez.jahezchallenge.data.source.remote.RestaurantsResponse
import net.jahez.jahezchallenge.data.utils.ModelMapper
import net.jahez.jahezchallenge.domain.entity.Restaurant

class RestaurantToDomainMapper : ModelMapper<RestaurantEntity, Restaurant> {

    override fun mapToRestaurantModel(model: RestaurantEntity): Restaurant{
        return Restaurant(
            model.distance,
            model.hours,
            model.id,
            model.image,
            model.name,
            model.rating
        )

    }




    fun toDomainList(initial: List<RestaurantEntity>?): List<Restaurant>?{
        return initial?.map { mapToRestaurantModel(it) }
    }



}
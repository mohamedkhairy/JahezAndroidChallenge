package net.jahez.jahezchallenge.data.source.remote

import retrofit2.http.GET

interface EndPoints {

    @GET("restaurants.json")
    suspend fun callRestaurants(): List<RestaurantsResponse>

}
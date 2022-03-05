package net.jahez.jahezchallenge.data.source.remote

import com.google.gson.annotations.SerializedName


data class RestaurantsResponse(
    @SerializedName("description")
    val description: String,
    @SerializedName("distance")
    val distance: Double,
    @SerializedName("hasOffer")
    val hasOffer: Boolean,
    @SerializedName("hours")
    val hours: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("offer")
    val offer: String?,
    @SerializedName("rating")
    val rating: Int
)
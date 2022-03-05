package net.jahez.jahezchallenge.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_table")
data class RestaurantEntity (
    val distance: Double,
    val hours: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val name: String,
    val rating: Int
    )
package net.jahez.jahezchallenge.domain.entity

data class Restaurant (
    val distance: Double,
    val hours: String,
    val id: Int,
    val image: String?,
    val name: String,
    val rating: Int
    )
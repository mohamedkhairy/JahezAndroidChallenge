package net.jahez.jahezchallenge.data.utils

interface ModelMapper <T, DomainModel>{

    fun mapToRestaurantModel(model: T): DomainModel

}
package net.jahez.jahezchallenge.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurant_table")
     fun getAll(): Flow<List<RestaurantEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(forecast: List<RestaurantEntity>)

//    @Query("UPDATE character SET base64 = :image WHERE id = :id")
//    fun updateImage(id: Int, image: String)

    @Query("DELETE FROM restaurant_table")
    fun deleteAll()



    ////////// Query for last five days //////////////


//    @Query("SELECT * FROM forecastlastfivedays")
//    fun getLastFiveDaysData(): Flow<List<ForecastLastFiveDaysEntity>?>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun saveLastFiveDaysData(forecast: List<ForecastLastFiveDaysEntity>)

//    @Query("UPDATE character SET base64 = :image WHERE id = :id")
//    fun updateImage(id: Int, image: String)

//    @Query("DELETE FROM forecastlastfivedays")
//    fun deleteLastFiveDaysData()
}
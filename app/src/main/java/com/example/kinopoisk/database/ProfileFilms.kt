package com.example.kinopoisk.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson

@Entity(tableName = "films")
data class ProfileFilm(
    @PrimaryKey(autoGenerate = true)val id: Int = 0,
    val movieDetailed: String,
    val category: String
)

@Dao
interface ProfileFilmDao{
    @Query("SELECT * FROM films WHERE category = :category")
    suspend fun getFilmsByCategory(category: String): List<ProfileFilm>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: ProfileFilm)

    @Delete
    suspend fun deleteFilm(film: ProfileFilm)
}

class Converters {
    @TypeConverter
    fun fromMovieDetailed(movieDetailed: MovieDetailed): String {
        return Gson().toJson(movieDetailed)
    }

    @TypeConverter
    fun toMovieDetailed(json: String): MovieDetailed {
        return Gson().fromJson(json, MovieDetailed::class.java)
    }
}

@Database(entities = [ProfileFilm::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): ProfileFilmDao
}


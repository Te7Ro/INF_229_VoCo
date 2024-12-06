package com.example.kinopoisk.database

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
import com.example.kinopoisk.data.MovieDetailed
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "films")
data class ProfileFilm(
    @PrimaryKey(autoGenerate = true)val id: Int = 0,
    val movieId: Int,
    val category: String
)

@Dao
interface ProfileFilmDao{
    @Query("SELECT * FROM films")
    fun getFilms(): Flow<List<ProfileFilm>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(profileFilm: ProfileFilm)
}

@Database(entities = [ProfileFilm::class], version = 1)
abstract class ProfileDatabase : RoomDatabase() {
    abstract fun filmDao(): ProfileFilmDao
}


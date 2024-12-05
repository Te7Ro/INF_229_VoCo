package com.example.kinopoisk.di

import android.content.Context
import androidx.room.Room
import com.example.kinopoisk.database.ProfileDatabase
import com.example.kinopoisk.database.ProfileFilmDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) : ProfileDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = ProfileDatabase::class.java,
            name = "movie.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideProfileDao(database: ProfileDatabase): ProfileFilmDao = database.filmDao()
}
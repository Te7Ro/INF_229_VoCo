package com.example.kinopoisk.di

import com.example.kinopoisk.database.ProfileFilmDao
import com.example.kinopoisk.database.ProfileRepository
import com.example.kinopoisk.database.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule{

    @Provides
    @Singleton
    fun provideProfileRepository(
        dao: ProfileFilmDao
    ) : Repository{
        return ProfileRepository(
            dao = dao
        )
    }
}
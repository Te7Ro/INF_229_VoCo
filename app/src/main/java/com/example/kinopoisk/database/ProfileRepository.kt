package com.example.kinopoisk.database

import com.example.kinopoisk.di.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val dao: ProfileFilmDao
) : Repository {
    override fun getFilmsByCategory(category: String): Flow<Resource<List<ProfileFilm>>> = flow{
        emit(Resource.Loading)
        try {
            dao.getFilmsByCategory(category).collect {
                if(it.isEmpty()) {
                    emit(Resource.Empty)
                } else {
                    emit(Resource.Success(it))
                }
            }
        } catch (throwable: Throwable){
            emit(Resource.Error(throwable))
        }

    }
}



interface Repository {
    fun getFilmsByCategory(category: String) : Flow<Resource<List<ProfileFilm>>>
}
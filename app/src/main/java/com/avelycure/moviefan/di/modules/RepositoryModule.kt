package com.avelycure.moviefan.di.modules

import com.avelycure.moviefan.data.local.AppDatabase
import com.avelycure.moviefan.data.local.dao.CacheMovieInfoDao
import com.avelycure.moviefan.data.remote.service.ServiceFactory
import com.avelycure.moviefan.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(
        cacheMovieInfoDao: CacheMovieInfoDao,
        appDatabase: AppDatabase,
        serviceFactory: ServiceFactory
    ): MovieRepository {
        return MovieRepository(cacheMovieInfoDao, appDatabase, serviceFactory)
    }
}
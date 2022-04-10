package com.avelycure.moviefan.di.modules

import com.avelycure.moviefan.data.repository.MovieRepository
import com.avelycure.moviefan.domain.interactors.home.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MovieInteractorsModule {

    @Provides
    fun provideGetPopularMovies(repository: MovieRepository): GetPopularMovies {
        return GetPopularMovies(repository)
    }

    @Provides
    fun provideGetDetails(repository: MovieRepository): GetMovieInfo {
        return GetMovieInfo(repository)
    }

    @Provides
    fun provideGetVideos(repository: MovieRepository): GetTrailerCode {
        return GetTrailerCode(repository)
    }

    @Provides
    fun provideSearchMovie(repository: MovieRepository): FindMovie {
        return FindMovie(repository)
    }

    @Provides
    fun provideSaveToCache(repository: MovieRepository): SaveMovieInfoToCache {
        return SaveMovieInfoToCache(repository)
    }
}
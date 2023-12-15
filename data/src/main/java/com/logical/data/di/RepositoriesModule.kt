package com.logical.data.di


import com.logical.data.datasource.remote.ApiService
import com.logical.data.mappers.CountryItemModelMapper
import com.logical.data.repository.CountriesRepositoryImp
import com.logical.domain.repository.CountriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * This is a Hilt module used to provide dependencies for the repositories.
 * It is installed in the [SingletonComponent] which means the provided dependencies will have a singleton scope.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {


    /**
     * This function provides an instance of [CountriesRepository].
     * The provided [CountriesRepository] will have a singleton scope.
     * The actual implementation of the [CountriesRepository] is [CountriesRepositoryImp].
     */
    @Singleton
    @Provides
    fun provideImagesRepositoryImp(
        apiService: ApiService,
        mapper: CountryItemModelMapper
    ): CountriesRepositoryImp {
        return CountriesRepositoryImp(
            apiService,mapper
        )
    }
}
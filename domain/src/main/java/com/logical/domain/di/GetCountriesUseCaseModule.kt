package com.logical.domain.di

import android.content.res.Resources
import com.logical.domain.common.Resource
import com.logical.domain.repository.CountriesRepository
import com.logical.domain.usecase.GetCountriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
/**
 * This is a Hilt module used to provide dependencies for the use cases.
 * It is installed in the [SingletonComponent] which means the provided dependencies will have a singleton scope.
 */
@Module
@InstallIn(SingletonComponent::class)
class GetCountriesUseCaseModule {
    /**
     * This function provides an instance of [GetCountriesUseCase].
     * It takes [CountriesRepository] and [Resources] as parameters which will be provided by Hilt.
     */
    @Provides
    fun provideGetCountriesUseCase(countriesRepository: CountriesRepository, resources: Resources)=
        GetCountriesUseCase(countriesRepository,resources)
}
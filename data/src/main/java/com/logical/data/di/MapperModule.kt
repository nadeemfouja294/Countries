package com.logical.data.di

import com.logical.data.mappers.CountryItemModelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    /** Provides a singleton instance of [CountryItemModelMapper] for the entire application.
     * Utilizes Hilt's [Singleton] and [Provides] annotations to ensure that only one instance
     * of the mapper is created and reused wherever needed.
     */
    @Singleton
    @Provides
    fun provideCountryItemModelMapper(): CountryItemModelMapper {
        return CountryItemModelMapper()
    }
}
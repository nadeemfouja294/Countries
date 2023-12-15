package com.logical.data.repository

import com.logical.data.datasource.remote.ApiService
import com.logical.data.mappers.CountryItemModelMapper
import com.logical.data.model.CountryItemApiModel
import com.logical.domain.model.CountryItemModel
import com.logical.domain.repository.CountriesRepository
import javax.inject.Inject

/**
 * This is a repository class that fetches image data from a remote API or local database.
 * It decides whether to fetch new data from the API or use the existing data in the database based on the last fetch time.
 *
 * @property apiService The service to fetch data from the API.
 */
class CountriesRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val mapper: CountryItemModelMapper
) : CountriesRepository {

    /**
     * This function fetches the countries.
     */

    override suspend fun getCountries(): List<CountryItemModel> {
        val apiModels = apiService.getCountriesData()
        return mapper.mapFromApiModelList(apiModels)
    }

}
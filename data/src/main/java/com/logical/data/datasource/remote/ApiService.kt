package com.logical.data.datasource.remote


import com.logical.data.model.CountriesApiModel
import com.logical.data.model.CountryItemApiModel
import com.logical.domain.model.CountryItemModel
import retrofit2.http.GET

/**
 * This is a Retrofit service interface that provides access to the remote API.
 * It includes a method for fetching all countries.
 */
interface ApiService {

    /**
     * This function fetches country data from the remote JSON file.
     * The data is returned as a [CountriesApiModel] object.
     */
    @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getCountriesData(): List<CountryItemApiModel>
}
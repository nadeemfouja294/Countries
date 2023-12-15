package com.logical.domain.repository

import com.logical.domain.model.CountryItemModel

interface CountriesRepository {
    suspend fun getCountries():List<CountryItemModel>
}
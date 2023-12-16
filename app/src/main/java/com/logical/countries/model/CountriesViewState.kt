package com.logical.countries.model

import com.logical.domain.model.CountryItemModel

data class CountriesViewState(
    val isDataLoading: Boolean,
    val countries: List<CountryItemModel>,
    val errorMessage: String
)

fun emptyViewState() =
    CountriesViewState(isDataLoading = false, countries = emptyList(), errorMessage = "")

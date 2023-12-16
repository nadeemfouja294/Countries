package com.logical.countries.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.logical.countries.model.CountriesViewState
import com.logical.countries.model.emptyViewState
import com.logical.domain.common.Resource
import com.logical.domain.usecase.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(emptyViewState())
    val viewState: StateFlow<CountriesViewState> = _viewState

    init {
        loadCountries()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun loadCountries() {
        _viewState.value = _viewState.value.copy(isDataLoading = true)
        viewModelScope.launch {
            getCountriesUseCase().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _viewState.value = CountriesViewState(
                            isDataLoading = false,
                            countries = resource.data?: emptyList(),
                            errorMessage = ""
                        )
                    }
                    is Resource.Error -> {
                        _viewState.value = CountriesViewState(
                            isDataLoading = false,
                            countries = emptyList(),
                            errorMessage = resource.message ?: "Unknown Error"
                        )
                    }
                }
            }
        }
    }
}

package com.logical.domain.usecase

import android.content.res.Resources
import com.logical.domain.R
import com.logical.domain.common.Resource
import com.logical.domain.model.CountryItemModel
import com.logical.domain.repository.CountriesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCountriesUseCase(
    private val repository: CountriesRepository,
    private val resources: Resources
) {


    operator fun invoke(): Flow<Resource<List<CountryItemModel>>> =
        flow {
            try {
                val countries = repository.getCountries()
                emit(Resource.Success(countries))

            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage))
            } catch (e: IOException) {
                emit(Resource.Error(resources.getString(R.string.no_internet_message)))
            }
        }
}
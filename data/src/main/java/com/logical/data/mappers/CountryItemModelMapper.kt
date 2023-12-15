package com.logical.data.mappers

import com.logical.data.model.CountryItemApiModel
import com.logical.domain.model.CountryItemModel

class CountryItemModelMapper {

    private fun mapFromApiModel(apiModel: CountryItemApiModel): CountryItemModel {
        return CountryItemModel(
            capital = apiModel.capital,
            code = apiModel.code,
            name = apiModel.name,
            region = apiModel.region
        )
    }

    fun mapFromApiModelList(apiModels: List<CountryItemApiModel>): List<CountryItemModel> {
        return apiModels.map { mapFromApiModel(it) }
    }
}

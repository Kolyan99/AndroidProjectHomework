package com.example.androidprojecthomework.data.items

import com.example.androidprojecthomework.data.ApiService
import com.example.androidprojecthomework.domain.items.ItemsRepository
import com.example.androidprojecthomework.presentation.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : ItemsRepository {

    override suspend fun getData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getData()
            response.body()?.let {
                it.map{
                    ItemsModel(it.id,
                        it.username,
                        it.email,
                        it.website,
                        it.phone,
                        it.address,
                        it.geo,
                        it.company,
                        it.address.street,
                        it.address.suite,
                        it.address.city,
                        it.address.zipcode,
                        it.geo.lat,
                        it.geo.lng,
                        it.company.catchPhrase,
                        it.company.bs)
                }
                } ?: kotlin.run {
                    emptyList()
                }
            }
        }
    }
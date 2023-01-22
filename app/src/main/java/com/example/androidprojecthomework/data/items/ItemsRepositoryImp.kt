package com.example.androidprojecthomework.data.items

import android.util.Log
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
                it.map {
                    ItemsModel(
                        it.id,
                        it.personName,
                        it.username,
                        it.email,
                        it.phone,
                        it.website,
                        it.address.street,
                        it.address.suite,
                        it.address.city,
                        it.address.zipcode,
                        it.address.geo.lat,
                        it.address.geo.lng,
                        it.company.companyName,
                        it.company.catchPhrase,
                        it.company.bs
                    )
                }
                } ?: kotlin.run {
                    emptyList()
                }
            }
        }
    }
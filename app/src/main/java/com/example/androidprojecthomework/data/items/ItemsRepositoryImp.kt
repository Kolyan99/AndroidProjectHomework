package com.example.androidprojecthomework.data.items

import android.util.Log
import com.example.androidprojecthomework.data.ApiService
import com.example.androidprojecthomework.data.database.ItemsEntity
import com.example.androidprojecthomework.data.database.dao.ItemsDao
import com.example.androidprojecthomework.domain.items.ItemsRepository
import com.example.androidprojecthomework.presentation.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

class ItemsRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val itemsDao: ItemsDao
) : ItemsRepository {

    override suspend fun getData() {
        return withContext(Dispatchers.IO) {

            if (!itemsDao.doesItemsEntityExists()) {
                val response = apiService.getData()

                response.body()?.let {
                    it.map {
                        val itemsEntity = ItemsEntity(
                            Random.nextInt(), it.personName, it.username, it.email,it.phone,it.website,
                        it.address.street, it.address.suite, it.address.city, it.address.zipcode, it.address.city,
                        it.address.zipcode, it.address.geo.lng,it.address.geo.lat,it.company.companyName)
                        itemsDao.insertItemsEntity(itemsEntity)

                    }
                }
            }
        }
    }

        override suspend fun showData(): List<ItemsModel> {
            return withContext(Dispatchers.IO) {
                val itemsEntity = itemsDao.getItemsEntity()
                itemsEntity.map {
                    ItemsModel(Random.nextInt(), it.personName, it.username, it.email, it.phone, it.website, it.street, it.suite, it.city,
                    it.zipcode, it.lat, it.lng, it.companyName, it.catchPhrase, it.bs)
                }
            }
        }
    }

package com.example.androidprojecthomework.data.items

import com.example.androidprojecthomework.data.ApiService
import com.example.androidprojecthomework.data.database.FavoritesEntity
import com.example.androidprojecthomework.data.database.ItemsEntity
import com.example.androidprojecthomework.data.database.dao.ItemsDAO
import com.example.androidprojecthomework.domain.items.ItemsRepository
import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

class ItemsRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val itemsDao: ItemsDAO
) : ItemsRepository {

    override suspend fun getData() {
        return withContext(Dispatchers.IO) {

            if (!itemsDao.doesItemsEntityExist()) {
                val response = apiService.getData()

                response.body()?.let {
                    it.map {
                        val itemsEntity = ItemsEntity(
                            Random.nextInt(),
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
                        itemsDao.insertItemsEntity(itemsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDao.getItemsEntities()
            itemsEntity.map {
                ItemsModel(
                    Random.nextInt(),
                    it.personName,
                    it.username,
                    it.email,
                    it.phone,
                    it.website,
                    it.street,
                    it.suite,
                    it.city,
                    it.zipcode,
                    it.lat,
                    it.lng,
                    it.companyName,
                    it.catchPhrase,
                    it.bs
                )
            }
        }
    }

    override suspend fun findItemsEntityById(id: Int): ItemsModel {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDao.findItemsEntityById(id)
            ItemsModel(
                itemsEntity.id,
                itemsEntity.personName,
                itemsEntity.username,
                itemsEntity.email,
                itemsEntity.phone,
                itemsEntity.website,
                itemsEntity.street,
                itemsEntity.suite,
                itemsEntity.city,
                itemsEntity.zipcode,
                itemsEntity.lat,
                itemsEntity.lng,
                itemsEntity.companyName,
                itemsEntity.catchPhrase,
                itemsEntity.bs
            )
        }
    }

    override suspend fun favClicked(itemsModel: ItemsModel) {
        return withContext(Dispatchers.IO) {
            itemsDao.insertFavoritesEntity(
                FavoritesEntity(
                    itemsModel.id,
                    itemsModel.personName,
                    itemsModel.username,
                    itemsModel.email,
                    itemsModel.phone,
                    itemsModel.website,
                    itemsModel.street,
                    itemsModel.suite,
                    itemsModel.city,
                    itemsModel.zipcode,
                    itemsModel.lat,
                    itemsModel.lng,
                    itemsModel.companyName,
                    itemsModel.catchPhrase,
                    itemsModel.bs

                )
            )
        }
    }

    override suspend fun getFavorites(): List<FavoritesModel> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = itemsDao.getFavoritesEntities()
            favoritesEntity.map {
                FavoritesModel(
                    it.id,
                    it.personName,
                    it.username,
                    it.email,
                    it.phone,
                    it.website,
                    it.street,
                    it.suite,
                    it.city,
                    it.zipcode,
                    it.lat,
                    it.lng,
                    it.companyName,
                    it.catchPhrase,
                    it.bs
                )
            }
        }
    }
}


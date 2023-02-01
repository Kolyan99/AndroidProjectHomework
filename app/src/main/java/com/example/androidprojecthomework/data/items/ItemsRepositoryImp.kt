package com.example.androidprojecthomework.data.items

import com.example.androidprojecthomework.data.ApiService
import com.example.androidprojecthomework.data.database.FavoritesEntity
import com.example.androidprojecthomework.data.database.ItemsEntity
import com.example.androidprojecthomework.data.database.dao.ItemsDAO
import com.example.androidprojecthomework.domain.items.ItemsRepository
import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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
                        itemsDao.insertItemsEntity(itemsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): Flow<List<ItemsModel>> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDao.getItemsEntities()
            itemsEntity.map { itemsList ->
                itemsList.map { item ->
                    ItemsModel(
                        item.id,
                        item.personName,
                        item.username,
                        item.email,
                        item.phone,
                        item.website,
                        item.street,
                        item.suite,
                        item.city,
                        item.zipcode,
                        item.lat,
                        item.lng,
                        item.companyName,
                        item.catchPhrase,
                        item.bs
                    )
                }
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

    override suspend fun getFavorites(): Flow<List<FavoritesModel>> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = itemsDao.getFavoritesEntities()
            favoritesEntity.map {favoriteList ->
                favoriteList.map {favorite ->
                    FavoritesModel(
                        favorite.id,
                        favorite.personName,
                        favorite.username,
                        favorite.email,
                        favorite.phone,
                        favorite.website,
                        favorite.street,
                        favorite.suite,
                        favorite.city,
                        favorite.zipcode,
                        favorite.lat,
                        favorite.lng,
                        favorite.companyName,
                        favorite.catchPhrase,
                        favorite.bs
                    )
                }
            }
        }
    }

    override suspend fun onDeleteItem(id: Int) {
        return withContext(Dispatchers.IO){
            itemsDao.deleteItemEntityById(id)
        }
    }

    override suspend fun onDeleteFavorite(id: Int) {
        return withContext(Dispatchers.IO){
            itemsDao.deleteFavoriteEntityById(id)
        }
    }
}


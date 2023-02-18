package com.example.androidprojecthomework.data.items

import com.example.androidprojecthomework.data.ApiService
import com.example.androidprojecthomework.data.database.FavoritesEntity
import com.example.androidprojecthomework.data.database.ItemsEntity
import com.example.androidprojecthomework.data.database.dao.ItemsDAO
import com.example.androidprojecthomework.domain.items.ItemsRepository
import com.example.androidprojecthomework.presentation.model.FavoritesModel
import com.example.androidprojecthomework.presentation.model.ItemsModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
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

    private val compositeDisposable = CompositeDisposable()

    override  fun getData() : Completable {
        return Completable.defer {
             itemsDao.doesItemsEntityExist()
                .subscribeOn(Schedulers.io())
                .doAfterNext {
                    if (!it) {
                        val response = apiService.getData()
                        val getData = response.subscribeOn(Schedulers.io())
                            .doOnSuccess() {
                                it.let {
                                    itemsDao.insertItemsEntity(
                                        ItemsEntity(
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
                                    )
                                }
                            }
                            .ignoreElement()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe()
                        compositeDisposable.add(getData)
                    }
                }
                .ignoreElements()
                .observeOn(Schedulers.io())
        }
    }



    override fun showData(): Observable<List<ItemsModel>> {
        return itemsDao.getItemsEntities()
            .subscribeOn(Schedulers.io())
            .map { list ->
                list.map {
                    ItemsModel(
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
                        it.bs,
                        it.isFavorite ?: false
                    )
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
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
                itemsEntity.bs,
                itemsEntity.isFavorite ?: false
            )
        }
    }

    override suspend fun favClicked(itemsModel: ItemsModel, isFavorite: Boolean) {
        return withContext(Dispatchers.IO) {

            itemsDao.addToFavorite(
                itemsModel.id,
                isFavorite
            )

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
            favoritesEntity.map { favoriteList ->
                favoriteList.map { favorite ->
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
        return withContext(Dispatchers.IO) {
            itemsDao.deleteItemEntityById(id)
        }
    }

    override suspend fun onDeleteFavorite(id: Int) {
        return withContext(Dispatchers.IO) {
            itemsDao.deleteFavoriteEntityById(id)
        }
    }
}


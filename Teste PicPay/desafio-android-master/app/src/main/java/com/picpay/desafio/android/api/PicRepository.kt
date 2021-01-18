package com.picpay.desafio.android.api

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PicRepository @Inject constructor(private val api: PicPayService) {

    suspend fun getUsers() = api.getUsers()

}
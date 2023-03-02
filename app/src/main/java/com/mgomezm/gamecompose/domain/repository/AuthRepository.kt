package com.mgomezm.gamecompose.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.mgomezm.gamecompose.domain.model.Response

interface AuthRepository {

    val currentUser: FirebaseUser?

    suspend fun login(email: String, password: String): Response<FirebaseUser>

    fun logout()
}
package com.example.codibaandroid.model.service

import com.example.codibaandroid.model.CodibaUser
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUser: Flow<CodibaUser?>
    val currentUserId: String
    fun hasUser(): Boolean
    suspend fun signIn(email: String, password: String)
    suspend fun signUp(email: String, password: String)
    suspend fun signOut()
    suspend fun deleteAccount()
}
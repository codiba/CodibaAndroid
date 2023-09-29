package com.example.codibaandroid.activities.sign_in

import android.util.Log
import com.example.codibaandroid.MAIN_ACTIVITY
import com.example.codibaandroid.MAIN_PAGE_SCREEN
import com.example.codibaandroid.SIGN_IN_SCREEN
import com.example.codibaandroid.SIGN_UP_SCREEN
import com.example.codibaandroid.activities.CodibaAppViewModel
import com.example.codibaandroid.model.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val accountService: AccountService
) : CodibaAppViewModel() {
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        password.value = newPassword
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            accountService.signIn(email.value, password.value)
            openAndPopUp(MAIN_PAGE_SCREEN, SIGN_IN_SCREEN)
        }
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        openAndPopUp(SIGN_UP_SCREEN, SIGN_IN_SCREEN)
    }
}
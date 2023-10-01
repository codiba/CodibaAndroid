package com.example.codibaandroid.screens.sign_up

import android.util.Log
import com.example.codibaandroid.SIGN_IN_SCREEN
import com.example.codibaandroid.SIGN_UP_SCREEN
import com.example.codibaandroid.model.service.AccountService
import com.example.codibaandroid.screens.CodibaAppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val accountService: AccountService
) : CodibaAppViewModel() {
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    val confirmPassword = MutableStateFlow("")

    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        password.value = newPassword
    }

    fun updateConfirmPassword(newConfirmPassword: String) {
        confirmPassword.value = newConfirmPassword
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            if (password.value != confirmPassword.value) {
                throw Exception("Passwords do not match")
            }

            accountService.signUp(email.value, password.value)
            Log.d("Sign Up Clicked", "Üye olundu.")
            openAndPopUp(SIGN_IN_SCREEN, SIGN_UP_SCREEN)
        }
    }
}
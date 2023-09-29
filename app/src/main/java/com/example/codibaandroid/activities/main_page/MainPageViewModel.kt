package com.example.codibaandroid.activities.main_page

import com.example.codibaandroid.MAIN_PAGE_SCREEN
import com.example.codibaandroid.SIGN_IN_SCREEN
import com.example.codibaandroid.SIGN_UP_SCREEN
import com.example.codibaandroid.SPLASH_SCREEN
import com.example.codibaandroid.activities.CodibaAppViewModel
import com.example.codibaandroid.model.service.AccountService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    private val accountService: AccountService
) : CodibaAppViewModel() {
    fun onSignOutClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            accountService.signOut()
            openAndPopUp(SIGN_IN_SCREEN, MAIN_PAGE_SCREEN)
        }
    }

    fun onDeleteAccountClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            accountService.deleteAccount()
            openAndPopUp(SIGN_IN_SCREEN, MAIN_PAGE_SCREEN)
        }
    }
}
package com.example.codibaandroid.screens.main_page

import com.example.codibaandroid.MAIN_PAGE_SCREEN
import com.example.codibaandroid.SIGN_IN_SCREEN
import com.example.codibaandroid.model.service.AccountService
import com.example.codibaandroid.screens.CodibaAppViewModel
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
package com.example.codibaandroid.screens.add_item


import androidx.lifecycle.viewModelScope
import com.example.codibaandroid.ADD_ITEM_SCREEN
import com.example.codibaandroid.MAIN_PAGE_SCREEN
import com.example.codibaandroid.model.GoldItem
import com.example.codibaandroid.screens.CodibaAppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class AddItemViewModel @Inject constructor(): CodibaAppViewModel() {

    private val _priceState = MutableStateFlow(0.0)
    val price: StateFlow<Double> = _priceState.asStateFlow()

    private val _amountState = MutableStateFlow(0.0)
    val amount: StateFlow<Double> = _amountState.asStateFlow()

    private val _uiState = MutableStateFlow<AddItemUIState>(AddItemUIState.Idle)
    val uiState: StateFlow<AddItemUIState> = _uiState.asStateFlow()


    fun updateAmount(newAmount: Double){
        _amountState.value = newAmount
    }

    fun updatePrice(newPrice: Double){
        _priceState.value = newPrice
    }

    fun addItemClick() {
        launchCatching {
            fakeCall()
        }
    }


    private fun fakeCall(){
        viewModelScope.launch(Dispatchers.IO){
            _uiState.value = AddItemUIState.Loading
            delay(200)
            when(Random.nextInt(6)){
                in 0..1 -> _uiState.value = AddItemUIState.Success(
                    GoldItem(5.0, 1000.0)
                )
                in 4..5 -> _uiState.value = AddItemUIState.Error
            }
        }
    }

    sealed class AddItemUIState {
        object Loading : AddItemUIState()
        data class Success(val item: GoldItem) : AddItemUIState()
        object Error : AddItemUIState()
        object Idle : AddItemUIState()
    }

}


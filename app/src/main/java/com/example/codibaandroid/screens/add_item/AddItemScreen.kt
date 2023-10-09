package com.example.codibaandroid.screens.add_item


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.codibaandroid.ADD_ITEM_SCREEN
import com.example.codibaandroid.MAIN_PAGE_SCREEN
import com.example.codibaandroid.R

@Composable
fun AddItemViewScreen(
    openAndPopUp: (String, String) -> Unit,
    viewModel: AddItemViewModel = hiltViewModel()
) {
    AddItemViewScreenContent(
        amount = viewModel.amount.collectAsState(),
        price = viewModel.price.collectAsState(),
        onValueAmountChange = { viewModel.updateAmount(it.toDouble()) },
        onValuePriceChange = { viewModel.updatePrice(it.toDouble()) }
    ) {
        viewModel.addItemClick()
        when(viewModel.uiState.value){
            is AddItemViewModel.AddItemUIState.Success-> {
                openAndPopUp(MAIN_PAGE_SCREEN, ADD_ITEM_SCREEN)
            }
             AddItemViewModel.AddItemUIState.Error ->{
                Log.e("ADDITEM", "error")
            }
             else -> null
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemViewScreenContent(
    amount: State<Double>,
    price: State<Double>,
    onValueAmountChange: (String) -> Unit,
    onValuePriceChange: (String) -> Unit,
    onSellClick: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "*** usd")
        Spacer(modifier = Modifier.height(8.dp))


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 4.dp),
            value = amount.value.toString(),
            onValueChange = { onValueAmountChange(it) },
            label = { Text(stringResource(id = R.string.amount)) }
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 4.dp),
            value = price.value.toString(),
            onValueChange = { onValuePriceChange(it) },
            label = { Text(stringResource(R.string.price)) },
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { onSellClick() }) {
            Text(text = stringResource(id = R.string.sell))
        }
    }
}



package com.example.codibaandroid.activities.main_page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.codibaandroid.R
import com.example.codibaandroid.ui.theme.CodibaAndroidTheme
import com.example.codibaandroid.ui.theme.PurpleGrey40

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MainPageScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MainPageViewModel = hiltViewModel()
) {
    var showExitAppDialog by remember { mutableStateOf(false) }
    var showRemoveAccDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        TopAppBar(
            title = { Text(stringResource(R.string.app_name)) },
            actions = {
                IconButton(onClick = { showExitAppDialog = true }) {
                    Icon(Icons.Filled.ExitToApp, "Exit app")
                }
                IconButton(onClick = { showRemoveAccDialog = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.person_remove),
                        contentDescription = "Remove account",
                        tint = PurpleGrey40
                    )
                }
            }
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp))


        if (showExitAppDialog) {
            AlertDialog(
                title = { Text(stringResource(R.string.sign_out_title)) },
                text = { Text(stringResource(R.string.sign_out_description)) },
                dismissButton = {
                    Button(onClick = { showExitAppDialog = false }) {
                        Text(text = stringResource(R.string.cancel))
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        viewModel.onSignOutClick(openAndPopUp)
                        showExitAppDialog = false
                    }) {
                        Text(text = stringResource(R.string.sign_out))
                    }
                },
                onDismissRequest = { showExitAppDialog = false }
            )
        }

        if (showRemoveAccDialog) {
            AlertDialog(
                title = { Text(stringResource(R.string.delete_account_title)) },
                text = { Text(stringResource(R.string.delete_account_description)) },
                dismissButton = {
                    Button(onClick = { showRemoveAccDialog = false }) {
                        Text(text = stringResource(R.string.cancel))
                    }
                },
                confirmButton = {
                    Button(onClick = {
                        viewModel.onDeleteAccountClick(openAndPopUp)
                        showRemoveAccDialog = false
                    }) {
                        Text(text = stringResource(R.string.delete_account))
                    }
                },
                onDismissRequest = { showRemoveAccDialog = false }
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPagePreview() {
    CodibaAndroidTheme {
        MainPageScreen({ _, _ -> })
    }
}
package com.example.codibaandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codibaandroid.R

@Composable
fun AppLogoImageView(
    customModifier: Modifier = Modifier
        .padding(16.dp, 4.dp)
        .fillMaxSize(0.6f)
) {
    Image(
        painter = painterResource(id = R.mipmap.auth_image),
        contentDescription = "Auth image",
        modifier = customModifier
    )
}
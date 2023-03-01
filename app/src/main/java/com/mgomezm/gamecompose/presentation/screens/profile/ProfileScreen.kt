package com.mgomezm.gamecompose.presentation.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(navController: NavHostController) {

    Scaffold(
        topBar = {},
        content = {
            Text(text = "Profile Screen")
        },
        bottomBar = {}
    )
}
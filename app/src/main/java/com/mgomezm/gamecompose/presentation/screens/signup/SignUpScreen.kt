package com.mgomezm.gamecompose.presentation.screens.signup

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.mgomezm.gamecompose.presentation.components.DefaultTopBar
import com.mgomezm.gamecompose.presentation.screens.signup.components.SignUpContent

@Composable
fun SignUpScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "New user",
                upAvailable = true,
                navController = navController
            )
        },
        content = {
            SignUpContent(navController)
        },
        bottomBar = {}
    )
}
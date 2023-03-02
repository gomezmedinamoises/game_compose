package com.mgomezm.gamecompose.presentation.screens.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mgomezm.gamecompose.presentation.components.DefaultButton
import com.mgomezm.gamecompose.presentation.navigation.AppScreen

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {},
        content = {
            DefaultButton(
                modifier = Modifier,
                text = "Log out",
                onClick = {
                    viewModel.logout()
                    navController.navigate(route = AppScreen.Login.route) {
                        // Delete previous screen
                        popUpTo(AppScreen.Profile.route) { inclusive = true }
                    }
                }
            )
        },
        bottomBar = {}
    )
}
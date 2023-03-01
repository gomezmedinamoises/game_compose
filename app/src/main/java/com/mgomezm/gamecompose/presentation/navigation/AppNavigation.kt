package com.mgomezm.gamecompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mgomezm.gamecompose.presentation.screens.login.LoginScreen
import com.mgomezm.gamecompose.presentation.screens.profile.ProfileScreen
import com.mgomezm.gamecompose.presentation.screens.signup.SignUpScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {
        composable(route = AppScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreen.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(route = AppScreen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
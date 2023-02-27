package com.mgomezm.gamecompose.presentation.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mgomezm.gamecompose.presentation.screens.login.components.LoginBottomBar
import com.mgomezm.gamecompose.presentation.screens.login.components.LoginContent
import com.mgomezm.gamecompose.presentation.ui.theme.GameComposeTheme

@Composable
fun LoginScreen(navController: NavHostController) {

    Scaffold(
        topBar = {},
        content = {
            LoginContent()
        },
        bottomBar = {
            LoginBottomBar(navController)
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    GameComposeTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
           LoginScreen(rememberNavController())
        }
    }
}
package com.mgomezm.gamecompose.presentation.screens.login.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mgomezm.gamecompose.presentation.navigation.AppScreen

@Composable
fun LoginBottomBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Do you need an account?",
            fontSize = 14.sp,
            color = Color.Gray,
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = AppScreen.SignUp.route)
            },
            text = "Click here!",
            fontSize = 14.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
    }
}
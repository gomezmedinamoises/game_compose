package com.mgomezm.gamecompose.presentation.screens.login.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.mgomezm.gamecompose.R
import com.mgomezm.gamecompose.domain.model.Response
import com.mgomezm.gamecompose.presentation.components.DefaultButton
import com.mgomezm.gamecompose.presentation.components.DefaultProgressIndicator
import com.mgomezm.gamecompose.presentation.components.DefaultTextField
import com.mgomezm.gamecompose.presentation.navigation.AppScreen
import com.mgomezm.gamecompose.presentation.screens.login.LoginViewModel
import com.mgomezm.gamecompose.presentation.ui.theme.DarkGray500
import com.mgomezm.gamecompose.presentation.ui.theme.GameComposeTheme
import com.mgomezm.gamecompose.presentation.ui.theme.Red500

@Composable
fun LoginContent(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val loginFlow = viewModel.loginFlow.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
       BoxHeader()
       CardForm()
    }

    loginFlow.value.let {state ->
        when (state) {
            Response.Loading -> {
                DefaultProgressIndicator()
            }
            is Response.Success -> {
                LaunchedEffect(Unit) {
                    navController.navigate(route = AppScreen.Profile.route) {
                        // Delete previous screen
                        popUpTo(AppScreen.Login.route) { inclusive = true }
                    }
                }
            }
            is Response.Failure -> Toast.makeText(LocalContext.current, state.exception?.message ?: "Unknown error", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun BoxHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
            .background(Red500)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                modifier = Modifier.height(130.dp),
                painter = painterResource(id = R.drawable.control),
                contentDescription = "Xbox 360 control"
            )
            Text(
                text = "Game Compose with Firebase"
            )
        }
    }
}

@Composable
fun CardForm(viewModel: LoginViewModel = hiltViewModel()) {

    Card(
        modifier = Modifier.padding(
            start = 40.dp,
            end = 40.dp,
            top = 220.dp
        ),
        backgroundColor = DarkGray500

    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 20.dp
            )
        ) {
            Text(
                modifier = Modifier.padding(
                    top = 40.dp
                ),
                text = "Log-in",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Please, sign-in to continue",
                fontSize = 12.sp,
                color = Color.Gray
            )
            // Email
            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = viewModel.email.value,
                onValueChange = { viewModel.email.value = it },
                label = "Email",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email,
                errorMessage = viewModel.emailErrorMessage.value,
                validateField = {
                    viewModel.validateEmail()
                }
            )
            // Password
            DefaultTextField(
                modifier = Modifier.padding(top = 0.dp),
                value = viewModel.password.value,
                onValueChange = { viewModel.password.value = it },
                label = "Password",
                icon = Icons.Default.Lock,
                hideText = true,
                errorMessage = viewModel.passwordErrorMessage.value,
                validateField = {
                    viewModel.validatePassword()
                }
            )
            // Button
            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp),
                text = "Log in",
                onClick = {
                    viewModel.login()
                },
                enabled = viewModel.isEnabledLoginButton
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
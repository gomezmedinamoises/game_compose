package com.mgomezm.gamecompose.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mgomezm.gamecompose.R
import com.mgomezm.gamecompose.presentation.components.DefaultButton
import com.mgomezm.gamecompose.presentation.components.DefaultTextField
import com.mgomezm.gamecompose.presentation.screens.signup.SignUpViewModel
import com.mgomezm.gamecompose.presentation.ui.theme.DarkGray500
import com.mgomezm.gamecompose.presentation.ui.theme.GameComposeTheme
import com.mgomezm.gamecompose.presentation.ui.theme.Red500
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun SignUpContent(viewModel: SignUpViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(215.dp)
                .background(Red500)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                    modifier = Modifier.height(80.dp),
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User image"
                )
            }
        }
        Card(
            modifier = Modifier.padding(
                start = 40.dp,
                end = 40.dp,
                top = 165.dp
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
                    text = "Sign-in",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Please, fill the data to continue",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                // Username
                DefaultTextField(
                    modifier = Modifier.padding(top = 25.dp),
                    value = viewModel.username.value,
                    onValueChange = { viewModel.username.value = it },
                    label = "Username",
                    icon = Icons.Default.Person,
                    errorMessage = viewModel.usernameErrorMessage.value,
                    validateField = {
                        viewModel.validateUsername()
                    }
                )
                // Email
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
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
                // Confirm password
                DefaultTextField(
                    modifier = Modifier.padding(top = 0.dp),
                    value = viewModel.confirmpassword.value,
                    onValueChange = { viewModel.confirmpassword.value = it },
                    label = "Confirm password",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    errorMessage = viewModel.confirmPasswordErrorMessage.value,
                    validateField = {
                        viewModel.validateConfirmPassword()
                    }
                )
                // Button
                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    text = "Sign in",
                    onClick = {  },
                    enabled = viewModel.isEnabledLoginButton,
                    errorMessage = ""
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreviewSignUpContent() {
    GameComposeTheme(darkTheme = true) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SignUpContent()
        }
    }
}
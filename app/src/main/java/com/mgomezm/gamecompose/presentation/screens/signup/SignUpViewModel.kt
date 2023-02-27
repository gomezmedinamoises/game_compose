package com.mgomezm.gamecompose.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(): ViewModel() {

    // Username
    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrorMessage: MutableState<String> = mutableStateOf("")

    // Email
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrorMessage: MutableState<String> = mutableStateOf("")

    // Password
    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrorMessage: MutableState<String> = mutableStateOf("")

    // Confirm password
    var confirmpassword: MutableState<String> = mutableStateOf("")
    var isConfirmPassword: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrorMessage: MutableState<String> = mutableStateOf("")

    var isEnabledLoginButton = false

    fun enableLoginButton() {
        isEnabledLoginButton = isEmailValid.value &&
                    isPasswordValid.value &&
                    isUsernameValid.value &&
                    isConfirmPassword.value
    }

    fun validateUsername() {
        if (username.value.length >= 5) {
            isUsernameValid.value = true
            usernameErrorMessage.value = ""
        } else {
            isUsernameValid.value = false
            usernameErrorMessage.value = "At least 5 characters"
        }
        enableLoginButton()
    }

    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrorMessage.value = ""
        } else {
            isEmailValid.value = false
            emailErrorMessage.value = "Email is not valid"
        }
        enableLoginButton()
    }

    fun validatePassword() {
        if (password.value.length >= 6) {
            isPasswordValid.value = true
            passwordErrorMessage.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrorMessage.value = "Password must have at least 6 characters"
        }
        enableLoginButton()
    }

    fun validateConfirmPassword() {
        if (password.value == confirmpassword.value) {
            isConfirmPassword.value = true
            confirmPasswordErrorMessage.value = ""
        } else {
            isConfirmPassword.value = false
            confirmPasswordErrorMessage.value = "Passwords must be equals"
        }
        enableLoginButton()
    }
}
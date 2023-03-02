package com.mgomezm.gamecompose.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.auth.FirebaseUser
import com.mgomezm.gamecompose.domain.model.Response
import com.mgomezm.gamecompose.domain.model.User
import com.mgomezm.gamecompose.domain.usecases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {

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

    private val _signUpFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signUpFlow: StateFlow<Response<FirebaseUser>?> = _signUpFlow

    fun onSignUp() {
        val user = User(
            username = username.value,
            email = email.value,
            password = password.value
        )


        signUp(user)
    }
    fun signUp(user: User) = viewModelScope.launch {
        _signUpFlow.value = Response.Loading
        val result = authUseCase.signUp(user)
        _signUpFlow.value = result
    }

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
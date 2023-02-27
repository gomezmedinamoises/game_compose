package com.mgomezm.gamecompose.domain.usecases.auth

// Allows access to any use case within the auth package
data class AuthUseCase(
    val getCurrentUser: GetCurrentUserUseCase,
    val login: LoginUseCase
)
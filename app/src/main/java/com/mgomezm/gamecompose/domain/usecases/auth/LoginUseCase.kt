package com.mgomezm.gamecompose.domain.usecases.auth

import com.mgomezm.gamecompose.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}
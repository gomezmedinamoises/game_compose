package com.mgomezm.gamecompose.domain.usecases.auth

import com.mgomezm.gamecompose.domain.model.User
import com.mgomezm.gamecompose.domain.repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(user: User) = repository.signUp(user)
}
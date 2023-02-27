package com.mgomezm.gamecompose.domain.usecases.auth

import com.mgomezm.gamecompose.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.currentUser
}
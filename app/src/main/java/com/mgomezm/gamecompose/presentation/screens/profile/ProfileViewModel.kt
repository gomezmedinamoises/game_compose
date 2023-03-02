package com.mgomezm.gamecompose.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.mgomezm.gamecompose.domain.usecases.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {

    fun logout() {
        authUseCase.logout
    }
}
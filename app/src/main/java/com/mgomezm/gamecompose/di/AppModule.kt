package com.mgomezm.gamecompose.di

import com.google.firebase.auth.FirebaseAuth
import com.mgomezm.gamecompose.data.repository.AuthRepositoryImpl
import com.mgomezm.gamecompose.domain.repository.AuthRepository
import com.mgomezm.gamecompose.domain.usecases.auth.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideAuthUseCase(repository: AuthRepository) = AuthUseCase(
        getCurrentUser = GetCurrentUserUseCase(repository),
        login = LoginUseCase(repository),
        logout = LogoutUseCase(repository),
        signUp = SignUpUseCase(repository)
    )


}
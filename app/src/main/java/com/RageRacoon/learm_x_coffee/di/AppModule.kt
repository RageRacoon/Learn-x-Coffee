package com.RageRacoon.learm_x_coffee.di

import com.RageRacoon.learm_x_coffee.data.repository.AuthRepositoryImplement
import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.*
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
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
    fun provideAuthRepository(implementation: AuthRepositoryImplement): AuthRepository = implementation

    @Provides
    fun provideLoginUseCases(repository: AuthRepository)= LoginUseCase(
        getUser = GetUser(repository),
        login = Login(repository),
        loginOut = LoginOut(repository),
        register = Register(repository)
    )

}
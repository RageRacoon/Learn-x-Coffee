package com.RageRacoon.learm_x_coffee.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val loginUseCase: LoginUseCase):ViewModel() {
    fun logOut(){
        loginUseCase.loginOut()
    }
}
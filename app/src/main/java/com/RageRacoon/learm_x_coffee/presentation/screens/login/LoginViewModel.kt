n`package com.RageRacoon.learm_x_coffee.presentation.screens.login

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.AuthUseCase
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.Login
import dagger.hilt.android.lifecycle.HiltViewModel
import hilt_aggregated_deps._com_RageRacoon_learm_x_coffee_presentation_screens_login_LoginViewModel_HiltModules_KeyModule
import javax.inject.Inject

@HiltViewModel
class LoginViewModel (){
    Login


    var email: MutableState<String> = mutableStateOf(" ")
    var password: MutableState<String> = mutableStateOf(" ")

    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
}
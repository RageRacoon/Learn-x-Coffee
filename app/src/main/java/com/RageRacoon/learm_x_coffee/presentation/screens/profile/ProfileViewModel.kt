package com.RageRacoon.learm_x_coffee.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.LoginUseCase
import com.RageRacoon.learm_x_coffee.domain.use_cases.users.ProfilesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel @Inject constructor(private val loginUseCase: LoginUseCase, private val profilesUseCase: ProfilesUseCase):ViewModel() {

    var userInfo by mutableStateOf(User())
        private set // Set de esta variable, son privados, solo es posible su modifiación desde la calse viewModel
    val activeUser = loginUseCase.getUser()

    init{ //Init es el primer métoado que se lanza al estnaciar el viewModel
        getUserById()
    }
    fun logOut(){
        loginUseCase.loginOut()
    }
    private fun getUserById() = viewModelScope.launch {
        profilesUseCase.getUserById(activeUser!!.uid).collect(){
            userInfo = it
        } //Se le suministra la Id, del usaurio activo en ese momento
    }

}
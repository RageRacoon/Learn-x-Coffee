package com.RageRacoon.learm_x_coffee.presentation.screens.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.LoginUseCase
import com.RageRacoon.learm_x_coffee.domain.use_cases.users.ProfilesUseCase
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginState
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


 @HiltViewModel
 class SingUpViewModel  @Inject constructor(private val loginUseCase: LoginUseCase, private val profilesUseCase: ProfilesUseCase): ViewModel(){
     //Usuario resgistrado
     var user = User()
     //  _____    _            _
     // |  ___|  | |          | |
     // | |__ ___| |_ __ _  __| | ___  ___
     // |  __/ __| __/ _` |/ _` |/ _ \/ __|
     //| |__\__ \ || (_| | (_| | (_) \__ \
     //\____/___/\__\__,_|\__,_|\___/|___/\

     var state by mutableStateOf(SignUpState())
         private set

     // Username
     var username: MutableState<String> = mutableStateOf(value = "")
     var isUsernameValid: MutableState<Boolean> = mutableStateOf(value = false)
     var usernameError: MutableState<String> = mutableStateOf(value = "")

     //Mail
     var email: MutableState<String> = mutableStateOf(value = "")
     var isEmailValid: MutableState<Boolean> = mutableStateOf(value = false)
     var emailError: MutableState<String> = mutableStateOf(value = "")

     //Pasword
     var password: MutableState<String> = mutableStateOf(value = "")
     var isPasswordValid: MutableState<Boolean> = mutableStateOf(value = false)
     var passwordError: MutableState<String> = mutableStateOf(value = "")

     //Passworrd 2
     var confirmPassword: MutableState<String> = mutableStateOf(value = "")
     var isConfirmPasswordValid: MutableState<Boolean> = mutableStateOf(value = false)
     var confirmPasswordError: MutableState<String> = mutableStateOf(value = "")

     //Boton accesible
     var isAccesibleResgisterButton = false

     //______                _
     //|  ___|              (_)
     //| |_ _   _ _ __   ___ _  ___  _ __   ___  ___
     //|  _| | | | '_ \ / __| |/ _ \| '_ \ / _ \/ __|
     //| | | |_| | | | | (__| | (_) | | | |  __/\__ \
     //\_|  \__,_|_| |_|\___|_|\___/|_| |_|\___||___/
     //


     fun validateConfirmPassword(){

     }

     fun onRegister(){
         user.userName = username.value
         user.password = password.value
         user.correo   = email.value

         register(user)
     }

     private val _registerFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
     val registerFlow: StateFlow<Response<FirebaseUser>?> = _registerFlow

     fun register(user: User) = viewModelScope.launch {
         _registerFlow.value = Response.Loading
         val resul = loginUseCase.register(user)
         _registerFlow.value = resul
     }
     fun AccesibleResgisterButton(){
         if (isConfirmPasswordValid.value &&  isPasswordValid.value && isEmailValid.value && isUsernameValid.value){
             isUsernameValid.value = true
         }
     }
     fun createNewUser() = viewModelScope.launch {
         user.id = loginUseCase.getUser()!!.uid
         profilesUseCase.create(user)
     }







 }
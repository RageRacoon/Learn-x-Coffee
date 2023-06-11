package com.RageRacoon.learm_x_coffee.presentation.screens.signup

import android.widget.Toast
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
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
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

@HiltViewModel
 class SingUpViewModel  @Inject constructor(private val loginUseCase: LoginUseCase, private val profilesUseCase: ProfilesUseCase): ViewModel(){
     //Usuario resgistrado
     var user = User()
     //  _____    _            _
     // |  ___|  | |          | |
     // | |__ ___| |_ __ _  __| | ___  ___
     // |  __/ __| __/ _` |/ _` |/ _ \/ __|
     // | |__\__ \ || (_| | (_| | (_) \__ \
     // \____/___/\__\__,_|\__,_|\___/|___/\

     var state by mutableStateOf(SignUpState())
         private set
     var registerResponse by mutableStateOf<Response<FirebaseUser>?>(null) //Inicializamos el usuario como null ,para controlar los null Ponter exception
         private set

     // Username
     var isUsernameOk: Boolean by mutableStateOf(value = false)
     var usernameError: String by mutableStateOf(value = "")

     //Mail
     var isEmailOk: Boolean by mutableStateOf(false)
         private set
     var emailError: String by mutableStateOf("")
         private set

     //Pasword
     var isPasswordOk:Boolean by mutableStateOf(value = false)
         private set
     var passwordError: String by mutableStateOf(value = "")

     //Passworrd 2
     var isConfirmPasswordOk: Boolean by mutableStateOf(value = false)
         private set
     var confirmPasswordError: String by mutableStateOf(value = "")

     //Boton accesible
     var isAccesibleResgisterButton = false

     //______                _
     //|  ___|              (_)
     //| |_ _   _ _ __   ___ _  ___  _ __   ___  ___
     //|  _| | | | '_ \ / __| |/ _ \| '_ \ / _ \/ __|
     //| | | |_| | | | | (__| | (_) | | | |  __/\__ \
     //\_|  \__,_|_| |_|\___|_|\___/|_| |_|\___||___/
     //

     //Funciones manejadoreas de estado

     fun userNameImput(username: String) {
         state = state.copy(username = username)
     }
     fun emailInput(email: String) {
         state = state.copy(email = email)
     }

     fun passwordInput(password: String) {
         state = state.copy(password = password)
     }
     fun confirmPasswordInput(confirmPasword: String) {
         state = state.copy(confirmPasword = confirmPasword)
     }

    fun usernameNotVoid() : Boolean {
        if(state.username.length != 0){
            return true
        }
        return false
    }

     fun validateConfirmPassword() : Boolean{
         if (state.password != state.confirmPasword){
            return false
         }
         return true
     }

     fun onRegister(){

         if(validateConfirmPassword() == true && usernameNotVoid() == true){

            user.userName = state.username
            user.password = state.password
            user.correo   = state.email

            register(user)

         }
     }

     //private val _registerFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
     //val registerFlow: StateFlow<Response<FirebaseUser>?> = _registerFlow

     fun register(user: User) = viewModelScope.launch {
         registerResponse = Response.Loading
         val resul = loginUseCase.register(user)
         registerResponse = resul
     }
     fun EnableRegisterButton(){
         if (isConfirmPasswordOk &&  isPasswordOk && isEmailOk && isUsernameOk){
             isUsernameOk= true
         }
     }
     fun createNewUser() = viewModelScope.launch {
         user.id = loginUseCase.getUser()!!.uid
         profilesUseCase.create(user)
     }







 }
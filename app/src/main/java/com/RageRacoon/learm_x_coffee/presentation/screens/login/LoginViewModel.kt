package com.RageRacoon.learm_x_coffee.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.LoginUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel  @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel(){

    //  _____    _            _
    // |  ___|  | |          | |
    // | |__ ___| |_ __ _  __| | ___  ___
    // |  __/ __| __/ _` |/ _` |/ _ \/ __|
    // | |__\__ \ || (_| | (_| | (_) \__ \
    // \____/___/\__\__,_|\__,_|\___/|___/\

    //Manejar las respuestas de la base de datos con estados
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null) //Inicializamos el usuario como null ,para controlar los null Ponter exception
        private set

    // Ahora solo se trabaja con el stadod el viewModel //
    //private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null) //Inicializamos el usuario como null ,para controlar los null Ponter exception
    //val loginFlow:StateFlow<Response<FirebaseUser>?> = _loginFlow //Encapsulación del usuario activo
    // variable, del estado del formulario, ya
    var state by mutableStateOf(LoginState()) //<- Su valor inicial, es el mismo que los valores dentro de la calse State
        private set //Stets privados

    // EMAIL VALIDATIONS
    var isEmailOk by mutableStateOf(false)
        private set

    var emailErrMsg by mutableStateOf("")
        private set

    // PASSWORD VALIDATIONS
    var isPasswordOk by mutableStateOf(false)
        private set
    var passwordErrMsg by mutableStateOf("")
        private set

    // ENABLE BUTTON
    var isClickableLoginButton = false

    // Respuesta del login


    val activeUser = loginUseCase.getUser()

    init { //Al inicializarse la clase del vwm, el cual se inicializa al cargar la screen, se lanzara este fragmento de codigo, que compruebas si hay un usuario activo en la aplicación
        if (activeUser != null) { // loggin correcto, sesion iniciada
            loginResponse = Response.Successful(activeUser)
        }
    }

    //______                _
    //|  ___|              (_)
    //| |_ _   _ _ __   ___ _  ___  _ __   ___  ___
    //|  _| | | | '_ \ / __| |/ _ \| '_ \ / _ \/ __|
    //| | | |_| | | | | (__| | (_) | | | |  __/\__ \
    //\_|  \__,_|_| |_|\___|_|\___/|_| |_|\___||___/
    //

    //Son funciones manejadoras de estado, reciven una valor por parametros y lo copian en la calse State
    fun emailInput(email: String) {
        state = state.copy(email = email)
    }

    fun passwordInput(password: String) {
        state = state.copy(password = password)
    }


   fun login() = viewModelScope.launch {
       loginResponse = Response.Loading
        val result = loginUseCase.login(state.email, state.password)
       loginResponse = result
    }

    fun EnabledLoginButton() {
        isClickableLoginButton = isEmailOk && isPasswordOk
    }

    fun validateEmail() {
        // ES UN EMAIL VALIDO
        if (Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            isEmailOk = true
            emailErrMsg = ""
        }
        else {
            isEmailOk = false
            emailErrMsg = "El email no es valido"
        }
        EnabledLoginButton()
    }

    fun validatePassword() {
        if (state.password.length >= 6) {
            isPasswordOk = true
            passwordErrMsg = ""
        }
        else {
            isPasswordOk = false
            passwordErrMsg = "Al menos 6 caracteres"
        }

        EnabledLoginButton()
    }
}
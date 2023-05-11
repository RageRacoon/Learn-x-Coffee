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
    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow:StateFlow<Response<FirebaseUser>?> = _loginFlow
    // STATE FORM
    var state by mutableStateOf(LoginState())
        private set

    // EMAIL VALIDATIONS
    var isEmailValid by mutableStateOf(false)
        private set

    var emailErrMsg by mutableStateOf("")
        private set

    // PASSWORD VALIDATIONS
    var isPasswordValid by mutableStateOf(false)
        private set
    var passwordErrMsg by mutableStateOf("")
        private set

    // ENABLE BUTTON
    var isEnabledLoginButton = false

    // LOGIN RESPONSE
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set

    val activeUser = loginUseCase.getUser()

    init {
        if (activeUser != null) { // loggin correcto, sesion iniciada
            _loginFlow.value = Response.Successful(activeUser)
        }
    }

    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }


   fun login() = viewModelScope.launch {
        _loginFlow.value = Response.Loading
        val result = loginUseCase.login(state.email, state.password)
        _loginFlow.value = result
    }

    fun enabledLoginButton() {
        isEnabledLoginButton = isEmailValid && isPasswordValid
    }

    fun validateEmail() {
        // ES UN EMAIL VALIDO
        if (Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            isEmailValid = true
            emailErrMsg = ""
        }
        else {
            isEmailValid = false
            emailErrMsg = "El email no es valido"
        }

        enabledLoginButton()
    }

    fun validatePassword() {
        if (state.password.length >= 6) {
            isPasswordValid = true
            passwordErrMsg = ""
        }
        else {
            isPasswordValid = false
            passwordErrMsg = "Al menos 6 caracteres"
        }

        enabledLoginButton()
    }
}
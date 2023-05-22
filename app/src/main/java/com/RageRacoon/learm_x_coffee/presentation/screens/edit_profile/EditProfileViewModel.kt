package com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile

import android.app.Activity
import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.SignUpState

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
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.RageRacoon.learm_x_coffee.utiles.ComposeFileProvider
import com.RageRacoon.learm_x_coffee.utiles.ResultingActivityHandler
import dagger.hilt.android.qualifiers.ApplicationContext

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    private val profilesUseCase: ProfilesUseCase,
    private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val context: Context
    ): ViewModel(){

    //Usuario recivido desde la ruta de navegación
    val userValueString = savedStateHandle.get<String>("user")
    val user = User.fromJson(userValueString!!) //Creamos el objeto User con la string recivida de la ruta del nav
    //  _____    _            _
    // |  ___|  | |          | |
    // | |__ ___| |_ __ _  __| | ___  ___
    // |  __/ __| __/ _` |/ _` |/ _ \/ __|
    // | |__\__ \ || (_| | (_| | (_) \__ \
    // \____/___/\__\__,_|\__,_|\___/|___/\

    var state by mutableStateOf(EditProfileState())
        private set
    var editResponse by mutableStateOf<Response<Boolean>?>(null) //Inicializamos el usuario como null ,para controlar los null Ponter exception
        private set

    // Username
    var isUsernameOk: Boolean by mutableStateOf(value = false)
    var usernameError: String by mutableStateOf(value = "")

    //Boton accesible
    var isAccesibleResgisterButton = false

    //tratamiento de imagenes
    var imgUri by mutableStateOf<String>("")

    var hasImg by mutableStateOf<Boolean>(false)
      private set



    //______                _
    //|  ___|              (_)
    //| |_ _   _ _ __   ___ _  ___  _ __   ___  ___
    //|  _| | | | '_ \ / __| |/ _ \| '_ \ / _ \/ __|
    //| | | |_| | | | | (__| | (_) | | | |  __/\__ \
    //\_|  \__,_|_| |_|\___|_|\___/|_| |_|\___||___/
    //

    //Funciones manejadoreas de estado
    init {
        state = state.copy(username = user.userName)
    }

    fun clickEdit(){
        val editUser = User(
            id = user.id,
            userName = state.username,
            img = ""
        )
        edit(editUser)
    }
    fun userNameImput(username: String) {
        state = state.copy(username = username)
    }

    fun edit(user: User){
        viewModelScope.launch {
            editResponse = Response.Loading
            val resultado = profilesUseCase.edit(user)
            editResponse = resultado
        }

    }


    //Tratemiento de imagenes
    val resultingActivityHandler = ResultingActivityHandler()
   fun getImg() = viewModelScope.launch {
       val result =resultingActivityHandler.getContent("image/*")
       if (result != null){
           imgUri = result.toString()
       }

   }
    fun takeAPicture() = viewModelScope.launch {
        val result =resultingActivityHandler.takePicturePreview()
        if (result != null){
            imgUri = ComposeFileProvider.getPathFromBitmap(context,bitmap = result)
        }

    }

    fun EnableRegisterButton(){
        if (isUsernameOk){
            isUsernameOk= true
        }
    }







}
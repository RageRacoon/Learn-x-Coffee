package com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.components.Edit
import com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.components.EditProfileContent
import com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.components.EditProfileTopBar
import com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.components.SaveImg

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditProfileScreen(navController: NavHostController, user:String){
    Log.d("EditProfileScreen", "Usuario:  $user")
    Scaffold(
        topBar = {
            EditProfileTopBar()
        },
        content = {
            EditProfileContent(navController)
        },
        bottomBar = {}
    )
    SaveImg()
    Edit()
}
package com.RageRacoon.learm_x_coffee.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User (
    var id: String = "",
    var userName: String = "",
    var img: String = "",
    var correo: String = "",
    var password: String = "",
    var passwordConfirm: String = "",
){
    fun toJson():String = Gson().toJson(User(
        id,
        userName,
        if (img != "") URLEncoder.encode(img, StandardCharsets.UTF_8.toString()) else "",
        correo,
        password,
        passwordConfirm
    )) //Transformamos esta clase en Json


    companion object {
        fun fromJson(dato:String):User = Gson().fromJson(dato, User::class.java) //Método estático que convierte las StringRecivida en una Clase
    }
}
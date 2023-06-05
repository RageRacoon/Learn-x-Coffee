package com.RageRacoon.learm_x_coffee.domain.model

sealed class Response<out T> { //Es de tipo generico, cualquier objeto, MODELAR RESPUESTA DE FIREBASE
    object  Loading: Response<Nothing>() //NO DEVUELVE NADA, PORQUE NO SABEMOS CUANTO VA A TARDAR
    data class Successful<out T>(val data: T): Response<T>() //Devuelve cualquier objeto
    data class Failure<out T>(val exception: Exception?): Response<T>() //En caso de que falle la recojida de datos retornara una excepcion
}


package com.RageRacoon.learm_x_coffee.utiles

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

class  DateUtiles {

    fun getWeekday(): String {
        val calendar = Calendar.getInstance()
        val weekday = calendar.get(Calendar.DAY_OF_WEEK,)

        return when (weekday) {
            Calendar.SUNDAY -> "Domingo"
            Calendar.MONDAY -> "Lunes"
            Calendar.TUESDAY -> "Martes"
            Calendar.WEDNESDAY -> "Miércoles"
            Calendar.THURSDAY -> "Jueves"
            Calendar.FRIDAY -> "Viernes"
            Calendar.SATURDAY -> "Sábado"
            else -> "Desconocido"
        }
    }

     fun getDate(): String {
        val calendar = Calendar.getInstance()
        val dia = calendar.get(Calendar.DAY_OF_MONTH)
        val mes = calendar.get(Calendar.MONTH) + 1 // Los meses en Calendar están basados en 0, por lo que se suma 1 para obtener el mes correcto
        val año = calendar.get(Calendar.YEAR)

        return "$dia/$mes/$año"
    }

    fun getDateMañana(diasAdelantados: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, diasAdelantados)
        val dia = calendar.get(Calendar.DAY_OF_MONTH)
        val mes = calendar.get(Calendar.MONTH) + 1 // Los meses en Calendar están basados en 0, por lo que se suma 1 para obtener el mes correcto
        val año = calendar.get(Calendar.YEAR)

        return "$dia/$mes/$año"
    }


    @RequiresApi(Build.VERSION_CODES.N)
    fun obtenerDiaManana(diasAdelantados: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, diasAdelantados) // Añadir un día a la fecha actual

        val dateFormat = SimpleDateFormat("EEEE", Locale.getDefault())
        val diaSemana = dateFormat.format(calendar.time)

        return when (diaSemana) {
            "lunes" -> "Lunes"
            "martes" -> "Martes"
            "miércoles" -> "Miércoles"
            "jueves" -> "Jueves"
            "viernes" -> "Viernes"
            "sábado" -> "Sábado"
            "domingo" -> "Domingo"
            else -> ""
        }
    }
}
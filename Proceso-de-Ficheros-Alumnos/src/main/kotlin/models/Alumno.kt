package dev.samuel.models

import java.time.LocalDate

data class Alumno(
    val id: Int,
    val nombre: String,
    val createdAt: LocalDate,
    val tipo: Tipo,
    val edad: Int
){
    enum class Tipo{
        ALUMNO
    }
}

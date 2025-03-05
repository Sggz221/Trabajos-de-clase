package dev.samuel.models

import java.time.LocalDate

data class Estudiante(
    val id: Long,
    val nombre: String,
    val calificacion: Double,
    val ultimaConvocatoria: Boolean,
    val fechaMatriculacion: LocalDate,
    val fechaNacimiento: LocalDate
)

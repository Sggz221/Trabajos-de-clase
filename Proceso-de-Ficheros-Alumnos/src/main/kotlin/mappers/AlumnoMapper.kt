package dev.samuel.mappers

import dev.samuel.DTO.AlumnoDTO
import dev.samuel.models.Alumno
import java.time.LocalDate

fun Alumno.toDto() = AlumnoDTO(
    id = id,
    nombre = nombre,
    createdAt = createdAt.toString(),
    tipo = tipo.toString(),
    edad = edad
)

fun AlumnoDTO.toModel() = Alumno(
    id = id,
    nombre = nombre,
    createdAt = LocalDate.parse(createdAt),
    tipo = Alumno.Tipo.valueOf(tipo.uppercase()),
    edad = edad
)
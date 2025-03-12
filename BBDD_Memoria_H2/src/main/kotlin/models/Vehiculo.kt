package models

import java.time.LocalDate
import java.util.UUID

class Vehiculo(
    val id: Long = 0, // Controlado por la BBDD
    val guuid: UUID = UUID.randomUUID(), // Controlado por el programa
    val matricula: String,
    val marca: String,
    val modelo: String,
    val fechaMatriculacion: LocalDate,
    val permisoActivo: Boolean,
    val tipo: Tipo
)


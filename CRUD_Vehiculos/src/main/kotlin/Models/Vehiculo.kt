package dev.samuel.Models

import java.time.LocalDateTime

abstract class Vehiculo(
    var id: Int = ID,
    val matricula: String,
    val motor: Motor,
    var km: Int,
    var anoMatricula: Int,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var esBorrado: Boolean = false
) {
    abstract fun copy(): Vehiculo

    companion object {
        private var ID: Int = 0
    }
}
package dev.samuel.Models

interface MotorElectrico: Motor{
    val capacidadBateriaKWh: Int
    fun recargar(){
    }
}
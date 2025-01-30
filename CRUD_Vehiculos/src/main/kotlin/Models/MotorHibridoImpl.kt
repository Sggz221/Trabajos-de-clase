package dev.samuel.Models

class MotorHibridoImpl(
    override val consumo: Double = (7..12).random().toDouble(),
    override val capacidadBateriaKWh:Int = (100..120).random()): MotorHibrido
{
    override fun arrancar() {
        println("El motor hibrido ha arrancado")
    }
    override fun toString(): String {
        return "MotorHibrido=(consumo=$consumo, capacidadBateriaKWh=$capacidadBateriaKWh)"
    }
}
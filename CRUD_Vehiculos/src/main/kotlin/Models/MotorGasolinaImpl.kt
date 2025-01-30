package dev.samuel.Models

class MotorGasolinaImpl (override val consumo: Double = (7..12).random().toDouble()): MotorGasolina {
    override fun arrancar() {
        println("El motor hibrido ha arrancado")
    }
    override fun toString(): String{
        return "MotorGasolina=(consumo=$consumo)"
    }
}
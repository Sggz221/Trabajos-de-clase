package dev.samuel.Models

class MotorElectricoImpl(override val capacidadBateriaKWh: Int = (100..120).random()) : MotorElectrico {
    override fun arrancar() {
        println("El motor electrico ha arrancado")
    }
    override fun toString(): String {
        return "MotorElectrico=(capacidadKWh= $capacidadBateriaKWh)"
    }

}
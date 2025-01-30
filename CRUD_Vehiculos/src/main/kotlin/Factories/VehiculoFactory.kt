package dev.samuel.Factories

import dev.samuel.Models.*
import org.lighthousegames.logging.logging
import kotlin.random.Random

val logger = logging()
class VehiculoFactory {

    fun vehiculoRandom () : Vehiculo {
        logger.debug { "Generando vehículo" }
        var numeros: Int = (0..9999).random()
        fun getRandomLetra(): Char{
            val letras:String = "BCDFGHJKLMNPRSTVWXYZ"
            return letras[(0..letras.length-1).random()]
        }

        val matricula: String = numeros.toString() + getRandomLetra() + getRandomLetra() + getRandomLetra()
        val km: Int = (0..999999).random()
        val anoMatricula: Int = (1970..2025).random()

        val randomType = (1..10).random()
        val randomMotor = (1..10).random()

        return if (randomType >= 5) {
            when (randomMotor) {
                in 1..3 -> Coche(matricula, km, MotorGasolinaImpl(), anoMatricula)
                in 4..6 -> Coche(matricula, km, MotorElectricoImpl(), anoMatricula)
                else -> Coche(matricula, km, MotorHibridoImpl(), anoMatricula)
            }
        }
        else{
            when (randomMotor) {
                in 1..3 -> Moto(matricula, km, MotorGasolinaImpl(), anoMatricula)
                in 4..6 -> Moto(matricula, km, MotorElectricoImpl(), anoMatricula)
                else -> Moto(matricula, km, MotorHibridoImpl(), anoMatricula)
            }
        }
    }
}
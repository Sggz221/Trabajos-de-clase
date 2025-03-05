package dev.samuel

import dev.samuel.validator.ValidatorNumeroTarjeta
fun main() {
    val validatorTarjeta = ValidatorNumeroTarjeta()
    println("Introduce el número de tarjeta a ser validada: ")
    val numTarjeta = readln()
    println("Es válida la tarjeta: $numTarjeta?: ${validatorTarjeta.validarTarjeta(numTarjeta)}")
}

package dev.samuel

import dev.samuel.validator.ValidatorNumeroTarjeta
fun main() {
    val validatorTarjeta = ValidatorNumeroTarjeta()
    val numTarjeta = "4137 8947 1175 5904".trim() // Lo hago así para que sea más facil de leer la tarjeta de crédito.
    println("Es válida la tarjeta: $numTarjeta?: ${validatorTarjeta.validarTarjeta(numTarjeta)}")
}

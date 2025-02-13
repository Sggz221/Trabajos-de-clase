package validator

import dev.samuel.validator.ValidatorNumeroTarjeta
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ValidatorNumeroTarjetaTest {
    private val validator = ValidatorNumeroTarjeta()

    @Test
    @DisplayName("Validar Tarjeta Correcta")
    fun validarTarjetaCorrecta(){
        assertTrue(validator.validarTarjeta("4137 8947 1175 5904".trim()))
    }

    @Test
    @DisplayName("Validar Tarjeta con un dígito más")
    fun validarTarjetaUnDigitoMas(){
        assertTrue(validator.validarTarjeta("4137 8947 1175 5904 1".trim()))
    }

    @Test
    @DisplayName("Validar Tarjeta con un dígito menos")
    fun validarTarjetaUnDigitoMenos(){
        assertTrue(validator.validarTarjeta("4137 8947 1175 590".trim()))
    }

    @Test
    @DisplayName("Validar Tarjeta con una letra")
    fun validarTarjetaConLetra(){
        assertTrue(validator.validarTarjeta("4137 8947 1175 5904 a".trim()))
    }
}
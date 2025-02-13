package dev.samuel.validator

class ValidatorNumeroTarjeta {
    fun validarTarjeta(numeroTarjeta: String): Boolean {
        val tarjetaCreditoRegex = Regex("^/d{16}$") // Dieciséis dígitos
        var numerosTarjetaList = mutableListOf(0)

        if (tarjetaCreditoRegex.matches(numeroTarjeta)) {
            for(i in numeroTarjeta.indices){
                numerosTarjetaList.add(i.toString().toInt())
            }
        }
        numerosTarjetaList = sumaMultiplicacion(numerosTarjetaList)
        var sum = 0
        for (i in numerosTarjetaList.indices){
            sum += numerosTarjetaList[i]
        }
        return sum % 10 == 0 //Comprueba si acaba en cero el resultado. Si acaba en cero es válido, si no, no lo es
    }
    /**
    * Multiplica por dos cada dos dígitos de una tarjeta de crédito en una lista. Luego revisa si los elementos tienen 2 cifras y suma sus cifras si se cumple.
     * @return Lista con digitos de una cifra
    * */
    private fun sumaMultiplicacion(intList: MutableList<Int>): MutableList<Int> {
        val aux = MutableList(intList.size) { 0 }
        var scope = 0
        for (i in intList.indices step 2){
            aux[scope] = intList[i] * 2
            scope++
        }
        for (i in intList.indices step 2){
            if (intList[i] >= 10) reduccionUnidades(i)
        }
        return aux
    }
    /**
    * Aplicando recursividad, si un número tiene 2 cifras las suma y vuelve a aplcar la comprobación. Si solo tiene una cifra devuelve el numero.
    * */
    private fun reduccionUnidades(number: Int): Int{
        var aux = number
        if(number >= 10){
            val numString = number.toString()
            aux = numString[0].toString().toInt() + numString[1].toString().toInt()
            return reduccionUnidades(aux)
        }
        else {
            return aux
        }
    }
}
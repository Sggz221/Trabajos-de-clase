package dev.samuel.Extensions

import dev.samuel.Models.Coche
import dev.samuel.Models.ModoOrdenamiento
import dev.samuel.Models.MotorGasolinaImpl
import dev.samuel.Models.Vehiculo
import java.util.function.IntPredicate

inline fun<T> Array<T?>.myCount(predicate: (T) -> Boolean = {true}): Int {
    var count = 0
    for (item in this) {
        if(item != null && predicate(item)) count ++
    }
    return count
}

fun<T> Array<T?>.myIndexOf(condition: (T?) -> Boolean): Int {
    for(index in this.indices){
        if(condition(this[index])){
            return index
        }
    }
    return -1
}


inline fun <reified T> Array<T?>.myFilter(predicate: (T) -> Boolean): Array<T> { //Queremos filtrar los elementos de un array que cumplen una condición
    val result =    //Creamos el array que después devolveremos con los elementos que cumplen el predicado. Su tamaño es el recuento de aquellos que lo cumplen.
        Array<T?>(this.myCount(predicate)) { null }
    var index = 0
    for (item in this) {    //Recorremos el array original
        if (item != null && predicate(item)) {
            result[index] = item    //Y si un elemento es distinto de nulo y cumple la condición, lo incluímos en el array que devolvemos
            index++
        }
    }
    return result as Array<T>
}

fun<T> Array<T?>.getIndex(condition: (T?) -> Boolean): Int {
    for (i in 0..this.size - 1) {
        if (condition(this[i])) return i
    }
    return -1
}

fun<T> Array<T?>.myForEach(action: (T) -> Unit) {
    for (item in this) {
        if(item != null){
            action(item)
        }
    }
}

fun<T> Array<T?>.media(predicate: (T) -> Boolean): Double {
    var suma = 0.0
    var count = 0
    this.forEach {
        if (it != null && predicate(it)){
            suma += (it as Number).toDouble()
            count++
        }
    }
    return if(count == 0) 0.0 else (suma / count)
}

fun<T> Array<T>.myFirstOrNull(predicate: (T)-> Boolean): T? {
    for (item in this) {
        if(predicate(item)) return item
    }
    return null
}

fun<T> Array<T>.myLastOrNull(predicate: (T)-> Boolean): T? {
    for (item in this.reversed()) {
        if(predicate(item)) return item
    }
    return null
}

fun<T> Array<T?>.myMaxBy(selector: (T) -> Int, predicate: (T) -> Boolean): T? {
    var max: Int? = null
    var maxItem: T? = null
    for (item in this) {
        if (item != null && predicate(item)) {
            val aux = selector(item)
            if (max == null || aux > max) {
                maxItem = item
                max = aux
            }
        }
    }
    return maxItem
}

fun<T> Array<T?>.myMinBy(selector: (T) -> Int, predicate: (T) -> Boolean): T? {
    var max: Int? = null
    var maxItem: T? = null
    for (item in this) {
        if (item != null && predicate(item)) {
            val aux = selector(item)
            if (max == null || aux < max) {
                maxItem = item
                max = aux
            }
        }
    }
    return maxItem
}

inline fun<reified T> Array<T?>.redimensionar(modo: ModoRedimension): Array<T?> {
    var newSize: Int = 0
    if (modo == ModoRedimension.AUMENTAR) newSize = this.size + this.size/3 else this.size - this.size/3

    val newArray = arrayOfNulls<T?>(newSize)
    var scope = 0
    for (item in this) {
        if(item != null) {
            newArray[scope] = item
            scope++
        }
    }
    return newArray
}

inline fun<reified T> Array<T?>.mySortedBy(selector: (T) -> Int, modo: ModoOrdenamiento = ModoOrdenamiento.DESCENDENTE): Array<T> {
    val result = this.myFilter { true }
    val compare: (Int, Int) -> Boolean =
        if (modo == ModoOrdenamiento.ASCENDENTE) { a, b -> a > b } else { a, b -> a < b }

    for (i in result.indices) {
        for (j in 0..<result.size - 1 - i) {
            if (compare(selector(result[j]), selector(result[j + 1]))) {
                result[j] = result[j + 1].also { result[j + 1] = result[j] }
            }
        }
    }
    return result
}


enum class ModoRedimension {
    AUMENTAR, DISMINUIR
}

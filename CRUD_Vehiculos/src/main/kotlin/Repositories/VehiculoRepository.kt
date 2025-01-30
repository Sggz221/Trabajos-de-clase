package dev.samuel.Repositories

import dev.samuel.Models.ModoOrdenamiento
import dev.samuel.Models.Vehiculo

interface VehiculoRepository: CrudRepository<Vehiculo, Int>{
    fun findBy (condition: (Vehiculo) -> Boolean = {true}) : Array<Vehiculo>
    fun average (condition: (Vehiculo) -> Boolean ) : Number
    fun count (condition: (Vehiculo) -> Boolean = {true}) : Int
    fun maxBy (selector: (Vehiculo) -> Int = {0}, condition: (Vehiculo) -> Boolean = {true}) : Vehiculo?
    fun minBy (selector: (Vehiculo) -> Int = {0}, condition: (Vehiculo) -> Boolean = {true}) : Vehiculo?
    fun sortedBy (
        selector: (Vehiculo) -> Int,
        mode: ModoOrdenamiento = ModoOrdenamiento.DESCENDENTE
    ): Array<Vehiculo>
}
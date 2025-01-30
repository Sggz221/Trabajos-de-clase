package dev.samuel.Repositories

import dev.samuel.Extensions.*
import dev.samuel.Models.ModoOrdenamiento
import dev.samuel.Models.Vehiculo
import org.lighthousegames.logging.logging
import java.time.LocalDateTime
import kotlin.collections.sortedBy

class VehiculoRepositoryImpl: VehiculoRepository {
    private val logger = logging()
    private val MAX_VEHICULOS: Int = 10
    private var vehiculos: Array<Vehiculo?> = Array<Vehiculo?>(MAX_VEHICULOS) { null }
    private var nextID: Int = -1 // Para que los ID empiecen desde 0

    private fun generarID(): Int{
        nextID++
        return nextID
    }

    override fun findBy(condition: (Vehiculo) -> Boolean): Array<Vehiculo> {
        logger.debug { "Buscando vehiculos..." }
        return vehiculos.myFilter { condition(it) }
    }

    override fun average(condition: (Vehiculo) -> Boolean): Double {
        logger.debug { "Buscando vehiculos..." }
        return vehiculos.media { condition(it) }
    }

    override fun count(condition: (Vehiculo) -> Boolean): Int {
        logger.info{"Contando vehiculos"}
        return vehiculos.count {condition(it!!)}
    }

    override fun maxBy(selector: (Vehiculo) -> Int, condition: (Vehiculo) -> Boolean): Vehiculo? {
        logger.info{"Calculando maximo"}
        return vehiculos.myMaxBy(selector, condition)
    }

    override fun minBy(selector: (Vehiculo) -> Int, condition: (Vehiculo) -> Boolean): Vehiculo? {
        logger.info{"Calculando minimo"}
        return vehiculos.myMinBy(selector, condition)
    }

    override fun sortedBy(selector: (Vehiculo) -> Int, mode: ModoOrdenamiento): Array<Vehiculo> {
        logger.info{"Ordenando vehiculos..."}
        return vehiculos.mySortedBy(selector, mode)
    }

    override fun findAll(): Array<Vehiculo> {
        logger.info{"Obteniendo todos los vehiculos"}
        return vehiculos.myFilter { true }
    }

    override fun findById(id: Int): Vehiculo? {
        logger.info{"Buscando vehiculo por id: $id"}
        return vehiculos.myFilter{ it.id == id }.myFirstOrNull{true}
    }

    override fun save(item: Vehiculo): Vehiculo {
        logger.debug { "Guardando vehiculo..." }
        val newVehiculo = item.copy()
        newVehiculo.id = generarID()
        newVehiculo.createdAt = LocalDateTime.now()
        newVehiculo.updatedAt = LocalDateTime.now()

        var nextindex: Int = vehiculos.myIndexOf { it == null }

        if(nextindex == -1) {
            logger.info{"Redimensionando el array..."}
            vehiculos = vehiculos.redimensionar(ModoRedimension.AUMENTAR)
            nextindex = vehiculos.myIndexOf { it == null }
        }
        vehiculos[nextindex] = newVehiculo

        return newVehiculo.also { logger.info{"✅ Vehiculo guardado con exito"} }
    }

    override fun update(id: Int, item: Vehiculo): Vehiculo? {
        logger.debug{"Actualizando vehiculo..."}
        var vehiculo = this.findById(id)

        if (vehiculo != null) {
            vehiculo = vehiculo.copy()
            vehiculo.updatedAt = LocalDateTime.now()
            vehiculos[id] = vehiculo
            return vehiculo.also { logger.info{"🔄 Vehiculo actualizado"} }
        }
        logger.info{"Vehiculo no encontrado"}
        return null
    }

    override fun delete(id: Int): Vehiculo? {
        logger.debug{"Borrando vehiculo..."}
        var vehiculo = this.findById(id)

        if (vehiculo != null) {
            vehiculo.updatedAt = LocalDateTime.now()
            vehiculo.esBorrado = true
            logger.info{"❌ Vehiculo borrado"}
        }
        return null.also { logger.info{"⛔ Vehiculo no encontrado"} }
    }

}
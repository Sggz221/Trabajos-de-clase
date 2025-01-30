package dev.samuel

import com.github.ajalt.mordant.rendering.TextColors
import dev.samuel.Factories.VehiculoFactory
import dev.samuel.Models.*
import dev.samuel.Repositories.VehiculoRepository
import dev.samuel.Repositories.VehiculoRepositoryImpl
import java.awt.TextComponent

fun main() {
    // Inicializando el repositorio y el factory de vehiculos
    val repo = VehiculoRepositoryImpl()
    val factory = VehiculoFactory()

    // Creando 7 vehiculos de prueba y guardandolos en el array
    val v1 = factory.vehiculoRandom()
    val v2 = factory.vehiculoRandom()
    val v3 = factory.vehiculoRandom()
    val v4 = factory.vehiculoRandom()
    val v5 = factory.vehiculoRandom()
    val v6 = factory.vehiculoRandom()
    val v7 = factory.vehiculoRandom()


    repo.save(v1)
    repo.save(v2)
    repo.save(v3)
    repo.save(v4)
    repo.save(v5)
    repo.save(v6)
    repo.save(v7)

    println(TextColors.brightBlue("Creando 4 vehiculos mas..."))
    val v8 = factory.vehiculoRandom()
    val v9 = factory.vehiculoRandom()
    val v10 = factory.vehiculoRandom()
    val v11 = factory.vehiculoRandom()
    println(TextColors.brightBlue("Guardando 4 vehiculos..."))
    repo.save(v8)
    repo.save(v9)
    repo.save(v10)
    repo.save(v11)
    println(TextColors.green("Mostrando todos los vehiculos"))
    repo.findAll().forEach { println(it) }

    println(TextColors.brightBlue("Vamos a buscar un vehiclo existente y otro que no exista para mostrar los resultados"))
    println(repo.findById(0))
    println(repo.findById(99))

    println(TextColors.brightBlue("Vamos a actualizar un vehiclo existente y otro que no exista para mostrar los resultados"))
    repo.findById(0)?.let { repo.update(0, it) }
    repo.findById(99)?.also { repo.update(99, it) }

    println(TextColors.brightBlue("Todos los vehiculos que sean motos y tengan un motor de gasolina:"))
    repo.findBy { it.motor is MotorGasolina && it is Moto }.forEach { println(it) }

    println(TextColors.brightBlue("Todos los vehiculos que sean Coches"))
    repo.findBy { it is Coche }.forEach { println(it) }

    println(TextColors.brightBlue("El coche mas nuevo con motor hibrido y la moto mas antigua de gasoliona"))
    println(repo.maxBy({ it.anoMatricula }, { it is Coche && it.motor is MotorHibrido }))
    println(repo.minBy({ it.anoMatricula }, { it is Coche && it.motor is MotorGasolina }))

    println(TextColors.blue("Vehículos ordenados por kilometros en orden ascendente"))
    repo.sortedBy({it.km}).forEach { println(it) }
}

package dev.samuel

import dev.samuel.DTO.AlumnoDTO
import dev.samuel.mappers.toModel
import java.io.File

fun main() {
    // Lectura básica de fichero
    val ficheroAlumnos = File("alumnos.csv")

    if (ficheroAlumnos.exists() && ficheroAlumnos.canRead()) println("El fichero existe y es accesible")
    else throw IllegalArgumentException("El fichero no existe o no es accesible")

    val alumnos = ficheroAlumnos.readLines().drop(1) // Se salta la cabecera porque la primera fila no contiene informacion
        .map{line -> line.split(",") } // Se indica el separador, en este caso la coma
        .map{ alumno ->
            println(alumno)
            AlumnoDTO(
                id = alumno[0].trim().toInt(),
                nombre = alumno[1],
                createdAt = alumno[2],
                tipo = alumno[3],
                edad = alumno[5].toInt()
            ).toModel() // Se convierte a modelo
        }
    /*
    Alumno más mayor
    Alumno más joven
    Media de edad de alumnos
    Media de longitud de nombre
    Listado de agrupados por edad
    Agrupados por edad, numero de alumnos
    Agrupados por edad, obtener la longitud de nombre.
    Agrupados por edad, obtener el nombre mas largo.
    */

    val alumnoMasMayor = alumnos.maxBy { it.edad }
    println(alumnoMasMayor)

    val alumnoMasPeque = alumnos.minBy { it.edad }
    println(alumnoMasPeque)

    var sum = 0
    alumnos.forEach{sum += it.edad}
    println("Media de edad de los alumnos: " + sum/alumnos.size)

    sum = 0
    alumnos.forEach{sum += it.nombre.length}
    println("Media de longitud de nombre de los alumnos: " + sum/alumnos.size)

    println("Listado de alumnos agrupados por edad:")
    println(alumnos.groupBy{it.edad})

    println("Listado de alumnos agrupados por edad:")

}
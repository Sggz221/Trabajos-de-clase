package dev.samuel.repositories

import dev.samuel.models.Estudiante
import java.sql.DriverManager

class EstudianteRepositoryImpl: EstudianteRepository<Long, Estudiante> {

    val url = "jdbc:sqlite:ejemplo.db"
    private val listEstudiantes = mutableMapOf<Long, Estudiante>()

    init{
        val conexion = DriverManager.getConnection(url)
        val sentencia = conexion.prepareStatement("CREATE TABLE IF NOT EXISTS ESTUDIANTES (id INTEGER, nombre TEXT, calificacion DOUBLE, ultimaConvocatoria INTEGER, fechaMatriculacion TEXT, fechaNacimiento TEXT)")
        conexion.close()
    }

    override fun create(entity: Estudiante): Estudiante {
        TODO()
    }

    override fun update(id: Long, entity: Estudiante): Estudiante? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): Estudiante? {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Estudiante> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): Estudiante? {
        TODO("Not yet implemented")
    }
}
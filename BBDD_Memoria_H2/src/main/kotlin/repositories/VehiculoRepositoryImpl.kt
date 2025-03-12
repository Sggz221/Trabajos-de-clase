package repositories

import models.Vehiculo
import org.lighthousegames.logging.logging
import java.sql.DriverManager
import java.util.*

class VehiculoRepositoryImpl: VehiculoRepository {
    private val url = "jdbc:h2:mem:vehiculos;DB_CLOSE_DELAY=-1" // DB cloase delay a -1 para que se borre solo cuando finalice el programa
    val logger = logging()

    override fun getAll(): List<Vehiculo> {
        logger.debug { "Obteniendo todos los vehiculos de la Base de datos" }

        val vehiculos = mutableListOf<Vehiculo>()

        //Se abre la conexion y se comprueba que se haya hecho de manera efectiva
        val conexion = DriverManager.getConnection(url)
        if (conexion == null) logger.error{"Error: No se pudo conectar con la base de datos"}
        else logger.debug { "Conexion establecida" }

        // Se crea la consulta, en este caso queremos todos
        val query = """SELECT * FROM vehiculos"""
        val statement = conexion.prepareStatement(query)
        val results = statement.executeQuery()

    }

    override fun getByUuid(uuid: UUID): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun save(entity: Vehiculo): Vehiculo {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun update(id: Long, entity: Vehiculo): Vehiculo? {
        TODO("Not yet implemented")
    }
}
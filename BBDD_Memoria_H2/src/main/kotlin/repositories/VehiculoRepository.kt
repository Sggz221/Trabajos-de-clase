package repositories

import models.Vehiculo
import java.util.UUID

interface VehiculoRepository: CrudRepository<Long, UUID, Vehiculo> {

}
package repositories

interface CrudRepository<ID, UUID, T> {
    fun getAll(): List<T>
    fun getByUuid(uuid: UUID): T?
    fun getById(id: ID): T?
    fun save(entity: T): T
    fun delete(id: ID): T?
    fun update(id: ID, entity: T): T?
}
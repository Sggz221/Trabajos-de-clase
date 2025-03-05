package dev.samuel.repositories

interface CrudRepository<ID, T> {
    fun create(entity: T): T
    fun update(id: ID, entity: T): T?
    fun delete(id: ID): T?
    fun getAll(): List<T>
    fun getById(id: ID): T?
}
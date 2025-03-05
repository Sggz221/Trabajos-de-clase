package dev.samuel.repositories

import dev.samuel.models.Estudiante

interface EstudianteRepository<ID, T>: CrudRepository<Long, Estudiante>
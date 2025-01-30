package dev.samuel.Models

class Coche(
    matricula:String,
    km: Int,
    motor: Motor,
    anoMatricula:Int
): Vehiculo(matricula= matricula,motor = motor, km= km, anoMatricula= anoMatricula) {
    override fun toString(): String {
        return "Coche(id= $id, matricula= $matricula, motor= $motor, km= $km, anoMatricula= $anoMatricula, createdAt= $createdAt, updatedAt= $updatedAt, esBorrado= $esBorrado)"
    }

    override fun copy(): Vehiculo {
        return Coche(matricula, km, motor, anoMatricula)
    }
}
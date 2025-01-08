package pt.iade.arpefitness.models

import java.io.Serializable

class UserData(
    val id: Int,
    var name: String,
    var email: String,
    var password: String,
    var gender: String = "",
    var dob: Int = 0,
    var weight: Int = 0,
    var height: Int = 0,
    var objective: String,
    var level: String = "",
    var includeCardio: Boolean
) : Serializable {

    // Implementação do método copy
    fun copy(
        id: Int = this.id,
        name: String = this.name,
        email: String = this.email,
        password: String = this.password,
        gender: String = this.gender,
        dob: Int = this.dob,
        weight: Int = this.weight,
        height: Int = this.height,
        objective: String = this.objective,
        level: String = this.level,
        includeCardio: Boolean = this.includeCardio
    ): UserData {
        // Retorna uma nova instância de UserData com os valores passados
        return UserData(
            id, name, email, password, gender, dob, weight, height, objective, level, includeCardio
        )
    }
}

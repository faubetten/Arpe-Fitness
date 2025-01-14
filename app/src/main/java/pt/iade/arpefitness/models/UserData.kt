package pt.iade.arpefitness.models

import java.io.Serializable
import java.time.LocalDate

class UserData(
    val id: Int,
    var name: String,
    var email: String,
    var password: String,
    var gender: String = "",
    var dob: LocalDate? = null,
    var weight: Int = 0,
    var height: Int = 0,
    var objective: String,
    var level: String = ""
) : Serializable {

    override fun toString(): String {
        return "UserData(id=$id, name='$name', email='$email', gender='$gender', dob=$dob, weight=$weight, height=$height, objective='$objective', level='$level')"
    }

    // Implementação do método copy
    fun copy(
        id: Int = this.id,
        name: String = this.name,
        email: String = this.email,
        password: String = this.password,
        gender: String = this.gender,
        dob: LocalDate? = null,
        weight: Int = this.weight,
        height: Int = this.height,
        objective: String = this.objective,
        level: String = this.level
    ): UserData {
        // Retorna uma nova instância de UserData com os valores passados
        return UserData(
            id, name, email, password, gender, dob, weight, height, objective, level
        )
    }
}

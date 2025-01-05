package pt.iade.arpefitness.models

import java.io.Serializable

class UserData (
    var height: Int = 0,
    var weight: Int = 0,
    var age: Int = 0,
    var gender: String = "",
    var level: String = "",
    var objective: String = "",
    var includeCardio: Boolean = false
): Serializable
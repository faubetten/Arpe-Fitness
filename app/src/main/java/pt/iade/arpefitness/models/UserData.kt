package pt.iade.arpefitness.models

import java.io.Serializable

class UserData (
    var name : String,
    var email : String,
    var password : String,
    var gender: String = "",
    var dob: Int = 0,
    var weight: Int = 0,
    var height: Int = 0,
    var objective: String,
    var level: String = "",
    var includeCardio: Boolean = false
): Serializable {

}
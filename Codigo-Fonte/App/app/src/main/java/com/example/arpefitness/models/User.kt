package com.example.arpefitness.models

import java.io.Serializable
import java.net.URI

class User(
    val id: Int,
    var username: String,
    var email: String,
    var password: String,
    var age : Int,
    var height : Int,
    var weight : Int,
    var image: URI,
    var savedWorkouts : MutableList<Workout> = mutableListOf()
): Serializable {
    fun isLogged(): Boolean {
        return false
    }

    fun isSavedWorkout(workout: Workout): Boolean {
        return savedWorkouts.contains(workout)
    }

    fun saveWorkout(workout: Workout) {
        savedWorkouts.add(workout)
    }

    fun removeWorkout(workout: Workout) {
        savedWorkouts.remove(workout)
    }

    fun resetPassword(newPassword: String) {
        password = newPassword
    }

    fun updateProfile(username: String, email: String, age: Int, height: Int, weight: Int) {
        this.username = username
        this.email = email
        this.age = age
        this.height = height
        this.weight = weight
    }

    fun updateImage(image: URI) {
        this.image = image
    }


}



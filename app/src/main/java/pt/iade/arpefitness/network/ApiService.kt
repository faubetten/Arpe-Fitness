package pt.iade.arpefitness.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

// Representa o corpo da requisição para login
data class LoginRequest(
    val email: String,
    val password: String
)

// Representa a resposta do servidor ao fazer login
data class LoginResponse(
    val userId: Int,
    val userName: String,
    val userEmail: String,
    val token: String
)

interface ApiService {
    @POST("api/users/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}

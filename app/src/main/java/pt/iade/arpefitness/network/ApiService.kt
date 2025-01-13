package pt.iade.arpefitness.network

import pt.iade.arpefitness.models.Category
import pt.iade.arpefitness.models.UserRequest
import pt.iade.arpefitness.models.UserResponse
import pt.iade.arpefitness.models.UserUpdateRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

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

    // Endpoint para login
    @POST("api/users/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    // Endpoint para obter categorias de exercícios
    @GET("categories")
    fun getCategories(): Call<List<Category>>

    // Endpoint para criar um novo usuário
    @POST("api/users/create")
    fun createUser(@Body request: UserRequest): Call<UserResponse>

    // Endpoint para atualizar informações de um usuário
    @PUT("api/users/{id}/update")
    fun updateUser(
        @Path("id") userId: Int,
        @Body request: UserUpdateRequest
    ): Call<UserResponse>

    // Endpoint para buscar informações de um usuário pelo ID
    @GET("api/users/{id}")
    fun getUserById(@Path("id") userId: Int): Call<UserResponse>



}

package pt.iade.arpefitness.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pt.iade.arpefitness.models.Category
import pt.iade.arpefitness.network.ApiService
import pt.iade.arpefitness.network.RetrofitClient
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class CategoryViewModel : ViewModel() {
    private val apiService: ApiService = RetrofitClient.create(ApiService::class.java)

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> get() = _categories

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage


    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response: Response<List<Category>> = apiService.getCategories().execute()
                if (response.isSuccessful) {
                    _categories.value = response.body() ?: emptyList()
                } else {
                    _errorMessage.value = "Error: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = e.localizedMessage ?: "An unexpected error occurred"
            }
        }
    }

}

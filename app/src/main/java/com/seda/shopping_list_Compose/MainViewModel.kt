package com.seda.shopping_list_Compose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _categoriwsState= mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoriwsState


    init {
        fetchCategories()
    }
    private  fun fetchCategories(){
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()

                _categoriwsState.value =_categoriwsState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            }catch (e:Exception){
                _categoriwsState.value = _categoriwsState.value.copy(
                    loading = false,
                    error= "Error fetching categories ${e.message}",
                    )

            }
        }
    }









data class RecipeState(
    val loading:Boolean=true,
    val list:List<Category> = emptyList(),
    val error:String?=null
)


}
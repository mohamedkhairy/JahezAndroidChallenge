package net.jahez.jahezchallenge.presentation.ui.resturant

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import net.jahez.jahezchallenge.domain.core.Resource
import net.jahez.jahezchallenge.domain.entity.Restaurant
import net.jahez.jahezchallenge.domain.useCases.RestaurantUseCase
import javax.inject.Inject

@HiltViewModel
class RestaurantListViewModel @Inject constructor (private val restaurantUseCase: RestaurantUseCase): ViewModel() {

    val restaurantList: MutableState<List<Restaurant>> = mutableStateOf(ArrayList())
    val loading: MutableState<Boolean> = mutableStateOf(false)

//    init {
//        getRestaurantData()
//    }

    fun getRestaurantData(){
        viewModelScope.launch(Dispatchers.IO) {
            restaurantUseCase.invoke().collect {
                when(it){
                    is Resource.Loading -> {
                        loading.value = true
                    }
                    is Resource.Success -> {
                        loading.value = false
                        it.data?.let{list -> restaurantList.value = list}
                    }
                    is Resource.Error -> {
                        it.data?.let{list -> restaurantList.value = list}
                        loading.value = false
                    }
                }
            }
        }
    }

}
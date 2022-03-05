package net.jahez.jahezchallenge.presentation.ui.resturant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.jahez.jahezchallenge.presentation.ui.components.RestaurantCard
import net.jahez.jahezchallenge.presentation.ui.components.SpinnerView
import okhttp3.internal.wait

@AndroidEntryPoint
class RestaurantListFragment: Fragment() {
    private val viewModel: RestaurantListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
           setContent {
               val restaurantList = viewModel.restaurantList.value
               val isLoading = viewModel.loading.value

               Column(modifier = Modifier
                   .fillMaxSize()
                   .background(Color.White)
               ) {
                   SpinnerView(){}

                   Box(modifier = Modifier
                       .fillMaxSize()
                   ) {

                       LazyColumn{
                           itemsIndexed(items = restaurantList){index, restaurant ->
                               RestaurantCard(restaurant = restaurant) {}
                           }
                       }

                       if (isLoading)
                           CircularProgressIndicator(modifier = Modifier.align(Alignment.TopCenter))

                   }
               }


           }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRestaurantData()
    }

}
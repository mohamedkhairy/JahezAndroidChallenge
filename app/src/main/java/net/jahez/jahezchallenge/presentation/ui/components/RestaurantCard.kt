package net.jahez.jahezchallenge.presentation.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import coil.transform.RoundedCornersTransformation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.domain.entity.Restaurant

@ExperimentalCoroutinesApi
@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    onClick: () -> Unit
){

    Card(shape = MaterialTheme.shapes.small,
    modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(8.dp)
        .clickable(onClick = onClick),
        elevation = 8.dp) {
        
        Row(
            modifier = Modifier.background(Color.LightGray)
        ) {
            restaurant.image?.let{RestaurantImage(imageUrl = it)}

//            Row(modifier = Modifier
//                .fillMaxWidth()
//                .padding(5.dp)) {

            Column(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(start = 8.dp),
                verticalArrangement = Arrangement.Center
                ) {

                Text(
                    text = stringResource(id = R.string.restaurant_name , restaurant.name),
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 16.sp
                )

                Text(
                    text = stringResource(id = R.string.restaurant_open , restaurant.hours),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    color = Color.Black,
                    fontSize = 14.sp

                )

                Text(
                    text = stringResource(id = R.string.restaurant_rate , "${restaurant.rating}"),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    color = Color.Black,
                    fontSize = 14.sp

                )
            }

//            }
        }

    }

}

@Composable
fun RestaurantImage(imageUrl: String){

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .size(Size.ORIGINAL)
            .crossfade(true)
            .crossfade(200)
            .build()

    )

    if (painter.state is AsyncImagePainter.State.Loading) {
        CircularProgressIndicator()
    }

    Image(
        painter = painter,
        contentDescription = stringResource(R.string.restaurant_image_desc),
        modifier = Modifier
            .fillMaxWidth(0.30f)
            .fillMaxHeight()
            .padding(8.dp)
    )

}
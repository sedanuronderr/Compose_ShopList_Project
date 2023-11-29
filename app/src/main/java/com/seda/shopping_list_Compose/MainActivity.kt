package com.seda.shopping_list_Compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seda.shopping_list_Compose.ui.theme.Compose_remember_recompotionTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_remember_recompotionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                      RecipeScreen()
                }
            }
        }
    }
}

@Composable
fun CaptainGame() {

    val treasuresFound= remember{mutableStateOf(0)}
    val direction = remember{mutableStateOf("North")}
    val stormOrTreasure = remember{ mutableStateOf("") }


    Column {
        Text(text = "Treasures Found: ${treasuresFound.value}")
        Text(text = "Current Direction: ${direction.value}")
        Text(text = "StormOrTreasure: ${stormOrTreasure.value}")

          Button(onClick = {
               direction.value= "East"

              if(Random.nextBoolean()){
                  treasuresFound.value +=1
              }

          }) {
                Text(text = "Sail East")
          }

        Button(onClick = {
            direction.value= "West"

            if(Random.nextBoolean()){
                treasuresFound.value +=1
            }

        }) {
            Text(text = "Sail West")
        }

        Button(onClick = {
            direction.value= "North"

            if(Random.nextBoolean()){
                treasuresFound.value +=1
            }

        }) {
            Text(text = "Sail North")
        }
        Button(onClick = {
            direction.value= "South"

            if(Random.nextBoolean()){
                treasuresFound.value +=1
            }

        }) {
            Text(text = "Sail South")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_remember_recompotionTheme {
    }
}
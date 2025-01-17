package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}
@Composable
fun CaptainGame(){
    val treasuredFound = remember{ mutableStateOf(0)}
    val direction = remember { mutableStateOf("North") }
    val stormOrTreasure = remember { mutableStateOf("") }

    Column {
        Text(text = "Treasures Found: ${treasuredFound.value}")
        Text(text = "Current Direction: ${direction.value}")
        Text(text = stormOrTreasure.value)
        Button(onClick = {
            direction.value = "East"
            if (Random.nextBoolean()){
                treasuredFound.value +=1
                stormOrTreasure.value = "We Found A Treasure!!!"
            }else{
                stormOrTreasure.value = "Storm Head!!!"
            }
        }){
           Text("Sail East")
        }
        Button(onClick = {
            direction.value = "West"
            if (Random.nextBoolean()){
                treasuredFound.value +=1
                stormOrTreasure.value = "We Found A Treasure!!!"
            }else{
                stormOrTreasure.value = "Storm Head"
            }
        }){
            Text("Sail West")
        }
        Button(onClick = {
            direction.value = "North"
            if (Random.nextBoolean()){
                treasuredFound.value +=1
                stormOrTreasure.value = "We Found A Treasure!!!"
            }else{
                stormOrTreasure.value = "Storm Head"
            }
        }){
            Text("Sail North")
        }
        Button(onClick = {
            direction.value = "South"
            if (Random.nextBoolean()){
                treasuredFound.value +=1
                stormOrTreasure.value = "We Found A Treasure!!!"
            }else{
                stormOrTreasure.value = "Storm Head"
            }
        }){
            Text("Sail South")
        }
    }
}

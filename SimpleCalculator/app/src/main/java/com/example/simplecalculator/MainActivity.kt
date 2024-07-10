package com.example.simplecalculator

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecalculator.ui.theme.SimpleCalculatorTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val customTextStyle = androidx.compose.ui.text.TextStyle(
                fontFamily = FontFamily.Monospace,
                color = Color.Unspecified
            )
            var num1 by remember{
                mutableStateOf("")
            }
            var num2 by remember{
                mutableStateOf("")
            }
            var outputValue  by remember{ mutableStateOf("") }
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Simple Calculator", style = customTextStyle)
                Spacer(modifier = Modifier.height(25.dp))
                TextField(value = num1, onValueChange = {
                    num1 = it
                })
                Spacer(modifier = Modifier.height(12.dp))
                TextField(value = num2, onValueChange = {
                    num2 = it
                })
                Spacer(modifier = Modifier.height(20.dp))
                Text("Answer: $outputValue")

                Spacer(modifier = Modifier.height(25.dp))
                Row {
                    Button(onClick = {
                        var result = num1.toInt() + num2.toInt()
                        outputValue = result.toString()
                    }) {
                        Text("Add:")
                    }
                    Spacer(modifier = Modifier.width(50.dp))
                    Button(onClick = {
                        var result = num1.toInt() - num2.toInt()
                        outputValue = result.toString()
                    }) {
                        Text("Sub")
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
                Row {
                    Button(onClick = {
                        var result = num1.toInt() * num2.toInt()
                        outputValue = result.toString()
                    }) {
                        Text("Mul")
                    }
                    Spacer(modifier = Modifier.width(50.dp))
                    Button(onClick = {
                        val result = num1.toInt() / num2.toInt()
                        outputValue = result.toString()
                    }) {
                        Text("Div")
                    }
                }
            }

        }
    }
}


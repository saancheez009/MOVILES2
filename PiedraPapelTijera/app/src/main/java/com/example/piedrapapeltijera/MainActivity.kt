package com.example.piedrapapeltijera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.piedrapapeltijera.ui.theme.PiedraPapelTijeraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiedraPapelTijeraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    Column {
        Row{
            val imageModifier = Modifier
                .size(132.dp)
                .border(BorderStroke(1.dp, Color.Black))


            Image(
                painter = painterResource (id =R.drawable.piedra),
                contentDescription = "Piedra",
                modifier = imageModifier
            )
            Image(
                painter = painterResource (id =R.drawable.papel),
                contentDescription = "Papel",
                modifier = imageModifier
            )
            Image(
                painter = painterResource (id =R.drawable.tijera),
                contentDescription = "tijera",
                modifier = imageModifier
            )
        }
        /*val rowModifier = Modifier
            .size(200.dp)*/

        Row/*(modifier = rowModifier)*/{
            val image1Modifier = Modifier
                .size(150.dp)
            val image2Modifier = Modifier
                .size(150.dp)
            Column {
                Image(
                    painter = painterResource (id =R.drawable.piedra),
                    contentDescription = "EleccionMaquina",
                    modifier = image1Modifier
                )
            }
            Column {
                val txtModifier = Modifier
                    .size(150.dp)
                Text(
                    text = "VS",
                    modifier = txtModifier
                )
            }
            Column{
                Image(
                    painter = painterResource (id =R.drawable.papel),
                    contentDescription = "EleccionUsuario",
                    modifier = image2Modifier
                )
            }
        }
        //Spacer(Modifier.size(200.dp))
        Row{
            val imageModifier = Modifier
                .size(70.dp)

            Button(onClick = { }) {
                Image(
                    painter = painterResource (id =R.drawable.piedra),
                    contentDescription = "Piedra usuario",
                    modifier = imageModifier
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))

            }
            Button(onClick = { }) {
                Image(
                    painter = painterResource (id =R.drawable.papel),
                    contentDescription = "Piedra usuario",
                    modifier = imageModifier
                )
               Spacer(Modifier.size(ButtonDefaults.IconSpacing))

            }

            Button(onClick = { }) {
                Image(
                    painter = painterResource (id =R.drawable.tijera),
                    contentDescription = "Piedra usuario",
                    modifier = imageModifier
                )
               Spacer(Modifier.size(ButtonDefaults.IconSpacing))

            }
        }
    }
}

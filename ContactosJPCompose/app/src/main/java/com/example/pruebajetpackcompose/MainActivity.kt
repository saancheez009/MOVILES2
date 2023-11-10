package com.example.pruebajetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pruebajetpackcompose.ui.theme.PruebaJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ){
            Text(
                text = "Hello Juan",
                modifier = modifier,
                color = Color(223,27,159,255)

            )
            Text(
                text = "Hello Juanito",
                modifier = modifier
            )
            AsyncImage(
                model ="https://cdn.pixabay.com/photo/2018/04/26/12/14/travel-3351825_1280.jpg",
                contentDescription = "Mi buga",
                Modifier.size(400.dp,400.dp)
            )
        }

    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruebaJetPackComposeTheme {
        Greeting("World")
    }
}
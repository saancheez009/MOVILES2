package com.example.piedrapapeltijera

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piedrapapeltijera.ui.theme.PiedraPapelTijeraTheme
import kotlin.random.Random

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
                   /* val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Home"){
                        composable(route="Home"){
                            HomeScreen{
                               // https://youtu.be/CWqELgz0xJI?feature=shared
                                navController.navigate("detail")
                        }
                    }
*/
                    juego()

                }
            }
        }
    }
}


fun play(puntuacionJugador: Int, puntuacionMaquina: Int): Boolean {
    var juegan = true
    if (puntuacionMaquina >= 3 || puntuacionJugador >= 3){
        juegan = false
    }
    return juegan
}



@Composable
fun juego( modifier: Modifier = Modifier) {

    val context= LocalContext.current

    var eleccionJugador by remember { //Elección del jugador
        mutableStateOf(R.drawable.interrogacion)
    }
    var eleccionMaquina by remember { //Elección de  la maquina
        mutableStateOf(R.drawable.interrogacion)
    }

    var puntosMaquina by remember { //Puntuación de la máquina
        mutableStateOf(0)
    }
    var puntosJugador by remember { //Puntuación del jugador
        mutableStateOf(0)
    }

    when (eleccionJugador){
        1-> eleccionJugador = R.drawable.piedra //1 = piedra
        2-> eleccionJugador = R.drawable.papel //2 = papel
        3-> eleccionJugador = R.drawable.tijera //3 = tijera
    }


    when (eleccionMaquina){
        1-> eleccionMaquina = R.drawable.piedra //1 = piedra
        2-> eleccionMaquina = R.drawable.papel //2 = papel
        3-> eleccionMaquina = R.drawable.tijera //3 = tijera
    }

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
            val imageModifier = Modifier
                    .size(132.dp)
            Column {
                Image(
                    painter = painterResource(id = eleccionMaquina),
                    contentDescription = "EleccionMaquina",
                    modifier = imageModifier
                )
            }
            Column {
                Image(
                    painter = painterResource (id =R.drawable.vsimage),
                    contentDescription = "EleccionMaquina",
                    modifier = imageModifier
                )
            }
            Column{
                Image(
                    painter = painterResource(id = eleccionJugador),
                    contentDescription = "EleccionUsuario",
                    modifier = imageModifier
                )
            }
        }
        //Eleccion del jugador
        Row{
            val imageModifier = Modifier
                .size(90.dp)

            Image(painter = painterResource(id = R.drawable.piedra),
                contentDescription = "piedra",
                modifier = Modifier
                    .weight(1F)
                    .clickable(enabled = play(puntosJugador, puntosMaquina)) {
                        eleccionJugador = 1 //jugador elige piedra = 1
                        eleccionMaquina = random()
                        //Llamada funcion para determinar ganador
                        when (ganador(eleccionJugador, eleccionMaquina)) {
                            0 -> Toast
                                .makeText(context, "Empate", Toast.LENGTH_SHORT)
                                .show()

                            1 -> puntosMaquina += 1
                            2 -> puntosJugador += 1
                        }
                    }
            )
            Image(painter = painterResource(id = R.drawable.papel),
                contentDescription = "papel",
                modifier = Modifier
                    .weight(1F)
                    .clickable(enabled = play(puntosJugador, puntosMaquina)) {
                        eleccionJugador = 2 //El jugador elige papel = 2
                        eleccionMaquina = random()
                        //Llamada funcion para determinar ganador
                        when (ganador(eleccionJugador, eleccionMaquina)) {
                            0 -> Toast
                                .makeText(context, "Empate", Toast.LENGTH_SHORT)
                                .show()

                            1 -> puntosMaquina += 1
                            2 -> puntosJugador += 1
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.tijera),
                contentDescription = "tijera",
                modifier = Modifier
                    .weight(1F)
                    .clickable(enabled = play(puntosJugador, puntosMaquina)) {
                        eleccionJugador = 3 //El jugador elige tijera = 3

                        eleccionMaquina =
                            random()
                        //Llamada funcion para determinar ganador
                        when (ganador(eleccionJugador, eleccionMaquina)) {

                            0 -> Toast
                                .makeText(context, "Empate", Toast.LENGTH_SHORT)
                                .show()

                            1 -> puntosMaquina += 1
                            2 -> puntosJugador += 1
                        }
                    }
            )
                }

        Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                //se anuncia quien gana
                    val ganadort = ganadort(puntosJugador, puntosMaquina)
                    //Si no llegan a 3 ptos siguen jugando
                    if (play(puntosJugador, puntosMaquina)) {
                        Text(
                            text = "ptos máquina : $puntosMaquina - $puntosJugador ptos jugador",
                            fontSize = 30.sp
                        )
                    } else { //Si uno obtiene 3 ptos acaba el juego
                        Text(
                            text = "ptos máquina : $puntosMaquina - $puntosJugador ptos jugador " + "\n" +
                                    "\n" + "El ganador es  $ganadort!",
                            fontSize = 30.sp
                        )
                    }
        }
        /*Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            HomeScreen{
                val navController = rememberNavController()
                navController.navigate("detail")

            }
        }*/
    }

}
//Números aleatorios para la elección de maquina
fun random():Int{
    return Random.nextInt(1,4)
}
//Función que calcula el ganador de la partida
@SuppressLint("SuspiciousIndentation")
fun ganador(jugador:Int, maquina:Int):Int{
    var ganadorFinal = 0

        when(jugador){
            1 -> when (maquina){
                1-> ganadorFinal = 0 //Máquina = Piedra, empate :)
                2-> ganadorFinal = 1 //Máquina = Papel, gana máquina
                3-> ganadorFinal = 2 //Máquina = Tijeras, gana jugador
            }
            2 -> when (maquina){
                1-> ganadorFinal = 1 //Máquina = Piedra, gana máquina
                2-> ganadorFinal = 0 //Máquina = Papel, empate :)
                3-> ganadorFinal = 2 //Máquina = Tijeras, gana jugador
            }
            3 -> when (maquina){
                1-> ganadorFinal = 1 //Máquina = Piedra, gana máquina
                2-> ganadorFinal = 2 //Máquina = Papel, gana jugador
                3-> ganadorFinal = 0 //Máquina = Tijeras, empate :)
            }
        }

    return ganadorFinal
}
//texto que anuncia ganador
fun ganadort(puntuacionJugador:Int, puntuacionMaquina:Int):String{
    var texto = ""
    if (puntuacionJugador > puntuacionMaquina){
        texto = "el jugador"
    } else {
        texto = "la máquina"
    }
    return texto
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiedraPapelTijeraTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            juego()
        }
    }

}
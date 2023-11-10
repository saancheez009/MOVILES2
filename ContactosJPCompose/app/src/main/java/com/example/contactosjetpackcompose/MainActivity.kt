package com.example.contactosjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactosjetpackcompose.ui.theme.ContactosJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemList(
                itemContacto = listOf(
                    Contacto("Juan","648362245","https://loremflickr.com/320/240?random=1"),
                    Contacto("Jorge","648362245","https://loremflickr.com/320/240?random=2"),
                    Contacto("Sheila","648362245","https://loremflickr.com/320/240?random=3"),
                    Contacto("Juana","648365465","https://loremflickr.com/320/240?random=4"),
                    Contacto("Carla","648362245","https://loremflickr.com/320/240?random=5"),
                    Contacto("Marta","644892245","https://loremflickr.com/320/240?random=6"),
                    Contacto("Paco","648362456","https://loremflickr.com/320/240?random=7"),
                    Contacto("Fabián","636962245","https://loremflickr.com/320/240?random=8"),
                    Contacto("Jonathan","123362245","https://loremflickr.com/320/240?random=9"),
                    Contacto("Erick","612362245","https://loremflickr.com/320/240?random=10"),
                    Contacto("Sandra","648362789","https://loremflickr.com/320/240?random=11"),
                    Contacto("Leo","6483625436","https://loremflickr.com/320/240?random=12"),
                    Contacto("Messi","648365642","https://loremflickr.com/320/240?random=13")
                )
            )
            }
        }

@Composable

fun ItemList(itemContacto: List<Contacto>) {
    LazyColumn {
        items(itemContacto) { itemContacto ->
            ContactoView(contacto = itemContacto)
        }
    }
}
    @Composable
    fun ContactoView(contacto : Contacto){
        Card(Modifier.fillMaxWidth()){
                Row{
                    Column{

                        Image(
                            painter = painterResource (id =R.drawable.hamster2),
                            contentDescription = "Foto contacto",
                            Modifier.height(100.dp)
                        )
                    }
                    Column {
                        Text(
                            text= contacto.nombre,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
        }
    }

}



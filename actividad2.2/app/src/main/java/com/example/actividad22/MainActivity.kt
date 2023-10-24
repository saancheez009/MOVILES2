
package com.example.actividad22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.actividad22.databinding.ActivityMainBinding
import com.example.actividad22.databinding.CalculadoraBinding
import java.nio.channels.OverlappingFileLockException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val MainBinding = ActivityMainBinding.inflate(layoutInflater)
        val calculadoraBinding = CalculadoraBinding.inflate(layoutInflater)

        setContentView(MainBinding.root)

        val botonAcceder = MainBinding.accederBoton

        val usuario = MainBinding.usuariotxt

        val contraseña = MainBinding.contraTxt

        var soluc: Double = 0.0
        var num1 = calculadoraBinding.num1.text.toString()
        var num2 = calculadoraBinding.num2.text.toString()

        //Acceder a calculadora
        botonAcceder.setOnClickListener(View.OnClickListener {
            if(usuario.text.toString() == "britany" && contraseña.text.toString() == "ciruela"){
                setContentView(calculadoraBinding.root)


            }else{
                Toast.makeText(this,"Contraseña o usuario incorrecto", Toast.LENGTH_SHORT).show()
            }
        })

        //Volver al main
        calculadoraBinding.backBoton.setOnClickListener(View.OnClickListener {
            setContentView(MainBinding.root)
        })

        calculadoraBinding.sumaBoton.setOnClickListener(View.OnClickListener {

            soluc = (calculadoraBinding.num1.text.toString().toDouble())+(calculadoraBinding.num2.text.toString().toDouble())
        calculadoraBinding.solucion.text = soluc.toString()
        })


        calculadoraBinding.restaBoton.setOnClickListener(View.OnClickListener {

            soluc = (calculadoraBinding.num1.text.toString().toDouble())-(calculadoraBinding.num2.text.toString().toDouble())
            calculadoraBinding.solucion.text = soluc.toString()
        })


        calculadoraBinding.multiBoton.setOnClickListener(View.OnClickListener {
                    soluc = (calculadoraBinding.num1.text.toString().toDouble()) * (calculadoraBinding.num2.text.toString().toDouble())
                    calculadoraBinding.solucion.text = soluc.toString()


        })


        calculadoraBinding.divBoton.setOnClickListener(View.OnClickListener {

            if ( num2 =="" || num2=="0") {
                setContentView(calculadoraBinding.root)
                Toast.makeText(this,"No es posible realizar la operación", Toast.LENGTH_SHORT).show()

            }else{

                soluc = (calculadoraBinding.num1.text.toString().toDouble()) / (calculadoraBinding.num2.text.toString().toDouble())
                calculadoraBinding.solucion.text = soluc.toString()
            }
        })

    }
    //Comprobamos si el usuario introduce números
    private fun errores() {
        val calculadoraBinding = CalculadoraBinding.inflate(layoutInflater)
        var num1 = calculadoraBinding.num1.text.toString()
        var num2 = calculadoraBinding.num2.text.toString()
        var soluc: Float = 0F

        var number1= num1.toFloat()
        var number2=num2.toFloat()
        if (num1.isEmpty() && num2.isNotEmpty()) {
            number1= 0F

        }else if(num1.isNotEmpty() && num2.isEmpty()){
            number2= 0F
        } else if(num1.isEmpty() && num2.isEmpty()){
            number1= 0F
            number2= 0F
        }
    }
}

package es.kiketurry.talkaboutkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View.GONE
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val tag: String = MainActivity::class.java.simpleName

    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        varVal()
//        nulos()
//        extensiones()
//        corrutines()
    }


    fun nombreFuncion(parametroUno: Int, parametroDos: Int): Double {
        val retorno: Double = 3.0
        return retorno

        //Por defecto las funciones devuelven algo Unit -> Void
        //Nothing, un valor que nunca existe es un valor de retorno que sabemos va a devolver una excepción.
    }

    fun varVal() {

        //Any, como object de java
        var cualquiera: List<Any> = listOf(1, "palabra", 4f)
        Log.i(tag, "l> contenido de cualquiera: " + cualquiera)

        val a = 13
        val b: Float
        val c: List<Int> = listOf(1, 2, 3)
        var d: Float

        b = 2f
//        b = 4f // Ocasiona un error porque no se puede reasignar una variable inmutable

        d = 2f
        d = 4f
    }

    //Infiere los tipos
    fun funcionSimple(entero: Int): Int = 2 * entero


    fun nulos() {
        //var nombre: String = null
        var nombreNulo: String? = null
        var nombre2: String

//        nombre2 = nombreNulo

        if (nombreNulo != null) {
            nombre2 = nombreNulo
        }

        //Log.i(tag, "l> Imprimimos nombre null: ${nombreNulo.substring(5)}")
        if (nombreNulo != null) {
            Log.i(tag, "l> Imprimimos nombre null si es distinto de null: ${nombreNulo.substring(4)}")
        }

        //No efectua la operación para no cascar
        Log.i(tag, "l> Imprimimos nombre null si es distinto de null: ${nombreNulo?.substring(4)}")

        //Operador Elvis
        Log.i(
            tag,
            "l> Imprimimos nombre null si es distinto de null: ${nombreNulo?.substring(4)
                ?: "Ten cuidado que estas jugando con nulos"}"
        )

        //Cabezón ahí tienes el null pointer Exception
        //Log.i(tag, "l> Imprimimos nombre null a la fuerza: ${nombreNulo!!.substring(4)}")

        nombreNulo = "Enrique"
        Log.i(tag, "l> Imprimimos nombre null si es distinto de null: ${nombreNulo?.substring(4)}")
    }

    private fun extensiones() {
        toast("Mira Chechu..... Las extensiones son la salsa de la vida!")
        tvHello.visibility = GONE
        tvHello.setGone()
        tvHello.setInvisible()
        tvHello.setVisible()

        tvHello.clearText()
        tvHello.defaultText()
    }

    fun corrutines() {
        doAsync {
            Log.i(tag, "l> Vamos a iniciar el calculo de la serie de fibonacci: " + formatter.format(Date()))
            var resultFibonacci = fibonacciSerie(80)
            uiThread {
                Log.i(tag, "l> UI Ya tenemos el resultado fibonacci: " + formatter.format(Date()))
                Log.i(tag, "l> $resultFibonacci")
            }
        }
        doAsync {
            Log.i(tag, "l> Vamos a iniciar el calculo de la serie de primos: " + formatter.format(Date()))
            var resultPrimo = listaPrimos(100)
            uiThread {
                Log.i(tag, "l> UI Ya tenemos el resultado primos: " + formatter.format(Date()))
                Log.i(tag, "l> $resultPrimo")
            }
        }
    }

    private fun fibonacciSerie(numbersInSerie: Long): String {
        var stringBuilder: StringBuilder = StringBuilder()
        var i: Long = 1
        var t1: Long = 0
        var t2: Long = 1

        stringBuilder.append("Primeros $numbersInSerie numeros de la serie de fibonnacci: ")

        while (i <= numbersInSerie) {
            stringBuilder.append("$t1, ")

            val sum = t1 + t2
            t1 = t2
            t2 = sum

            i++
        }
        Log.i(tag, "l> Ya tenemos el resultado fibonacci: " + formatter.format(Date()))
        return stringBuilder.toString()
    }

    fun listaPrimos(numeroFin: Int): String {
        var stringBuilder: StringBuilder = StringBuilder()
        for (x in 0..numeroFin) {
            if (esPrimo(x)) {
                stringBuilder.append("$x, ")
            }
        }
        Log.i(
            tag,
            "l> Ya tenemos el resultado de los numeros primos existentes antes que el número $numeroFin: " + formatter.format(
                Date()
            )
        )
        return stringBuilder.toString()
    }

    fun esPrimo(numero: Int): Boolean {
        var contador = 2
        var primo = true
        while (primo && contador != numero) {
            if (numero % contador == 0) {
                primo = false
            }
            contador++
        }
        return primo
    }
}

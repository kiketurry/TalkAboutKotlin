package es.kiketurry.talkaboutkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    val tag: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        varVal()
        nulos()
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
        Log.i(tag,
            "l> Imprimimos nombre null si es distinto de null: ${nombreNulo?.substring(4)
                ?: "Ten cuidado que estas jugando con nulos"}"
        )

        //Cabezón ahí tienes el null pointer Exception
        //Log.i(tag, "l> Imprimimos nombre null a la fuerza: ${nombreNulo!!.substring(4)}")

        nombreNulo = "Enrique"
        Log.i(tag, "l> Imprimimos nombre null si es distinto de null: ${nombreNulo?.substring(4)}")
    }
}

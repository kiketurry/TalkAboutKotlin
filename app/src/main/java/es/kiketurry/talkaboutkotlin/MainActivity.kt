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
}

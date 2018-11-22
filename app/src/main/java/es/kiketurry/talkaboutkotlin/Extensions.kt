package es.kiketurry.talkaboutkotlin

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun View.setGone() {
    this.visibility = View.GONE
}

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun View.setInvisible() {
    this.visibility = View.INVISIBLE
}

fun TextView.defaultText() {
    this.text =
            "Minions ipsum po kass et sed nisi reprehenderit nostrud labore belloo! Bappleees poulet tikka masala potatoooo belloo! Tank yuuu! Aaaaaah laboris ad bananaaaa officia ti aamoo! Bananaaaa jiji ti aamoo! Nisi consequat baboiii daa. Irure bee do bee do bee do underweaaar quis chasy me want bananaaa! Voluptate."
}

fun TextView.clearText() {
    this.text = ""
}
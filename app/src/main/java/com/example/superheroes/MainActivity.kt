package com.example.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.superheroes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    /*lateinit Permite indicar variable instanciada posteriormente para asegurar que la variable no sea nula*/
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*Permite enlazar de manera más eficiente los componentes de la interfaz grafica de una actividad*/
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //setContentView(R.layout.activity_main)

        //var etHeroe = findViewById<EditText>(R.id.etNameHeroe)
        //var button = findViewById<Button>(R.id.btnSend)

        //var heroe:String = etHeroe.text.toString()


        //button.setOnClickListener {
        viewBinding.btnSend.setOnClickListener {

            //var heroe:String = getString(R.string.notificacion, etHeroe.text.toString())
            var heroe:String = getString(R.string.notificacion, viewBinding.etNameHeroe.text.toString())

            /*Notificacion General A La Aplicacion*/
            //Toast.makeText(this, "You send $heroe", Toast.LENGTH_LONG).show()
            /*Notificacion Propia De La Aplicacion*/
            Snackbar.make(it, heroe, Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.btnSend)
                .show()
        }
    }
}
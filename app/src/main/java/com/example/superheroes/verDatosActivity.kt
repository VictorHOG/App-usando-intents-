package com.example.superheroes

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroes.databinding.ActivityMainBinding
import com.example.superheroes.databinding.ActivityVerDatosBinding

class verDatosActivity : AppCompatActivity() {

    /*lateinit Permite indicar variable instanciada posteriormente para asegurar que la variable no sea nula*/
    private lateinit var viewBinding: ActivityVerDatosBinding
    /*Variables Estaticas o constantes de clase, evita problemas y facilita acceso a la información*/
    companion object{
        const val HEROE_KEY = "heroe_key"
        const val POWER_KEY = "power_key"
        const val IMAGEN_KEY = "imagen_key"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityVerDatosBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        /*Bundle objeto que gestiona parejas de valores, de la forma clave-valor*/
        val intent:Bundle = intent.extras!!
        viewBinding.tvNameEnviado.text = intent.getString(HEROE_KEY)
        viewBinding.ratingBar.rating = intent.getFloat(POWER_KEY)
        viewBinding.ivPhotoEnviada.setImageBitmap(intent.getParcelable<Bitmap>(IMAGEN_KEY))
    }
}
package com.example.superheroes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import com.example.superheroes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*lateinit Permite indicar variable instanciada posteriormente para asegurar que la variable no sea nula*/
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*Permite enlazar de manera más eficiente los componentes de la interfaz grafica de una actividad*/
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSend.setOnClickListener {
            /*Intent objeto que se encarga de lanzar una actividad y pasar informacion a las actividades*/
            /*Intent Explicito, permite llamar a una clase invocandola por su nombre especifico*/
            val intent = Intent(this, verDatosActivity::class.java)

            val heroe:String = viewBinding.eTHeroeName.text.toString()
            val power:Float = viewBinding.rbPower.rating
            val bitmap:Bitmap = viewBinding.ivPhoto.drawable.toBitmap()

            //intent.putExtra("heroe_key", heroe)
            //intent.putExtra("power_key", power)
            intent.putExtra(verDatosActivity.HEROE_KEY, heroe)
            intent.putExtra(verDatosActivity.POWER_KEY, power)
            intent.putExtra(verDatosActivity.IMAGEN_KEY, bitmap)

            startActivity(intent)
        }

        viewBinding.ivPhoto.setOnClickListener {
            /*Intent implicito, por medio de un filtro indica el uso de la camara*/
            val intentImplicito = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intentImplicito, 7)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 7 && resultCode == Activity.RESULT_OK){
            val imagen:Bundle? = data?.extras
            val heroImagen:Bitmap? = imagen?.getParcelable<Bitmap>("data")
            viewBinding.ivPhoto.setImageBitmap(heroImagen)
        }
    }
}
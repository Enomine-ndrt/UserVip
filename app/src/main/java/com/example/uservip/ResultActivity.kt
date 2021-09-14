package com.example.uservip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.uservip.UserVipApplication.Companion.prefs
import com.example.uservip.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }
fun initUi(){
    //metodo para boton volver back
    binding.btnBack.setOnClickListener {
        prefs.wipe()//eliminar elemento ingresado
        onBackPressed()//regresar
    }
    val userName = prefs.getName()//traer el nombre introducido
    binding.TvName.setText("Bienvenido $userName")//mostrar el nombre
    if(prefs.getVip()){// si es vip se cambia de color
        setVipColorBackground()//cambio de color
    }
}
    fun setVipColorBackground(){
        binding.container.setBackgroundColor(ContextCompat.getColor(this,R.color.vip_yellow))
    }


}
package com.example.uservip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uservip.UserVipApplication.Companion.prefs
import com.example.uservip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()//iniciar
        //checar si existe algun usuario
        checkUserValues()
    }

    fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){//si no es nullo
            goToDetail()
        }
    }

    fun initUI(){
        binding.btnContinue.setOnClickListener { accessToDetail() }
    }

    fun accessToDetail(){
     val nombre = binding.etName.text.toString()

        if(nombre.isNotEmpty()){
            //Guardar el usuario
            prefs.saveName(nombre)//guardar nombre
            prefs.saveVIP(binding.cbVip.isChecked)// guardar estado del check
            goToDetail()// ir a otra pantalla
        }else{

        }
    }

    fun goToDetail(){
        startActivity(Intent(this,ResultActivity::class.java))
    }
}

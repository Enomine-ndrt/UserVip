package com.example.uservip

import android.app.Application

class UserVipApplication:Application() {//tipo se tiene que volver tipo Application

    companion object{//con esto se hace global el valor de prefs
        lateinit var prefs:Prefs//se puede iniciar despues el valor
    }

    override fun onCreate() {//creacion de metodo oncreate para paso de contexto
        super.onCreate()
        prefs = Prefs(applicationContext)//se pasa contexto de aplicacion
    }
}
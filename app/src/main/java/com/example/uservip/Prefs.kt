package com.example.uservip

import android.content.Context

//clase a la que se pasa el context
class Prefs(val context: Context) {
    val SHARED_NAME = "Mydtb"//nombre de database de preferencias
    val SHARED_USER_NAME = "username" // nombre usuario
    val SHARED_VIP = "vip"//tipo vip


    val storage = context.getSharedPreferences(SHARED_NAME,0)//nombre y el modo

    fun saveName(name:String){//metodo para guardar el nombre
        //pasar identificador y nombre a ingresar
        //se le indica el tipo string
        storage.edit().putString(SHARED_USER_NAME,name).apply()
    }

    fun saveVIP(vip:Boolean){
        //pasar identificador y estado del check
        //usando metodo putBoolean
        storage.edit().putBoolean(SHARED_VIP,vip).apply()
    }

    fun getName():String{
        //traer el nombre ingresado y si no hay valor se pasa uno por default
      return  storage.getString(SHARED_USER_NAME,"")!!//devolver el valor
    }

    fun getVip():Boolean{
        //traer el valor de tipo boolean con getBoolean
        return storage.getBoolean(SHARED_VIP,false)//devolver el valor
    }
    fun wipe(){
        //borrar el storage con clear
        storage.edit().clear().apply()
    }
}
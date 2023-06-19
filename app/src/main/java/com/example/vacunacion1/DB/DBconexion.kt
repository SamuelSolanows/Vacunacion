package com.example.vacunacion1.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.vacunacion1.controler.MascotaController
import com.example.vacunacion1.controler.RazaController
import com.example.vacunacion1.controler.TipoController
import com.example.vacunacion1.controler.VacunaControler

open class DBconexion(context: Context):SQLiteOpenHelper(context,"db",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(TipoController.CREAR_TABLA)
        db!!.execSQL(RazaController.CREAR_TABLA)
        db!!.execSQL(VacunaControler.CREAR_TABLA)
        db!!.execSQL(MascotaController.CREAR_TABLA)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
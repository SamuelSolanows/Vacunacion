package com.example.vacunacion1.controler

import android.content.ContentValues
import android.content.Context
import com.example.vacunacion1.DB.CRUD
import com.example.vacunacion1.DB.DBconexion
import com.example.vacunacion1.clases.Vacuna

class VacunaControler(context: Context):DBconexion(context),CRUD<Vacuna> {
    companion object {
        val TABLA = "Vacuna"
        val ID = "Id"
        val NOMBRE = "Nombre"
        var CREAR_TABLA = "CREATE TABLE $TABLA($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NOMBRE TEXT)"
    }

    override fun leer(): MutableList<Vacuna> {
        var VACU= mutableListOf<Vacuna>()
        var cursor=this.readableDatabase.query(TABLA, arrayOf(ID, NOMBRE),null,null,null,null,null)
        cursor?.use {
            while (cursor.moveToNext()){
                var id=cursor.getInt(cursor.getColumnIndexOrThrow(ID))
                var nombre=cursor.getString(cursor.getColumnIndexOrThrow(NOMBRE))
                VACU.add(Vacuna(id,nombre))
            }
        }
        return VACU
    }

    override fun insertar(data: Vacuna): Long {
        return writableDatabase.insert(TABLA,null, ContentValues().apply {
            put(NOMBRE,data.Nombre)
        })
    }

    override fun eliminar(data: Vacuna): Long {
        TODO("Not yet implemented")
    }

    override fun editar(data: Vacuna): Long {
        TODO("Not yet implemented")
    }
}
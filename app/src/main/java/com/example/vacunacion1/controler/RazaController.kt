package com.example.vacunacion1.controler

import android.content.ContentValues
import android.content.Context
import com.example.vacunacion1.DB.CRUD
import com.example.vacunacion1.DB.DBconexion
import com.example.vacunacion1.clases.Raza
import com.example.vacunacion1.clases.Tipo

class RazaController(context: Context) : DBconexion(context), CRUD<Raza> {
    companion object {
        val TABLA = "Raza"
        val ID = "Id"
        val NOMBRE = "Nombre"
        var CREAR_TABLA = "CREATE TABLE $TABLA($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NOMBRE TEXT)"
    }

    override fun leer(): MutableList<Raza> {
        var RAZA = mutableListOf<Raza>()
        var cursor = this.readableDatabase.query(
            TABLA, arrayOf(
                ID,
                NOMBRE
            ), null, null, null, null, null
        )
        cursor?.use {
            while (cursor.moveToNext()) {
                var id = cursor.getInt(cursor.getColumnIndexOrThrow(ID))
                var nombre = cursor.getString(cursor.getColumnIndexOrThrow(NOMBRE))
                RAZA.add(Raza(id, nombre))
            }
        }
        return RAZA
    }

    override fun insertar(data: Raza): Long {
        return writableDatabase.insert(TABLA, null, ContentValues().apply {
            put(NOMBRE, data.Nombre)
        })
    }

    override fun eliminar(data: Raza): Long {
        var condicion="$ID LIKE ?"
        var argumento= arrayOf(data.Id.toString())
        return writableDatabase.delete(TABLA,condicion,argumento).toLong()
    }

    override fun editar(data: Raza): Long {
        TODO("Not yet implemented")
    }
}
package com.example.vacunacion1.controler

import android.content.ContentValues
import android.content.Context
import com.example.vacunacion1.DB.CRUD
import com.example.vacunacion1.DB.DBconexion
import com.example.vacunacion1.clases.Tipo

class TipoController(context: Context) : DBconexion(context), CRUD<Tipo> {
    companion object {
        val TABLA = "Tipo"
        val ID = "Id"
        val NOMBRE = "Nombre"
        var CREAR_TABLA = "CREATE TABLE $TABLA($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NOMBRE TEXT)"
    }

    override fun leer(): MutableList<Tipo> {
        var TIPO = mutableListOf<Tipo>()
        var cursor =
            this.readableDatabase.query(TABLA, arrayOf(ID, NOMBRE), null, null, null, null, null)
        cursor?.use {
            while (cursor.moveToNext()) {
                var id = cursor.getInt(cursor.getColumnIndexOrThrow(ID))
                var nombre = cursor.getString(cursor.getColumnIndexOrThrow(NOMBRE))
                TIPO.add(Tipo(id, nombre))
            }
        }
        return TIPO
    }

    override fun insertar(data: Tipo): Long {
        return writableDatabase.insert(TABLA, null, ContentValues().apply {
            put(NOMBRE, data.Nombre)
        })
    }

    override fun eliminar(data: Tipo): Long {
        var condicion="$ID LIKE ?"
        var argument= arrayOf(data.Id.toString())
        return writableDatabase.delete(TABLA,condicion,argument).toLong()
    }

    override fun editar(data: Tipo): Long {
        TODO("Not yet implemented")
    }
}
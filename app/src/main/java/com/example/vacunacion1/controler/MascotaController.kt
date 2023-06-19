package com.example.vacunacion1.controler

import android.content.ContentValues
import android.content.Context
import com.example.vacunacion1.DB.CRUD
import com.example.vacunacion1.DB.DBconexion
import com.example.vacunacion1.clases.Mascota

class MascotaController(context: Context) : DBconexion(context), CRUD<Mascota> {
    companion object {
        val TABLA = "Mascota"
        val ID = "Id"
        val NOMBRE = "Nombre"
        val ID_RAZA = "Id_raza"
        val ID_TIPO = "Id_tipo"
        val FECHA = "Fecha"
        var CREAR_TABLA =
            "CREATE TABLE $TABLA($ID INTEGER PRIMARY KEY AUTOINCREMENT,$NOMBRE TEXT, $ID_RAZA INTEGER,$ID_TIPO INTEGER, $FECHA TEXT, " +
                    "FOREIGN KEY ($ID_RAZA) REFERENCES ${RazaController.TABLA}(${RazaController.ID}),FOREIGN KEY ($ID_TIPO) REFERENCES ${TipoController.TABLA}(${TipoController.ID}) )"
    }

    override fun leer(): MutableList<Mascota> {
        var mascota= mutableListOf<Mascota>()
        var cursor=this.readableDatabase.query(TABLA, arrayOf(ID, NOMBRE, ID_RAZA, ID_TIPO, FECHA),null,null,null,null,null)
        cursor?.use {
            while (cursor.moveToNext()){
                var id=cursor.getInt(cursor.getColumnIndexOrThrow(ID))
                var nombre=cursor.getString(cursor.getColumnIndexOrThrow(NOMBRE))
                var id_raza=cursor.getInt(cursor.getColumnIndexOrThrow(ID_RAZA))
                var id_cursor=cursor.getInt(cursor.getColumnIndexOrThrow(ID_TIPO))
                var fecha=cursor.getString(cursor.getColumnIndexOrThrow(FECHA))
                mascota.add(Mascota(id,nombre,id_raza,id_cursor,fecha))
            }
        }
        return mascota
    }

    override fun insertar(data: Mascota): Long {

        return writableDatabase.insert(TABLA,null, ContentValues().apply {
            put(NOMBRE,data.Nombre)
            put(ID_RAZA,data.Id_raza)
            put(ID_TIPO,data.Id_raza)
            put(FECHA,data.Fecha)
        })
    }

    override fun eliminar(data: Mascota): Long {
        TODO("Not yet implemented")
    }

    override fun editar(data: Mascota): Long {
        TODO("Not yet implemented")
    }
}
package com.example.vacunacion1.DB

interface CRUD<E> {
    fun leer():MutableList<E>
    fun insertar(data:E):Long
    fun eliminar(data:E):Long
    fun editar(data:E):Long

}
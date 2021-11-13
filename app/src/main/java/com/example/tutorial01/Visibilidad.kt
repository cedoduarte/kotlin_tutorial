package com.example.tutorial01

class Visibilidad {
    var name : String? = null

    fun sayMyName() {
        name?.let {
            println("nombre es $it")
        } ?: run {
            println("sin nombre")
        }
    }
}
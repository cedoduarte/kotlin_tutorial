package com.example.tutorial01

class Programmer(name : String, age : Int, val language : String) : Person(name, age), Vehiculo {
    override fun work() {
        println("persona programando")
        super.work()
    }

    fun sayLanguage() {
        println("programando en $language")
    }

    override fun goToWork() {
        println("esta persona va a google")
    }

    override fun drive() {
        println("conduciendo coche")
    }
}
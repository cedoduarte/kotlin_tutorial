package com.example.tutorial01

open class Person(name : String, age : Int) : Work(), Game {
    // cualquier clase tiene una superclase comun llamada "Any"

    open fun work() {
        println("esta trabajando")
    }

    override fun goToWork() {
        println("persona yendo a trabajar")
    }

    // Game Interface
    override val game : String
        get() = "Among Us"

    override fun play() {
        println("jugando $game")
    }
}
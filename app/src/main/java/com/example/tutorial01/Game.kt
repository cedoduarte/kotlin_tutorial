package com.example.tutorial01

interface Game {
    val game : String

    fun play()
    fun stream() {
        println("estoy haciendo stream $game")
    }
}
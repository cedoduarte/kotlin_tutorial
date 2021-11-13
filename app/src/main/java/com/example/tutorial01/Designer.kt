package com.example.tutorial01

class Designer(name : String, age : Int) : Person(name, age) {
    override fun work() {
        println("persona disenyando")
        super.work()
    }
}
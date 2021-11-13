package com.example.tutorial01

class MyNestedAndInnerClass {
    private val one = 1

    private fun returnOne() : Int {
        return one
    }

    // clase anidada (nested class)
    class MyNestedClass {
        fun sum(a : Int, b : Int) : Int {
            return a + b
        }
    }

    inner class MyInnerClass {
        fun sumTwo(number : Int) : Int {
            return number + one + returnOne()
        }
    }
}
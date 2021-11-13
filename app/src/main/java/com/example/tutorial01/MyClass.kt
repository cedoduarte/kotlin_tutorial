package com.example.tutorial01

class MyClass(var name : String,
              var age : Int,
              var langs : Array<Language>,
              var friends : Array<MyClass>? = null)
{
    enum class Language {
        KOTLIN,
        SWIFT,
        JAVA,
        JAVASCRIPT
    }

    fun code() {
        for (language in langs) {
            println(language)
        }
    }
}
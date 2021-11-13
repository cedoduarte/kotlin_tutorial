package com.example.tutorial01

import java.util.*
import java.text.SimpleDateFormat

fun Date?.customFormat() : String? {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", Locale.getDefault())

    if (this != null) {
        return formatter.format(this)
    }
    return null
}

val Date?.formatSize : Int
    get() = this.customFormat()?.length ?: 0
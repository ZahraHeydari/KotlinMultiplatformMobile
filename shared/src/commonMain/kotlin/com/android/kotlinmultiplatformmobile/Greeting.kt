package com.android.kotlinmultiplatformmobile

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
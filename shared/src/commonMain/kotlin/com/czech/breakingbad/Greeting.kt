package com.czech.breakingbad

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
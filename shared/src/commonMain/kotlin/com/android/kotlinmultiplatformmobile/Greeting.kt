package com.android.kotlinmultiplatformmobile

class Greeting {
    fun greeting(): String {
        return "Guess what is OS version?! ${Platform().platform}!" +
                "\n& There are only ${daysUntilNewYear()} left until New Year! 🎅🏼 "
    }
}
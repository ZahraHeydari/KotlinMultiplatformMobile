package com.android.kotlinmultiplatformmobile.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.kotlinmultiplatformmobile.Greeting
import android.widget.TextView

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Loading..."

        scope.launch {
            kotlin.runCatching {
                Greeting().greeting()
            }.onSuccess {
                tv.text = it
            }.onFailure {
                it.printStackTrace()
                tv.text = it.localizedMessage
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
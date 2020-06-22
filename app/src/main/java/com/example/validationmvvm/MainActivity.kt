package com.example.validationmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.validationmvvm.ui.RegisterUserFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RegisterUserFragment.newInstance())
                .commitNow()
        }
    }
}
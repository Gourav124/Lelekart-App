package com.example.lelekart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lelekart.ui.theme.AppNavigation
import com.example.lelekart.ui.theme.LelekartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LelekartTheme {
                AppNavigation()
            }
        }
    }
}

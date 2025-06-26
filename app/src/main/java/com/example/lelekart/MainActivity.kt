package com.example.lelekart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.ui.Modifier
import com.example.lelekart.ui.theme.AppNavigation
import com.example.lelekart.ui.theme.LelekartTheme
import com.example.lelekart.ui.theme.MainViewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: MainViewModel by viewModels()
        setContent {
            LelekartTheme {
                AppNavigation(viewModel = viewModel)
            }
        }
    }
}

package dev.aaron.thompson.spotter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.aaron.thompson.spotter.ui.navigation.AppNavigation
import dev.aaron.thompson.spotter.ui.theme.SpotterTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SpotterTheme {
                AppNavigation()
            }
        }
    }
}
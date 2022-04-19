package com.xuaum.cstvcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.xuaum.cstvcompose.ui.theme.Background
import com.xuaum.cstvcompose.ui.theme.CSTVComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CSTVComposeTheme {
                DestinationsNavHost(
                    navGraph = NavGraphs.root,
                    Modifier.background(color = Background)
                )
            }
        }
    }
}


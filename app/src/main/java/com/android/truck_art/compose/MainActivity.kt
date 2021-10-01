package com.android.truck_art.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.truck_art.compose.ui.theme.AndroidtruckartcomposeTheme
import com.android.truck_art.compose.ui.theme.CanvasBackground

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidtruckartcomposeTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    DrawTruckArt()
                }
            }
        }
    }

    @Composable
    private fun DrawTruckArt() {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ) {
            Canvas(
                modifier = Modifier
                    .background(color = CanvasBackground)
                    .fillMaxWidth()
                    .height(320.dp)
            ) {
                drawArtAt(ArtPosition.TOP)
                drawArtAt(ArtPosition.CENTER)
                drawArtAt(ArtPosition.BOTTOM)
            }
        }
    }

}


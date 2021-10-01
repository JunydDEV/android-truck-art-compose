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
import androidx.compose.ui.graphics.drawscope.DrawScope
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
                    TruckArtComposable()
                }
            }
        }
    }

    @Composable
    private fun TruckArtComposable() {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ) {
            TruckCanvas {
                drawArtBannerAt(ArtPosition.TOP)
                drawArtBannerAt(ArtPosition.CENTER)
                drawArtBannerAt(ArtPosition.BOTTOM)
            }
        }
    }

    @Composable
    private fun TruckCanvas(onDraw: DrawScope.() -> Unit) {
        Canvas(
            modifier = Modifier
                .background(color = CanvasBackground)
                .fillMaxWidth()
                .height(ArtDimensions.truckArtCanvasHeight)
        ) {
            onDraw.invoke(this)
        }
    }

}


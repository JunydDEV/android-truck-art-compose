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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.truck_art.compose.raw.drawFlower
import com.android.truck_art.compose.ui.theme.*

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

    private fun DrawScope.drawArtAt(artPosition: ArtPosition) {
        when (artPosition) {
            ArtPosition.TOP -> {
                drawTopArt()
            }
            ArtPosition.CENTER -> {
                drawCenterArt()
            }
            else -> {
                drawBottomArt()
            }
        }
    }

    private fun DrawScope.drawTopArt() {
        drawRectangle(
            color = SecondaryRectangleBackground,
            height = 60.dp,
            topMargin = 5.dp
        ) {
            dottedLine(marginTop = 15.dp, marginStart = 5.dp)
            diamondsPattern(marginTop = 35.dp)
            dottedLine(marginTop = 55.dp, marginStart = 5.dp)
        }
    }

    private fun DrawScope.drawCenterArt() {
        drawRectangle(
            color = PrimaryRectangleBackground,
            topMargin = 70.dp,
            height = 180.dp
        ) {
            drawFlower(center.x - 300, center.y)
            drawFlower()
            drawFlower(center.x + 300, center.y)
        }
    }


    private fun DrawScope.drawBottomArt() {
        drawRectangle(
            color = SecondaryRectangleBackground,
            topMargin = 255.dp,
            height = 60.dp
        ) {
            dottedLine(marginTop = 265.dp, marginStart = 5.dp)
            diamondsPattern(marginTop = 285.dp)
            dottedLine(marginTop = 305.dp, marginStart = 5.dp)
        }
    }

    private fun DrawScope.drawRectangle(
        color: Color,
        topMargin: Dp = 0.dp,
        height: Dp,
        onDraw: (DrawScope) -> Unit
    ) {
        drawRect(
            color = color,
            topLeft = Offset(0f, topMargin.toPx()),
            size = Size(size.width, height.toPx())
        )
        onDraw.invoke(this)
    }

    enum class ArtPosition {
        TOP,
        CENTER,
        BOTTOM
    }

}


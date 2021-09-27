package com.android.truck_art.compose.raw

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import com.android.truck_art.compose.ui.theme.CanvasBackground
import com.android.truck_art.compose.ui.theme.Purple200
import com.android.truck_art.compose.ui.theme.Purple700
import kotlin.math.cos
import kotlin.math.sin

class Flower {
    companion object {

        fun DrawScope.drawFlower(positionX: Float = center.x, positionY: Float = center.y) {
            val circleRadius = 50f
            val leafCount = 6
            val angle = (360/leafCount).toFloat()

            for(i in 1..leafCount){
                val angleInDegrees = angle * i
                val theta = (Math.PI * angleInDegrees) / 180

                val x = circleRadius * cos((theta).toFloat())
                val y = circleRadius * sin((theta).toFloat())

                leaf(positionX + x, positionY - y)
            }
            flowerCenter(positionX,positionY)
        }

        private fun DrawScope.flowerCenter(positionX: Float = center.x , positionY: Float = center.y) {
            val circleRadius = 40f

            drawCircle(
                color = CanvasBackground,
                center = Offset(positionX,positionY),
                radius = circleRadius,
            )

            drawCircle(
                color = Color.White,
                center = Offset(positionX,positionY),
                style = Stroke(width = 10f),
                radius = circleRadius,
            )

            drawCircle(
                color = Color.Yellow,
                center = Offset(positionX,positionY),
                radius = circleRadius/2,
            )
        }

        private fun DrawScope.leaf(x: Float, y: Float) {
            val leafRadius = 20f
            drawCircle(
                color = Color.White,
                center = Offset(x, y),
                radius = leafRadius,
                style = Stroke(width = 20f),
            )
            drawCircle(
                brush = Brush.radialGradient(listOf(CanvasBackground, Purple700)),
                center = Offset(x, y),
                radius = leafRadius,
            )
        }
    }
}
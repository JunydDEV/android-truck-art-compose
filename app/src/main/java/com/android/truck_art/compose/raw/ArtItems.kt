package com.android.truck_art.compose.raw

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import kotlin.math.cos
import kotlin.math.sin

class ArtItems {
    companion object {

        fun DrawScope.diamondsPattern(marginTop: Dp) {
            val diamondsCount = 10
            val itemWidth = (size.width) / diamondsCount
            val diamondRadius = itemWidth / 3
            var marginLeft = itemWidth / 2
            val diamondSides = 4

            repeat(diamondsCount) {
                drawPath(
                    path = createPath(
                        marginLeft,
                        marginTop = marginTop.toPx(),
                        diamondSides,
                        diamondRadius
                    ),
                    color = Color.Yellow
                )
                if (it in 0 until diamondsCount) {
                    drawCircle(
                        color = Color.Black,
                        radius = 8f,
                        center = Offset(marginLeft + diamondRadius, marginTop.toPx())
                    )
                }
                marginLeft = marginLeft.plus(itemWidth)
            }
        }

        fun DrawScope.dottedLine(
            marginTop: Dp,
            marginStart: Dp,
            strokeWidth: Float = 10f,
            blendMode: BlendMode = DrawScope.DefaultBlendMode
        ) {
            drawLine(
                color = Color.White,
                start = Offset(marginStart.toPx(), marginTop.toPx()),
                end = Offset(size.width - marginStart.toPx(), marginTop.toPx()),
                strokeWidth = strokeWidth,
                pathEffect = PathEffect.dashPathEffect(
                    floatArrayOf(0f, 30f),
                    phase = 20f
                ),
                cap = StrokeCap.Round,
                blendMode = blendMode
            )
        }

        private fun createPath(
            marginLeft: Float,
            marginTop: Float,
            sides: Int,
            radius: Float
        ): Path {
            val path = Path()
            val angle = 2.0 * Math.PI / sides
            path.moveTo(
                marginLeft + (radius * cos(0.0)).toFloat(),
                marginTop + (radius * sin(0.0)).toFloat()
            )
            for (i in 1 until sides) {
                path.lineTo(
                    marginLeft + (radius * cos(angle * i)).toFloat(),
                    marginTop + (radius * sin(angle * i)).toFloat()
                )
            }
            path.close()
            return path
        }
    }
}




package com.android.truck_art.compose

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import kotlin.math.cos
import kotlin.math.sin


private fun createPathForDiamond(
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

fun DrawScope.drawDiamondsPattern(marginTop: Dp) {
    val diamondsCount = 10
    val itemWidth = (size.width) / diamondsCount
    val diamondRadius = itemWidth / 3
    var marginLeft = itemWidth / 2
    val diamondSides = 4

    repeat(diamondsCount) {
        drawPath(
            path = createPathForDiamond(
                marginLeft,
                marginTop.toPx(),
                diamondSides,
                diamondRadius
            ),
            color = Color.Yellow
        )
        if (it > 0) {
            drawCircle(
                color = Color.Black,
                radius = 8f,
                center = Offset(itemWidth.times(it), marginTop.toPx())
            )
        }
        marginLeft = marginLeft.plus(itemWidth)
    }
}

fun DrawScope.drawDashedLine(
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
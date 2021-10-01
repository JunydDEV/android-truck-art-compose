package com.android.truck_art.compose

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.truck_art.compose.raw.drawFlower
import com.android.truck_art.compose.ui.theme.PrimaryRectangleBackground
import com.android.truck_art.compose.ui.theme.SecondaryRectangleBackground

fun DrawScope.drawArtAt(artPosition: ArtPosition) {
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

fun DrawScope.drawTopArt() {
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

fun DrawScope.drawCenterArt() {
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

fun DrawScope.drawBottomArt() {
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

fun DrawScope.drawRectangle(
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
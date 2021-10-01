package com.android.truck_art.compose

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.truck_art.compose.ui.theme.PrimaryRectangleBackground
import com.android.truck_art.compose.ui.theme.SecondaryRectangleBackground

fun DrawScope.drawArtBannerAt(artPosition: ArtPosition) {
    when (artPosition) {
        ArtPosition.TOP -> {
            drawTopBannerArt()
        }
        ArtPosition.CENTER -> {
            drawCenterBannerArt()
        }
        else -> {
            drawBottomBannerArt()
        }
    }
}

fun DrawScope.drawTopBannerArt() {
    drawArtBannerCore(
        color = SecondaryRectangleBackground,
        height = 60.dp,
        topMargin = 5.dp
    ) {
        drawDashedLine(marginTop = 15.dp, marginStart = 5.dp)
        drawDiamondsPattern(marginTop = 35.dp)
        drawDashedLine(marginTop = 55.dp, marginStart = 5.dp)
    }
}

fun DrawScope.drawCenterBannerArt() {
    drawArtBannerCore(
        color = PrimaryRectangleBackground,
        topMargin = 70.dp,
        height = 180.dp
    ) {
        drawPrimaryFlowerArt(center.x - 300, center.y)
        drawPrimaryFlowerArt()
        drawPrimaryFlowerArt(center.x + 300, center.y)
    }
}

fun DrawScope.drawBottomBannerArt() {
    drawArtBannerCore(
        color = SecondaryRectangleBackground,
        topMargin = 255.dp,
        height = 60.dp
    ) {
        drawDashedLine(marginTop = 265.dp, marginStart = 5.dp)
        drawDiamondsPattern(marginTop = 285.dp)
        drawDashedLine(marginTop = 305.dp, marginStart = 5.dp)
    }
}

fun DrawScope.drawArtBannerCore(
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
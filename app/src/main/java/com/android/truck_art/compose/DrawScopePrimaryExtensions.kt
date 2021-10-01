package com.android.truck_art.compose

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.truck_art.compose.ArtDimensions.Companion.bottomArtBannerMarginTop
import com.android.truck_art.compose.ArtDimensions.Companion.bottomBannerDashedLineMarginTop
import com.android.truck_art.compose.ArtDimensions.Companion.centeredArtBannerMarginTop
import com.android.truck_art.compose.ArtDimensions.Companion.dashedLineMarginStart
import com.android.truck_art.compose.ArtDimensions.Companion.diamondPatternMarginTop
import com.android.truck_art.compose.ArtDimensions.Companion.mainArtBannerHeight
import com.android.truck_art.compose.ArtDimensions.Companion.secondaryArtBannerHeight
import com.android.truck_art.compose.ArtDimensions.Companion.topArtBannerMarginTop
import com.android.truck_art.compose.ArtDimensions.Companion.topBannerDashedLineMarginTop
import com.android.truck_art.compose.ArtDimensions.Companion.truckArtCanvasHeight
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
        height = secondaryArtBannerHeight,
        topMargin = topArtBannerMarginTop
    ) {
        drawDashedLine(
            marginTop = topBannerDashedLineMarginTop,
            marginStart = dashedLineMarginStart
        )
        drawDiamondsPattern(marginTop = diamondPatternMarginTop)
        drawDashedLine(
            marginTop = secondaryArtBannerHeight - topArtBannerMarginTop,
            marginStart = dashedLineMarginStart
        )
    }
}

fun DrawScope.drawCenterBannerArt() {
    drawArtBannerCore(
        color = PrimaryRectangleBackground,
        topMargin = centeredArtBannerMarginTop,
        height = mainArtBannerHeight
    ) {
        //I want to draw 3 flowers on main banner of the canvas
        val weightSum = 3

        //Finds the width for each flower
        val eachFlowerWidth = size.width / weightSum

        //Finds the X Offset at the center of individual item width.
        var positionX = eachFlowerWidth / 2

        repeat(weightSum) {
            drawPrimaryFlowerArt(positionX, center.y)

            //Moves the drawing control to the next item X Offset center position
            positionX += eachFlowerWidth
        }
    }
}

fun DrawScope.drawBottomBannerArt() {
    drawArtBannerCore(
        color = SecondaryRectangleBackground,
        topMargin = bottomArtBannerMarginTop,
        height = secondaryArtBannerHeight
    ) {
        drawDashedLine(
            marginTop = bottomArtBannerMarginTop + bottomBannerDashedLineMarginTop,
            marginStart = dashedLineMarginStart
        )
        drawDiamondsPattern(marginTop = truckArtCanvasHeight - diamondPatternMarginTop)
        drawDashedLine(
            marginTop = truckArtCanvasHeight - topBannerDashedLineMarginTop,
            marginStart = dashedLineMarginStart
        )
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
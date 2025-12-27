package com.plcoding.bookpedia.core.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun PulseAnimation(
    modifier: Modifier = Modifier,
    dotSize: Dp = 24.dp,
    dotColor: Color = Accent,
    delayUnit: Int = 300,
    dots: Int = 3
) {
    @Composable
    fun Dot(
        scale: Float
    ) = Spacer(
        Modifier
            .size(dotSize)
            .scale(scale)
            .clip(CircleShape)
            .background(dotColor)
    )

    val animatables = List(dots) {
        remember { Animatable(0f) }
    }

    animatables.forEachIndexed { index, animatable ->
        LaunchedEffect(animatable) {
            delay(index * delayUnit.toLong())
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = delayUnit * dots,
                        easing = {
                            if (it <= 0.5f) {
                                2 * it
                            } else {
                                2 * (1 - it)
                            }
                        }
                    ),
                    repeatMode = RepeatMode.Restart,
                )
            )
        }
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        animatables.forEachIndexed { index, animatable ->
            Dot(animatable.value)
            if (index < dots - 1) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

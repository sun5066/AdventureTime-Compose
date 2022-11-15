package com.github.sun5066.adventure_time.ui.home.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedShimmer() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )

    val transition = rememberInfiniteTransition()
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )

    ShimmerDetailCharacterCard(brush)
}

@Composable
fun ShimmerDetailCharacterCard(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .padding()
                .clip(RoundedCornerShape(corner = CornerSize(5.dp)))
                .background(brush)
                .weight(1f)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.7f)
                .background(brush)
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.9f)
                .background(brush)
        )
    }
}
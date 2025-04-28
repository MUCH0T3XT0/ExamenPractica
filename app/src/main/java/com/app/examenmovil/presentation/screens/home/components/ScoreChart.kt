package com.app.examenmovil.presentation.screens.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val PositiveColor = Color(0xFF4CAF50)
val NeutralColor = Color(0xFFFFC107)
val NegativeColor = Color(0xFFF44336)

@Composable
@Suppress("ktlint:standard:function-naming")
fun ScoreChart(
    score: Double,
    sentiment: String,
) {
    val backgroundColor = Color.LightGray.copy(alpha = 0.3f)
    val scoreColor =
        when (sentiment.lowercase()) {
            "positive" -> PositiveColor
            "neutral" -> NeutralColor
            "negative" -> NegativeColor
            else -> MaterialTheme.colorScheme.primary
        }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(120.dp),
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Círculo de fondo (100%)
            drawArc(
                color = backgroundColor,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                size = Size(size.width, size.height),
                style = Stroke(width = 15f, cap = StrokeCap.Round),
            )

            // Arco de score (como porcentaje de 1)
            drawArc(
                color = scoreColor,
                startAngle = -90f,
                sweepAngle = 360f * score.toFloat(),
                useCenter = false,
                size = Size(size.width, size.height),
                style = Stroke(width = 15f, cap = StrokeCap.Round),
            )
        }

        // Texto central
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${(score * 100).toInt()}%",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = scoreColor,
            )
        }
    }
}

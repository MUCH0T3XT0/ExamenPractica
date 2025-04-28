package com.app.examenmovil.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SentimentDto(
    @SerializedName("puzzle") val score: Double,
)

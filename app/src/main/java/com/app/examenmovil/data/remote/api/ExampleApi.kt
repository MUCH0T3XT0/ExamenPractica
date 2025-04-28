package com.app.examenmovil.data.remote.api

import com.app.examenmovil.data.remote.dto.ExampleResultDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ExampleApi {
    @GET("sentiment")
    suspend fun getExampleList(
        @Query("text") text: String,
        @Header("X-Api-Key") apiKey: String = "wLVPN1zV08lJYF7uXqgyPw==zVwp6TlVcAO1NLUf",
    ): ExampleResultDto
}

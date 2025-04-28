package com.app.examenmovil.data.repository

import com.app.examenmovil.data.remote.api.ExampleApi
import com.app.examenmovil.domain.model.Example
import com.app.examenmovil.domain.repository.ExampleRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExampleRepositoryImpl
    @Inject
    constructor(
        private val api: ExampleApi,
    ) : ExampleRepository {
        override suspend fun getExampleList(text: String): Example {
            val response = api.getExampleList(text)
            return Example(
                response.score,
                response.text,
                response.sentiment,
            )
        }
    }

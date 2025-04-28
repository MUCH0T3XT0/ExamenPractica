package com.app.examenmovil.domain.usecase

import com.app.examenmovil.domain.common.Result
import com.app.examenmovil.domain.model.Example
import com.app.examenmovil.domain.repository.ExampleRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetExampleListUseCase
    @Inject
    constructor(
        // Inyectado por Hilt
        private val repository: ExampleRepository,
    ) {
        // Puede ser llamado como useCase()
        operator fun invoke(text: String): Flow<Result<Example>> =
            flow {
                try {
                    // Primer valor: Loading
                    emit(Result.Loading)

                    // Obtiene datos
                    val exampleList = repository.getExampleList(text)

                    // Segundo valor: Success con datos
                    emit(Result.Success(exampleList))
                } catch (e: Exception) {
                    // O Error si algo falla
                    emit(Result.Error(e))
                }
            }
    }

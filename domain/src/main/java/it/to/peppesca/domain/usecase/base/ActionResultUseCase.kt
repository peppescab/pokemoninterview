package it.to.peppesca.domain.usecase.base

/**
 * Use case with [Input] class parameter that outputs an [Output]
 */
interface ActionResultUseCase<Input, Output> : UseCase {

    /**
     * Execute the given use case
     */
    suspend fun execute(params: Input): Output
}

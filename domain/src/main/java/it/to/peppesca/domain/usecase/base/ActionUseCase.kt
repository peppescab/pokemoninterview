package it.to.peppesca.domain.usecase.base

/**
 * Use case with [Input] class parameter and no outputs
 */
interface ActionUseCase<Input> : UseCase {

    /**
     * Execute the given use case
     */
    suspend fun execute(params: Input)
}

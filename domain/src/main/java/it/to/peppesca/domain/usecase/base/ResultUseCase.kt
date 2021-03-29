package it.to.peppesca.domain.usecase.base

/**
 * Use case interface that outputs an [Output]
 */
interface ResultUseCase<Output> : UseCase {

    /**
     * Execute the given use case and output [Output]
     *
     * @return [Output] as the result of the use case
     */
    suspend fun execute(): Output
}

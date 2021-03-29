package it.to.peppesca.domain

import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.util.*

/**
 * Interface that represents a base mapper to convert [Input] type to [Output] type.
 */
interface Mapper<Input, Output> {
    /**
     * Transforms an input into output.
     *
     * @param input the input to be transformed
     * @return transformation result
     */
    fun map(input: Input): Output

    /**
     * Transforms a [List] of [Input] into a [List] of [Output].
     *
     * @param input the input to be transformed
     * @return transformation result
     */
    fun map(input: List<Input>): List<Output> {
        val result: MutableList<Output> = LinkedList()
        for (item in input) {
            result.add(map(item))
        }
        return result
    }

    /**
     * Transforms a [List] of [Input] into a [List] of [Output].
     *
     * @param input the input to be transformed
     * @return transformation result
     */
    fun map(input: Flow<PagingData<List<Input>>>): Flow<PagingData<List<Output>>> {
        return flow { input.map { it.map { it.map { output -> map(output) } } } }
    }

    /**
     * Transforms a [List] of [Input] into a [List] of [Output].
     *
     * @param input the input to be transformed
     * @return transformation result
     */
    fun mapAsFlow(input: List<Flow<Input>>): List<Flow<Output>> {
        return input.map { it.map { map(it) } }
    }

}

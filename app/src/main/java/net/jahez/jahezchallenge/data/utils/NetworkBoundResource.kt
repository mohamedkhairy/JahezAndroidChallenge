package net.jahez.jahezchallenge.data.utils

import kotlinx.coroutines.flow.*
import net.jahez.jahezchallenge.domain.core.Resource

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType?) -> Boolean = { true }
) = flow {
    val data = query().firstOrNull()

    val flow = if (shouldFetch(data)) {
//        emit(Resource.Loading(data))

        try {
            val fetch = fetch()
            saveFetchResult(fetch)
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}
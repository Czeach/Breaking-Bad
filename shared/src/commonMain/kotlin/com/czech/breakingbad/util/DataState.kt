package com.czech.breakingbad.util

data class DataState<T>(
    val message: MessageInfo.Builder? = null,
    val data: T? = null,
    val isLoading: Boolean = false
) {
    companion object {

        fun <T> error(
            message: MessageInfo.Builder
        ): DataState<T> {
            return DataState(
                message = message
            )
        }

        fun <T> loading(
            isLoading: Boolean
        ): DataState<T> {
            return DataState(
                isLoading = isLoading
            )
        }

        fun <T> data(
            message: MessageInfo.Builder? = null,
            data: T? = null
        ): DataState<T> {
            return DataState(
                message = message,
                data = data
            )
        }

        fun <T> loading() = DataState<T>(
            isLoading = true
        )
    }
}
package br.com.iuji.popularmovies.model.status

sealed class StatusResponse<T>

class StatusSuccess<T>(val data: T) : StatusResponse<T>()
class StatusError<T>(val error: Throwable) : StatusResponse<T>()
class StatusLoading<T> : StatusResponse<T>()
class StatusDisabled<T> : StatusResponse<T>()
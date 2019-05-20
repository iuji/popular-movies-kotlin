package br.com.iuji.popularmovies.model.status

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.Single

internal inline fun <T> singleCallable(
        crossinline func: () -> T
): Single<T>? {

    return Single.fromCallable { func.invoke() }
            .defaultSchedulers()
}

fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observer: (data: T) -> Unit) {
    observe(owner, android.arch.lifecycle.Observer {
        it?.let(observer)
    })
}

fun <T> MutableLiveData<StatusResponse<T>>.successData(data: T, isUserFreeToChangeScreen: Boolean = false) =
        if (isUserFreeToChangeScreen) {
            postValue(StatusSuccess(data))
        } else {
            value = StatusSuccess(data)
        }

fun <T> MutableLiveData<StatusResponse<T>>.errorData(error: Throwable, isUserFreeToChangeScreen: Boolean = false) =
        if (isUserFreeToChangeScreen) {
            postValue(StatusError(error))
        } else {
            value = StatusError(error)
        }
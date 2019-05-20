package br.com.iuji.popularmovies.model.status

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

// IO thread pool scheduler
fun io() = Schedulers.io()

// Computation thread pool scheduler
fun computation() = Schedulers.computation()

// Main Thread scheduler
fun ui() = AndroidSchedulers.mainThread()

/**
 * Execute the operation on a new thread (from thread pool) and listen on the main thread.
 * It can be used for I/O operations
 *
 * @return the transformer properly configured
 */
fun <T> Single<T>.defaultSchedulers() = this.subscribeOn(io()).observeOn(ui())
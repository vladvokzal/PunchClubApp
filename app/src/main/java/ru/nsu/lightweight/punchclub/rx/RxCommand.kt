package ru.nsu.lightweight.punchclub.rx

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RxCommand {

    companion object {

        private fun <R, Q, T> getApiSingle(
            request: R,
            requester: Q,
            function: (R, Q) -> T
        ): Single<T> {
            return Single.fromCallable {
                function.invoke(request, requester)
            }
        }

        private fun <T> getApiSubscribe(
            single: Single<T>,
            onComplete: (() -> Unit)? = null,
            onSuccess: ((T) -> Unit)? = null,
            onError: ((Throwable) -> Unit)? = null,
            onNext: (() -> Unit)? = null
        ): Disposable {
            return single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        onComplete?.invoke()
                        onSuccess?.invoke(it)
                        onNext?.invoke()
                    },
                    { error ->
                        onComplete?.invoke()
                        onError?.invoke(error)
                        onNext?.invoke()
                    }
                )
        }

        /*
        * if request success then call:
        * 1. onComplete
        * 2. onSuccess
        * 3. onNext
        *
        * if request handle error then call:
        * 1. onComplete
        * 2. onError
        * 3. onNext
        * */
        fun <R, Q, T> makeSingleApiRequest(
            request: R,
            requester: Q,
            function: (R, Q) -> T,
            onComplete: (() -> Unit)? = null,
            onSuccess: ((T) -> Unit)? = null,
            onError: ((Throwable) -> Unit)? = null,
            onNext: (() -> Unit)? = null
        ): Disposable {
            val single = getApiSingle(request, requester, function)
            return getApiSubscribe(single, onComplete, onSuccess, onError, onNext)
        }
    }
}
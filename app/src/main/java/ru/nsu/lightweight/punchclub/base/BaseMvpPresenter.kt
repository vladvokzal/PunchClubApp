package ru.nsu.lightweight.punchclub.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseMvpPresenter<T : MvpView> : MvpPresenter<T>() {

    private var compositeDisposable: CompositeDisposable? = null

    fun regSubs(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(disposable)
    }

    private fun clearSubs() {
        if (compositeDisposable != null) {
            compositeDisposable?.dispose()
            compositeDisposable?.clear()
        }
    }

    override fun onDestroy() {
        clearSubs()
        super.onDestroy()
    }
}
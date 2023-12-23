package kaa.alisherbu.listbookstudio.shared.utils

import com.arkivanov.mvikotlin.rx.observer
import com.arkivanov.mvikotlin.rx.Disposable
import com.arkivanov.mvikotlin.core.store.Store

import com.arkivanov.decompose.value.Value

val <Wrapped : Any> Store<*, Wrapped, *>.states: Value<Wrapped>
    get() = object : Value<Wrapped>() {
        override val value: Wrapped get() = state
        private var disposables = emptyMap<(Wrapped) -> Unit, Disposable>()

        override fun subscribe(observer: (Wrapped) -> Unit) {
            val disposable = states(observer = observer(onNext = observer))
            this.disposables += observer to disposable
        }

        override fun unsubscribe(observer: (Wrapped) -> Unit) {
            val disposable = disposables[observer] ?: return
            this.disposables -= observer
            disposable.dispose()
        }
    }
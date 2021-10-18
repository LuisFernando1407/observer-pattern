package pattern.observer

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import org.junit.After
import org.junit.Test
import kotlin.test.assertEquals


class PublishSubscriberIntegrationTest {

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    @After
    fun close() {
        compositeDisposable.dispose()
    }

    @Test
    fun `Case with Publisher-Subscriber success`() {
        val subject = PublishSubject.create<String>()

        compositeDisposable.add(
            subject.subscribe {
                println("Test 1: $it")
            }
        )

        subject.onNext("received news")
    }

    @Test
    fun `Case with Publisher-Subscriber error`() {
        val subject = PublishSubject.create<String>()

        compositeDisposable.add(
            subject.subscribe(
                { println("Test 2: $it") },
                { println("Test 2: ${it.message}") }
            )
        )

        subject.onError(Throwable("unable to notify"))
    }
}
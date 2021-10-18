package pattern.observer

import kotlin.test.assertEquals
import org.junit.Test
import pattern.observer.aux.NewsAgency
import pattern.observer.aux.NewsChannel
import pattern.observer.listener.NewsAgencyListener
import pattern.observer.listener.NewsChannelListener


class ObserverIntegrationTest {

    @Test
    fun `When changing NewsAgency state then NewsChannel is notified`() {
        val observable = NewsAgency()
        val observer = NewsChannel()

        observable.addObserver(observer)
        observable.news = "news"

        assertEquals(observer.news, "news")
    }

    @Test
    fun `When changing NewsAgencyObservable state then NewsChannelObserver is notified`() {
        val observable = NewsAgencyObservable()
        val observer = NewsChannelObserver()

        observable.addObserver(observer)
        observable.news = "news"

        assertEquals(observer.news, "news")
    }

    @Test
    fun `When changing NewsAgencyListener state then NewsChannelObserver is notified`() {
        val observable = NewsAgencyListener.of()
        val observer = NewsChannelListener()

        observable.addPropertyChangeListener(observer)
        observable.news = "news"

        assertEquals(observer.news, "news")
    }
}
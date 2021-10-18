package pattern.observer

import java.util.*

class NewsChannelObserver: Observer {
    var news: String? = null
        get() = field
        set(value) {
            field = value
        }

    override fun update(o: Observable?, arg: Any?) {
        this.news = arg as String
    }
}
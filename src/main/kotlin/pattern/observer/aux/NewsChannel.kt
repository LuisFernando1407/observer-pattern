package pattern.observer.aux

import pattern.observer.IChannel

class NewsChannel: IChannel {
    var news: String? = null
        get() = field
        set(value) { field = value }

    override fun update(o: Any?) {
        this.news = o as String
    }
}
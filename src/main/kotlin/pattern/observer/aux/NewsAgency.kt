package pattern.observer.aux

import pattern.observer.IChannel


class NewsAgency {
    var news: String? = null
        set(value) {
            field = value
            for (channel in channels) {
                channel.update(this.news)
            }
        }

    private val channels = arrayListOf<IChannel>()

    fun addObserver(channel: IChannel) {
        channels.add(channel)
    }

    fun removeObserver(channel: IChannel) {
        channels.remove(channel)
    }
}
package pattern.observer.listener

import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener


class NewsChannelListener: PropertyChangeListener {
    var news: String? = null
        get() = field
        set(value) { field = value }

    override fun propertyChange(evt: PropertyChangeEvent) {
         this.news =  evt.newValue as String
    }
}
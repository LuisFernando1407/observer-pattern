package pattern.observer.listener

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport


class NewsAgencyListener private constructor(private val support: PropertyChangeSupport) {
    var news: String? = null
        set(value) {
            support.firePropertyChange("news", news, value)
            field = value
        }

    fun addPropertyChangeListener(listener: PropertyChangeListener?) {
        support.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener?) {
        support.removePropertyChangeListener(listener)
    }

    companion object {
        fun of() = NewsAgencyListener(support = PropertyChangeSupport(this))
    }
}
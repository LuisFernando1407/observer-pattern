package pattern.observer

import java.util.*

class NewsAgencyObservable: Observable() {
    var news: String? = null
        set(value) {
            field = value
            setChanged()
            notifyObservers(field)
        }
}
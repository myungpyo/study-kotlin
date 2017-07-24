package com.smp.kotlin.jvm

fun main(args: Array<String>) {

  val result = sanitize(
          "     This is ## my ##first test.     ",
          { it.trim() },
          { it.replace("#", "") }
  )

    println("sanitized text : $result")


    // reified type testing
    val car = InspectableCar()
    car.registerObserver(EngineObserver("PowerfulEngine"))
    car.registerObserver(CrankObserver("AwesomeCrank"))
    car.registerObserver(TireObserver("GoodTire", "frontLeft"))
    car.registerObserver(TireObserver("GoodTire", "frontRight"))
    car.registerObserver(TireObserver("GoodTire", "rearLeft"))
    car.registerObserver(TireObserver("GoodTire", "rearRight"))

    val tireObservers : MutableList<TireObserver> = car.getRegisteredSpecificObservers()

    println("tireObservers : $tireObservers")
    

}

inline fun sanitize(text: String, simpleSanitizer: (text: String) -> String, noinline heavySanitizer: (text: String) -> String) : String {
    return heavySanitizer(simpleSanitizer(text))
}

inline fun <reified T> Observable<in T>.getRegisteredSpecificObservers(): MutableList<T> {

    val result = mutableListOf<T>()

    for (observer in getRegisteredObservers()) {
        if (observer is T) {
            result.add(observer)
        }
    }

    return result
}

interface Observable<T> {
    fun registerObserver(observer: T)
    fun unregisterObserver(observer: T)
    fun getRegisteredObservers(): List<T>
}

interface LifeCycleObserver {
    fun onCreate()
    fun onDestroy()
}

class InspectableCar : Observable<CarObserver> {

    val allRegisteredObservers = mutableListOf<CarObserver>()

    override fun registerObserver(observer: CarObserver) {
        allRegisteredObservers.add(observer)
    }

    override fun unregisterObserver(observer: CarObserver) {
        allRegisteredObservers.remove(observer)
    }

    override fun getRegisteredObservers(): List<CarObserver> {
        return allRegisteredObservers
    }
}


interface CarObserver

data class EngineObserver(val model: String) : CarObserver

data class TireObserver(val model: String, val position: String) : CarObserver

data class CrankObserver(val model: String) : CarObserver

class HasInlinePropertyClass {
    var count: Int
        inline get() {
            return 0
        }
        inline set(value) {

        }
}
package com.smp.kotlin.jvm

fun main(args : Array<String>) {

    var volt = 220

    val myCleanUpRobot: CleanUpRobot = object : CleanUpRobot(), Pluggable {
        override val speed: Int = 30

        override fun plug() {
            println("Plugged to $volt")
        }

        override fun unplug() {
            println("Unplugged to $volt")
        }

    }

    (myCleanUpRobot as? Pluggable)?.plug()
    myCleanUpRobot.start()
    (myCleanUpRobot as? Pluggable)?.unplug()


    val justObj = object {
        var name: String = "Tom"
        var age: Int = 10

        override fun toString(): String {
            return "Name : $name, Age : $age"
        }
    }

    println(justObj)

    BadgeProvider.registerReceiver(object : BadgeReceiver {
        override fun onReceive(count: Int) {
            println("Badge received : $count")
        }
    })

    BadgeProvider.notifyBadge(3)


    // Companion object
    TestClass.create()
}

open class CleanUpRobot {
    public open val speed: Int = 10

    fun start() {
        println("Starting with speed $speed")
    }
}

interface Pluggable {
    fun plug()
    fun unplug()
}

object BadgeProvider {

    val receivers = mutableListOf<BadgeReceiver>()

    fun registerReceiver(receiver: BadgeReceiver) {
        receivers.add(receiver)
    }

    fun notifyBadge(count: Int) {
        for (receiver in receivers) {
            receiver.onReceive(count);
        }
    }
}

interface BadgeReceiver {
    fun onReceive(count: Int)
}

interface Factory<T> {
    fun create(): T
}

class TestClass {
    companion object : Factory<TestClass> {
        override fun create(): TestClass = TestClass()
    }
}
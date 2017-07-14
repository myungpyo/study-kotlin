package com.smp.kotlin.jvm

//////////////////////////////////////////////////////////////////////////////
// Tests
//////////////////////////////////////////////////////////////////////////////

fun main(args : Array<String>) {

    val tom = Magician()
    tom.run()
    tom.fly()

    // Resolving implementation conflicts
    val knifeGun = KnifeGun()
    knifeGun.attack()
}

interface Flyable {
    fun fly()
}

interface Runnable {
    val speed: Int // abstract
    val maxDistance: Int
        get() = 100

    fun run() {
        println("Run! Run!")
    }
}

class Magician : Flyable, Runnable {

    override val speed: Int
        get() = 50

    override val maxDistance: Int
        get() = 200

    override fun fly() {
        println("Fly! Fly!")
    }
}

interface Weapon {
    fun attack()
}

interface Gun : Weapon {
    override fun attack() {
        println("Bang! Bang!")
    }
}

interface Knife : Weapon {
    override fun attack() {
        println("Chang! Chang!")
    }
}

class KnifeGun : Gun, Knife {

    override fun attack() {
        super<Gun>.attack()
        super<Knife>.attack()
    }
}

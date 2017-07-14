package com.smp.kotlin.jvm

//////////////////////////////////////////////////////////////////////////////
// Tests
//////////////////////////////////////////////////////////////////////////////

fun main(args : Array<String>) {

    val robot1 = Robot("Richard", 50, 80)
    val robot2 = Robot( "Tomas", 20)
    val robot3 = Robot( "Jack")
    val robot4 = FarmerRobot("Peter")
    val robot5 = VillainRobot("Chris")
    val robot6 = RocketRobot("David")

    robot1.printSpec()
    robot2.printSpec()
    robot3.printSpec()

    robot1.operate()
    robot4.operate()

    robot5.printSpec()
    println(robot5.manufacturer)
    robot5.operate()

    robot6.fly()

}

open class Robot constructor(val name: String, val power: Int, val speed: Int) {

    val serialNumber: String
    open val manufacturer: String = "SMP"

    constructor(name: String, power: Int) : this(name, power, 1)

    constructor(name: String) : this(name, 1, 1)

    init {
        serialNumber = "S-N.$name-P.$power-S.$speed"
    }

    open fun printSpec() {
        println("$name has $power power and $speed speed (Serial : $serialNumber).")
    }

    open fun operate() {
        println("I don't know what to do.")
    }
}

class FarmerRobot constructor(name: String) : Robot(name) {


    override fun operate() {
        println("Farming...")
    }
}

open class VillainRobot constructor(name: String) : Robot(name) {

    override val manufacturer: String = "Unknown"

    final override fun printSpec() {
        println("Printing spec is prohibited.")
    }

    override fun operate() {
        println("Extorting...")
    }
}

abstract class FlyableRobot (name: String) : Robot(name) {

    abstract fun fly()
}

class RocketRobot (name: String) : FlyableRobot(name) {

    override fun fly() {
        println("Flying~~~~")
    }
}
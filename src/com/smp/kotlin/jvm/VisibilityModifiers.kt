package com.smp.kotlin.jvm

//////////////////////////////////////////////////////////////////////////////
// Tests
//////////////////////////////////////////////////////////////////////////////

private fun test1() {} // Visible in this file

public var test2: Int = 10 // Visible everywhere except Setter
    private set

internal val test3 = 5 // Visible inside the same module

fun main(args : Array<String>) {



}

open class Father {
    private val money = 1000
    protected val age = 30
    internal val location = "L.A."
    val name = "Robert"

    protected class Nested {
        public val test: Int = 10
    }
}

class Child : Father() {

    fun askFathersAge(): Int {
        return super.age
    }
}

class Boss(var employee: Father) {

    fun findEmployee(): String {
        return employee.location
    }
}
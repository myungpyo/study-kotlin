package com.smp.kotlin.jvm

//////////////////////////////////////////////////////////////////////////////
// Tests
//////////////////////////////////////////////////////////////////////////////

fun main(args : Array<String>) {

    val list = mutableListOf(1, 2, 3, 4, 5)
    list.swap(0, 1)

    println(list)

    // Extensions are resolved statically
    printTest(MockSomeClass())

    // Extension function can not override member function
    SomeClass().printSum(1, 2)

    // Extension property
    println("Extension property : ${SomeClass().id}")

    // Companion function extension
    SomeClass.sayHi()

    // Member extension
    DispatchReceiver().test(ExtensionReceiver())

    // Override member extension (virtual with regard to DispatchReceiver, static with regard to ExtensionReceiver)
    C().caller(D())
    C1().caller(D())
    C().caller(D1())
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {

    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}


open class SomeClass {

    companion object {}

    open fun printSum(val1: Int, val2: Int) {
        println("$val1 + $val2 = ${val1 + val2}")
    }
}

class MockSomeClass: SomeClass()

fun SomeClass.printName() = println("SomeClass !")

fun MockSomeClass.printName() = println("MockSomeClass !")

fun SomeClass.printSum(val1: Int, val2: Int) = println("I don't know")

val SomeClass.id: Int
    get() = 100

fun SomeClass.Companion.sayHi() {
    println("Hi !")
}

fun printTest(someClass: SomeClass) {
    someClass.printName()
}

class ExtensionReceiver

class DispatchReceiver {

    fun ExtensionReceiver.prepare() {
        println("Extension receiver is prepared.")
        this@DispatchReceiver.prepare()
    }

    fun prepare() {
        println("Dispatch receiver is prepared.")
    }

    fun test(receiver: ExtensionReceiver) {
        receiver.prepare()
    }

}


open class D

class D1 : D()

open class C {
    open fun D.foo() {
        println("D.foo in C")
    }

    open fun D1.foo() {
        println("D1.foo in C")
    }

    fun caller(d: D) {
        d.foo()   // call the extension function
    }
}

class C1 : C() {
    override fun D.foo() {
        println("D.foo in C1")
    }

    override fun D1.foo() {
        println("D1.foo in C1")
    }
}
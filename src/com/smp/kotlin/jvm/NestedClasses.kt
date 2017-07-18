package com.smp.kotlin.jvm

fun main(args : Array<String>) {


    registerListener(object: OnClickListener {
        override fun onClick(id: Int) {
            println("$id clicked")
        }
    })

    // Java Functional Interface can be used like below.
    val listener = JavaOnClickListener { id -> println("$id clicked")}


}

class SeparatedOuter {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

class ReferencedOuter {
    private val bar: Int = 1
    inner class Nested {
        fun foo() = bar
    }
}

interface OnClickListener {
    fun onClick(id : Int)
}

fun registerListener(listener: OnClickListener) {

}
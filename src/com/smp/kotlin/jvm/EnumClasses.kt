package com.smp.kotlin.jvm

fun main(args : Array<String>) {

    val enum = State.valueOf("INITIALIZED")
    println(enum)

    println("===")
    for (enumValue in State.values()) {
        println("$enumValue : isInitialized : ${enumValue.isInitialized()}")
    }
    println("===")


}


enum class State(val bit: Int) {
    NOT_INITIALIZED(0x00000001) {
        override fun isInitialized(): Boolean {
            return false
        }
    },
    IN_PROGRESS(0x00000002) {
        override fun isInitialized(): Boolean {
            return false
        }
    },
    INITIALIZED(0x00000004) {
        override fun isInitialized(): Boolean {
            return true
        }
    };

    abstract fun isInitialized(): Boolean
}
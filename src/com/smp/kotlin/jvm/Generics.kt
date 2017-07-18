package com.smp.kotlin.jvm

fun main(args : Array<String>) {





}

abstract class CustomIterable<out T> {
    abstract fun next(): T
    abstract fun hasNext(): Boolean
}

abstract class CustomComparable<in T> {
    abstract fun compare(value : T) : Int
}

fun copy(from: Array<out Any>, to: Array<Any>) {

}

fun fill(dest: Array<in String>, value: String) {

}
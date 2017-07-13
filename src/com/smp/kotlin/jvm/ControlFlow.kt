package com.smp.kotlin.jvm

//////////////////////////////////////////////////////////////////////////////
// Tests
//////////////////////////////////////////////////////////////////////////////

fun main(args : Array<String>) {
    // If is an expression
    var arg1 = 1
    var arg2 = 2
    val result = if (arg1 > arg2) "$arg1 > $arg2" else "$arg1 < $arg2" // Also can use blocks using braces { }
    println(result)

    // When pattern matching
    val arg3: Any = 'a'
    when (arg3) {
        in 1..10 -> println("1 <= ($arg3) <= 10")
        in 'a'..'z' -> println("Alphabet")
        is Float -> println("Float")
        !is Long -> println("not Long")
        else -> println("I don't know")
    }

    // for loop
    val array1 = arrayOf(1, 2, 3, 4, 5)
    for (element in array1) {
        print("$element, ")
    }
    print("\n")

    for (index in array1.indices) {
        print("${array1[index]}, ")
    }
    print("\n")

    for ((index, element) in array1.withIndex()) {
        print("[$index] = $element, ")
    }
    print("\n")


}
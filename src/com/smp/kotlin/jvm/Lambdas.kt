package com.smp.kotlin.jvm

fun main(args: Array<String>) {

    // High order function
    val result = calculate(3, 5) {
        val1, val2 -> val1 + val2
    }
    println("3 + 5 = $result")

    // Function reference
    println("5 - 3 = ${calculate(5, 3, ::subtract)}")


    // Qualified return
    val ints = arrayOf(1, 2, 3, 4, 5)
    var filteredResult = ints.filter {
        val shouldFilter = it % 2 != 0
        return@filter shouldFilter
    }
    println(filteredResult)

    // Anonymous function
    filteredResult = ints.filter(fun(item) = item % 2 == 0)
    println(filteredResult)

    // Using closure
    var sumResult = 0
    ints.filter { it % 2 == 0 }.forEach {
        sumResult += it
    }
    print(sumResult)

    // Function literal
    val sum = fun Int.(other: Int): Int = this + other
    println("1 + 2 = ${1.sum(2)}")



}

fun calculate(val1: Int, val2: Int, operation: (val1: Int, val2:Int) -> Int): Int {
    return operation(val1, val2)
}

fun subtract(val1: Int, val2: Int) : Int {
    return val1 - val2
}


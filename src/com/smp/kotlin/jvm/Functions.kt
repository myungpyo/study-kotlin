package com.smp.kotlin.jvm

fun main(args: Array<String>) {

    // Calling overridden method that has default parameter value
    val messagePrinter = MySimplePrinter()
    messagePrinter.printWithSurroundings("This is test message")

    // Using named argument
    messagePrinter.printWithSurroundings(
            "Wow!!",
            prefix = "<",
            suffix = ">")

    // Using single expression function
    messagePrinter.print("This is single expression function.")

    // Using infix function
    messagePrinter print "This message"

    // Sum integers
    println("sum (1~5) = ${sum(1, 2, 3, 4, 5)}")

    // Sum integers using spread operator
    val arr = intArrayOf(6, 7, 8, 9, 10)
    println("sum (1~10) = ${sum(1, 2, 3, 4, 5, *arr)}")

    // High order function
    println("sum (1~30) = ${sumInRanges(Pair(1,10), Pair(11, 20), Pair(21, 30))}")

}

open class BasePrinter {

    open infix fun print(message: String) = println(message)

    open fun printWithSurroundings(message: String, prefix: String = "[", suffix: String = "]") {
        println("$prefix$message$suffix")
    }
}

class MySimplePrinter : BasePrinter() {

    override fun printWithSurroundings(message: String, prefix: String, suffix: String) {
        super.printWithSurroundings(message, prefix, suffix)
    }
}

fun sum(vararg number: Int): Int {
    return number.reduce{acc, num -> acc + num}
}

fun sumInRanges(vararg ranges: Pair<Int, Int>): Int {
    var result: Int = 0

    fun sumInRange(from: Int, to: Int) {
        for (num in from..to) {
            result += num
        }
    }

    for (rangePair in ranges) {
        sumInRange(rangePair.first, rangePair.second)
    }

    return result
}
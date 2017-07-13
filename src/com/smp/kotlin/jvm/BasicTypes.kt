package com.smp.kotlin.jvm

import java.util.*

//////////////////////////////////////////////////////////////////////////////
// Extensions
//////////////////////////////////////////////////////////////////////////////

fun String.repeat(count: Int): String {
    var result = ""

    for (i in 0..count) {
        result += this
    }

    return result;
}

fun Int.toBinaryString(bitCount: Int): String {
    val binString = Integer.toBinaryString(this)
    val format = java.text.DecimalFormat("0".repeat(bitCount))
    return format.format(Integer.parseInt(binString))
}

fun <T> Array<T>.print(): String {
    return Arrays.toString(this)
}

//////////////////////////////////////////////////////////////////////////////
// Tests
//////////////////////////////////////////////////////////////////////////////

fun main(args : Array<String>) {

    // Types
    val intVal = 1_000_000
    val longVal = 1234_5678_9012_345L
    val doubleVal = 3.141582
    val floatVal = 3.141592f
    val shortVal: Short = 10
    val byteVal: Byte = 1

    println("Type of value intVal : ${intVal::class.qualifiedName}")
    println("Type of value longVal : ${longVal::class.qualifiedName}")
    println("Type of value doubleVal : ${doubleVal::class.qualifiedName}")
    println("Type of value floatVal : ${floatVal::class.qualifiedName}")
    println("Type of value shortVal : ${shortVal::class.qualifiedName}")
    println("Type of value byteVal : ${byteVal::class.qualifiedName}")

    // Identity
    val val1: Int? = 1_000
    val val2: Int? = 1_000

    println("val1 == val2 = ${val1 == val2}")
    println("val1 === val2 = ${val1 === val2}")

    // Smaller types are not subtypes of bigger one
    val val3: Int? = 1
    val val4: Long? = 1
//    println("val3 == val4 = ${val3 == val4}")

    // Operators
    val val5 = 0x00000010

    println("$val5 signed shift left 1 = ${(val5 shl 1).toBinaryString(8)}")
    println("$val5 signed shift right 1 = ${(val5 shr 1).toBinaryString(8)}")
    println("$val5 unsigned shift right = ${(val5 ushr 1).toBinaryString(8)}")
    println("$val5 & 1 = ${(val5 and 1).toBinaryString(8)}")
    println("$val5 | 1 = ${(val5 or 1).toBinaryString(8)}")
    println("$val5 ^ 1 = ${(val5 xor 1).toBinaryString(8)}")
//    println("~$val5 = ${(val5.inv()).toBinaryString(8)}") // Overflow


    // Array<T>
    val array1 = arrayOf(1, 2, 3, 4, 5)
    val array2 = arrayOfNulls<Int>(5)
    val array3 = Array(5, { i -> i + 1})
    val array4 = intArrayOf(1, 2, 3, 4, 5)

    println("array1 = ${array1.print()}")
    println("array2 = ${array2.print()}")
    println("array3 = ${array3.print()}")
    println("primitive array4 = ${array3.print()}")

    // String is iterable
    val text = "What a great day"
    for (char in text) {
        print("$char,")
    }

}
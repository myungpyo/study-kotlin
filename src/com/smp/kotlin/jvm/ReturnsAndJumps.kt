package com.smp.kotlin.jvm

//////////////////////////////////////////////////////////////////////////////
// Tests
//////////////////////////////////////////////////////////////////////////////

var intArray = arrayOf(1, 2, 3, 4, 5)

fun main(args : Array<String>) {

    val nullableNameValue :String? = null
    val val1 = try {
        nullableNameValue ?: fail("Name required")
    } catch (e: Exception) {
        println("Exception : $e")
    }

    println("Type of value intVal : ${val1::class.qualifiedName}")

    // Label
    outerLoop@ for (i1 in 1..5) {
        innerLoop@ for (i2 in 'a'..'e') {

            if (i1 == 2 && i2 == 'c') break@outerLoop

            print("$i1 - $i2, ")
        }
    }
    print("\n")

    // Return at Labels
    iDontKnowMoreThan3()
    print("\n")



}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun iDontKnowMoreThan3() {
    intArray.forEach lit@{
        if (it > 3) {
            print("I don't know $it, ")
//            return  // return the most outer block
//            return@forEach
            return@lit
        }

        print("$it, ")
    }
}
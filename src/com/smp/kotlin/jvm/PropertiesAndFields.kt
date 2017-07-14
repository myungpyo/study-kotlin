package com.smp.kotlin.jvm

//////////////////////////////////////////////////////////////////////////////
// Tests
//////////////////////////////////////////////////////////////////////////////

const val STRUCTURE_DEPRECATED = "This structure is deprecated"

fun main(args : Array<String>) {

    val point = Point(3, 5)
    println(point.stringRepresentation)
    point.stringRepresentation = "x:6,y:10"
    println(point.stringRepresentation)

    val counter = Counter()
    counter.count = 1
    println("After setting value 1 : ${counter.count}")
    counter.count = -1
    println("After setting value -1 : ${counter.count}")

}

class Point (var x: Int, var y: Int) {

    var stringRepresentation: String
        get() = "x:$x,y:$y"
        set(value) {
            val splitted = value.split(",")
            x = splitted[0].substring(2).toInt()
            y = splitted[1].substring(2).toInt()
        }

    // Can omit type if it can be inferred by Getter
    val isZero get() = x == 0 && y == 0
}

class Counter {
    var count = 0
        set(value) {
//            count = value // This means recursive property accessor
            if (count >= 0) field = value

        }
}

@Deprecated(STRUCTURE_DEPRECATED)
class SinglePoint(var x: Int)

class HeavyStuff
class HeavyStuffTest {
    lateinit var heavyStuff: HeavyStuff

    fun setup() {
        heavyStuff = HeavyStuff()
    }

    fun test() {
        heavyStuff.toString()
    }

}
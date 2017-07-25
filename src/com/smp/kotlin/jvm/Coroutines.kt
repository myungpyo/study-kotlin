package com.smp.kotlin.jvm

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.buildSequence

//////////////////////////////////////////////////////////////////////////////
// Tests
//////////////////////////////////////////////////////////////////////////////

fun log(message: String) {
    println("Thread(${Thread.currentThread().name}) $message")
}

fun main(args : Array<String>) = runBlocking {

    val result1 = async(CommonPool + CoroutineName("coroutine_1")) {
        log("coroutine_1 is started.")
        delay(500)
        35
    }

    val result2 = async(CommonPool + CoroutineName("coroutine_2")) {
        log("coroutine_2 is started.")
        delay(1000)
        28
    }

    async(CommonPool + CoroutineName("coroutine_3")) {
        log("coroutine_3 is started.")
        log("Result1 is ${result1.await()} and Result2 is ${result2.await()}")
    }

    //Delay to see results
    delay(2000)

    // Print the first three elements of the sequence
    lazySeq.take(3).forEach { print("$it ") }

}

val lazySeq = buildSequence {
    print("START ")
    for (i in 1..5) {
        yield(i)
        print("STEP ")
    }
    print("END")
}


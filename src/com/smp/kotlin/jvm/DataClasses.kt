package com.smp.kotlin.jvm

fun main(args : Array<String>) {

    val user1 = User("Tom", 13, "A")
    val user2 = User("Tom", 13, "A")

    println("User1 : $user1, User2 : $user2 : Equals : ${user1 == user2}")
    println("component1 of User1 ${user1.component1()}")
    println("component2 of User1 ${user1.component2()}")

    val user3 = user1.copy(age = 15)
    println("2 years older Tom : $user3")

    // Destructuring
    val (name, _, bloodType) = user1
    println("$name's blood type is $bloodType")

}

data class User(val name: String, val age: Int, val bloodType: String)
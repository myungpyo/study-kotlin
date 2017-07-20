package com.smp.kotlin.jvm

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

var needHeavyCalculation = false

fun main(args : Array<String>) {

    val message = ChatMessage("Tom", "Hi! Buddy!")

    println(message.nameDelegatedMessage)
    message.nameDelegatedMessage = "Jane"
    println(message.nameDelegatedMessage)

    // Delegation : lazy
    val hasBigString = HasBigString()
    println(hasBigString.bigString)
    println(hasBigString.bigString)

    // Delegation : observable
    val hasObservableString = HasObservableString()
    hasObservableString.observableString = "NewString1"
    hasObservableString.observableString = "NewString2"
    println(hasObservableString.observableString)

    // Delegation : vetoable
    val hasVetoableString = HasVetoableString()
    hasVetoableString.vetoableString = "NewString1"
    println(hasVetoableString.vetoableString)

    // Delegation : map
    val mappedUser = MappedUserClass(mapOf(
            "id" to 1,
            "name" to "John",
            "age" to 30
    ))
    println("ID : ${mappedUser.id}, Name : ${mappedUser.name}, Age : ${mappedUser.age}")

    // Local Delegation : lazy
    localLazyVariableExample {
        println("Heavy calculation done.")
        "HeavyResult : Heavy Heavy !!"
    }

    needHeavyCalculation = true
    localLazyVariableExample {
        println("Heavy calculation done.")
        "HeavyResult : Heavy Heavy !!"
    }

    // Providing delegate
    println(message.nameDelegatedWithProviderMessage)
    message.nameDelegatedWithProviderMessage = "Robert"
    println(message.nameDelegatedWithProviderMessage)
}

data class ChatMessage (var userName: String, var message: String) {
    var nameDelegatedMessage: String by NameTaggingDelegate()
    var nameDelegatedWithProviderMessage: String by NameTaggingDelegateWithProvider()
}

class NameTaggingDelegate {

    operator fun getValue(thisRef: ChatMessage?, property: KProperty<*>): String {
        thisRef ?: return ""

        return "${thisRef.userName} : ${thisRef.message}"
    }

    operator fun setValue(thisRef: ChatMessage?, property: KProperty<*>, value: String) {
        thisRef ?: return

        thisRef.userName = value
    }
}

class NameTaggingDelegateWithProvider : ReadWriteProperty<ChatMessage, String> {

    operator fun provideDelegate(thisRef: ChatMessage?, property: KProperty<*>): ReadWriteProperty<ChatMessage, String> {

        return this
    }

    override fun getValue(thisRef: ChatMessage, property: KProperty<*>): String {

        return "${thisRef.userName} : ${thisRef.message}"
    }

    override fun setValue(thisRef: ChatMessage, property: KProperty<*>, value: String) {

        thisRef.userName = value
    }
}


class HasBigString {
    val bigString: String by lazy {
        println("Big string has been generated")
        "Big Big String!!"
    }

}

class HasObservableString {
    var observableString: String by Delegates.observable("Empty") {
        prop, old, new ->
        println("The value of ${prop.name} has been changed from $old to $new.")
    }
}

class HasVetoableString {
    var vetoableString: String by Delegates.vetoable("Empty") {
        prop, old, new ->
        println("Someone tried to change the value of ${prop.name} from $old to $new. But I vetoed it.")
        false
    }
}

class MappedUserClass(val map: Map<String, Any?>) {
    val id: Int by map
    val name: String by map
    val age: Int by map
}

fun localLazyVariableExample(someHeavyCalculation: () -> String) {
    val heavilyCalculatedValue by lazy(someHeavyCalculation)

    if (needHeavyCalculation && heavilyCalculatedValue.startsWith("HeavyResult")) {
        println(heavilyCalculatedValue)
    }
}


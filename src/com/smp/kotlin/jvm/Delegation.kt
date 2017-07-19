package com.smp.kotlin.jvm

fun main(args : Array<String>) {

    TripleRobotGun(RobotGunImpl()).tripleFire()

}

interface RobotGun {
    fun fire()
}

class RobotGunImpl : RobotGun {
    override fun fire() {
        println("Tang!")
    }
}

class TripleRobotGun(robotGun: RobotGun) : RobotGun by robotGun {

    fun tripleFire() {
        for (i in 0..2) {
            fire()
        }
    }
}
package com.smp.kotlin.jvm

fun main(args : Array<String>) {


    logKnownResponse(AdminApiResponse(3_000_000L))
    logKnownResponse(UserApiResponse("John"))


}

sealed class BaseApiResponse

data class AdminApiResponse (val availableQuota: Long): BaseApiResponse()
data class UserApiResponse (val name: String): BaseApiResponse()
object UnknownApiResponse : BaseApiResponse()

fun logKnownResponse(apiResponse: BaseApiResponse) = when(apiResponse) {
    is AdminApiResponse -> println("Admin response : availableQuota : ${apiResponse.availableQuota}")
    is UserApiResponse -> println("User response : name : ${apiResponse.name}")
    UnknownApiResponse -> println("Unknown response : skipped")
}
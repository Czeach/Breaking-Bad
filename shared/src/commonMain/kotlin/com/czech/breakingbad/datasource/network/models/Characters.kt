package com.czech.breakingbad.datasource.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Characters(
    @SerialName("char_id")
    val charId: Int = 0,
    @SerialName("name")
    val name: String = "",
    @SerialName("birthday")
    val birthday: String = "",
    @SerialName("occupation")
    val occupation: List<String> = listOf(),
    @SerialName("img")
    val img: String = "",
    @SerialName("status")
    val status: String = "",
    @SerialName("nickname")
    val nickname: String = "",
    @SerialName("appearance")
    val appearance: List<Int> = listOf(),
    @SerialName("portrayed")
    val portrayed: String = "",
    @SerialName("category")
    val category: String = "",
    @SerialName("better_call_saul_appearance")
    val betterCallSaulAppearance: List<Int> = listOf()
)
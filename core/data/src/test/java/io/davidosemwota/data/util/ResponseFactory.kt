package io.davidosemwota.data.util

import io.davidosemwota.data.network.responses.AppearanceResponse

fun generateGender() = listOf("Female", "Male", "Binary").random()
fun generateRace()  = listOf("African").random()
fun generateHeight()  = listOf( listOf("6.1", "185 cm"), listOf("5.7", "167 cm") )
        .random()
fun generateWeight()  = listOf( listOf("22 KG", " 5 pounds"), listOf("34 KG", " 7 pounds") )
        .random()
fun generateEyeColor()  = listOf("green", "Brown", "Black", "Blue").random()
fun generateHairColor()  = listOf("purple","Black", "Blonde").random()

fun getAppearanceResponse() = AppearanceResponse(
        gender = generateGender(),
        race = generateRace(),
        height = generateHeight(),
        weight = generateWeight(),
        eyeColor = generateEyeColor(),
        hairColor = generateHairColor()
)
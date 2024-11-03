package com.leoapps.home.base.domain

import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.EnumParam.entries
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam2
import kotlin.random.Random

fun getRandomInt() = Random.nextInt()

fun getRandomBoolean() = Random.nextBoolean()

fun getRandomString() = "Lorem ipsum dolor sit amet".substring(Random.nextInt(0, 20))

fun getRandomEnumParamValue(): EnumParam {
    return entries.toTypedArray().random()
}

fun getRandomHomeCustomParam1() = HomeCustomParam1(
    value1 = getRandomBoolean(),
    value2 = getRandomEnumParamValue(),
)

fun getRandomHomeCustomParam2() = HomeCustomParam2(
    value1 = getRandomString(),
    value2 = getRandomInt(),
    value3 = getRandomHomeCustomParam1(),
)
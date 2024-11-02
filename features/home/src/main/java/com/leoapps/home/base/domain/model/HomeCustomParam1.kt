package com.leoapps.home.base.domain.model

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class HomeCustomParam1(
    val value1: Boolean,
    val value2: EnumParam,
) : java.io.Serializable

object HomeCustomParam1NavType : NavType<HomeCustomParam1>(
    isNullableAllowed = false
) {
    override fun get(bundle: Bundle, key: String): HomeCustomParam1? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): HomeCustomParam1 {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun serializeAsValue(value: HomeCustomParam1): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun put(bundle: Bundle, key: String, value: HomeCustomParam1) {
        bundle.putString(key, Json.encodeToString(value))
    }
}

object HomeCustomParam1ListNavType : NavType<List<HomeCustomParam1>>(
    isNullableAllowed = false
) {
    override fun get(bundle: Bundle, key: String): List<HomeCustomParam1>? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): List<HomeCustomParam1> {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun serializeAsValue(value: List<HomeCustomParam1>): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun put(bundle: Bundle, key: String, value: List<HomeCustomParam1>) {
        bundle.putString(key, Json.encodeToString(value))
    }
}
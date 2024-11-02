package com.leoapps.home.base.domain.model

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class HomeCustomParam2(
    val value1: String,
    val value2: Int,
    val value3: HomeCustomParam1,
)

object HomeCustomParam2NavType : NavType<HomeCustomParam2>(
    isNullableAllowed = false
) {
    override fun get(bundle: Bundle, key: String): HomeCustomParam2? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): HomeCustomParam2 {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun serializeAsValue(value: HomeCustomParam2): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun put(bundle: Bundle, key: String, value: HomeCustomParam2) {
        bundle.putString(key, Json.encodeToString(value))
    }
}

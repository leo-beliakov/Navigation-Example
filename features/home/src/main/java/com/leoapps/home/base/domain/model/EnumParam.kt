package com.leoapps.home.base.domain.model

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

enum class EnumParam {
    VALUE1,
    VALUE2,
    VALUE3
}

object EnumParamListNavType : NavType<List<EnumParam>>(
    isNullableAllowed = false
) {
    override fun get(bundle: Bundle, key: String): List<EnumParam>? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): List<EnumParam> {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun serializeAsValue(value: List<EnumParam>): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun put(bundle: Bundle, key: String, value: List<EnumParam>) {
        bundle.putString(key, Json.encodeToString(value))
    }
}
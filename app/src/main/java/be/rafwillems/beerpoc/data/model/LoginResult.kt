package be.rafwillems.beerpoc.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LoginResult(@Json(name = "success") val success: Boolean) : Parcelable

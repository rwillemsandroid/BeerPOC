package be.rafwillems.beerpoc.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Brewery(
        @Json(name = "id") val id: String,
        @Json(name = "name") val name: String,
        @Json(name = "address") val address: String,
        @Json(name = "description") val description: String) : Parcelable

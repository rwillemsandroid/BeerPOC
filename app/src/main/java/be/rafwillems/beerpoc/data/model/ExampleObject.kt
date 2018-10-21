package be.rafwillems.beerpoc.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ExampleObject(
        @Json(name = "id") val id: String,
        @Json(name = "text")val text: String) : Parcelable

package ru.nsu.lightweight.punchclub.dataBase.fighter

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import ru.nsu.lightweight.punchclub.map.BaseMarker

@Entity(tableName = "fighter_table")
data class Fighter(
    @PrimaryKey
    val id: Long,
    val avatarUrl: String,
    val name: String,
    val description: String,
    val age: Int,
    val lat: Double,
    val lng: Double
) {

    fun toMarker() = BaseMarker(
        id = id,
        latLng = LatLng(lat, lng),
        avatarUrl = avatarUrl,
        name = name,
        description = description,
        age = age
    )
}
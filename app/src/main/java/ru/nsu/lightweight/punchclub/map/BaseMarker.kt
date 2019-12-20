package ru.nsu.lightweight.punchclub.map

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem
import ru.nsu.lightweight.punchclub.dataBase.fighter.Fighter

open class BaseMarker(
    val id: Long,
    val latLng: LatLng,
    val avatarUrl: String,
    val name: String,
    val description: String,
    val age: Int
) : ClusterItem {

    override fun getTitle(): String {
        return id.toString()
    }

    override fun getSnippet(): String {
        return id.toString()
    }

    override fun getPosition(): LatLng {
        return latLng
    }

    fun toFighter() = Fighter(
        id = id,
        lat = latLng.latitude,
        lng = latLng.longitude,
        avatarUrl = avatarUrl,
        name = name,
        description = description,
        age = age
    )
}
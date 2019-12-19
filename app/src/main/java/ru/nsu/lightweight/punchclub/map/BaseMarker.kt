package ru.nsu.lightweight.punchclub.map

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

open class BaseMarker(
    val id: Long,
    val latLng: LatLng
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
}
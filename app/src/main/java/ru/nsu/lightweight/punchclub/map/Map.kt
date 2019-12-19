package ru.nsu.lightweight.punchclub.map

import com.google.android.gms.maps.model.LatLng

interface Map<T : BaseMarker> {

    fun addMarker(marker: T)
    fun removeMarker(id: Long)
    fun updateVisibleMarkers(markers: Collection<T>)
    fun moveTo(latLng: LatLng, isAnimate: Boolean, zoom: Float? = null)
}
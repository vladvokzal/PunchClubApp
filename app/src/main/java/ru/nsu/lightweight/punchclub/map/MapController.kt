package ru.nsu.lightweight.punchclub.map

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import ru.nsu.lightweight.punchclub.R

class MapController<T : BaseMarker>(
    private val onMarkerClickListener: GoogleMap.OnMarkerClickListener
) : Map<T> {

    private val googleMarkers = mutableMapOf<Long, Marker>()
    private lateinit var map: GoogleMap

    override fun moveTo(latLng: LatLng, isAnimate: Boolean, zoom: Float?) {
        val realZoom = zoom ?: map.cameraPosition.zoom
        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, realZoom)
        when (isAnimate) {
            true -> map.animateCamera(cameraUpdate)
            false -> map.moveCamera(cameraUpdate)
        }
    }

    override fun addMarker(marker: T) {
        val markerOptions = MarkerOptions().apply {
            icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place))
            position(marker.latLng)
            title(marker.id.toString())
        }
        googleMarkers[marker.id] = map.addMarker(markerOptions)
    }

    override fun removeMarker(id: Long) {
        googleMarkers.remove(id)?.remove()
    }

    override fun updateVisibleMarkers(markers: Collection<T>) {
        this.googleMarkers.clear()
        map.clear()
        markers.forEach {
            addMarker(it)
        }
    }

    fun onAttachMainMap(googleMap: GoogleMap) {
        map = googleMap
        map.uiSettings.isMapToolbarEnabled = false
        map.uiSettings.isCompassEnabled = false
        map.setOnMarkerClickListener(onMarkerClickListener)
    }
}
package ru.nsu.lightweight.punchclub.map

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import ru.nsu.lightweight.punchclub.R
import ru.nsu.lightweight.punchclub.dataBase.fighter.Fighter
import ru.nsu.lightweight.punchclub.databinding.ActivityMapBinding
import ru.nsu.lightweight.punchclub.profile.ProfileActivity
import ru.nsu.lightweight.punchclub.punchlist.PunchListActivity
import ru.nsu.lightweight.punchclub.utils.Animation
import ru.nsu.lightweight.punchclub.utils.RouterUtil

class MapActivity : MvpAppCompatActivity(), MapView, OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {

    @InjectPresenter
    lateinit var presenter: MapPresenter
    private lateinit var binding: ActivityMapBinding
    private lateinit var map: Map<BaseMarker>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_map, null, false)
        initUI()
        setContentView(binding.root)
    }

    private fun initUI() {
        val map = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        map.getMapAsync(this)

        RouterUtil.onceClickListener(binding.punchListButton) {
            RouterUtil.startActivity(this, PunchListActivity::class.java, Animation.SLIDE_IN)
        }
        RouterUtil.onceClickListener(binding.profileButton) {
            RouterUtil.startActivity(this, ProfileActivity::class.java, Animation.SLIDE_IN)
        }
    }

    override fun addMarker(marker: BaseMarker) {
        map.addMarker(marker)
    }

    override fun removeMarker(id: Long) {
        map.removeMarker(id)
    }

    override fun updateVisibleMarkers(markers: Collection<BaseMarker>) {
        map.updateVisibleMarkers(markers)
    }

    override fun moveTo(latLng: LatLng, isAnimate: Boolean, zoom: Float?) {
        map.moveTo(latLng, isAnimate, zoom)
    }

    override fun setFighters(fighters: List<Fighter>) {
        map.updateVisibleMarkers(fighters.map { it.toMarker() })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val controller = MapController<BaseMarker>(this)
        controller.onAttachMainMap(googleMap)
        map = controller
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        p0 ?: return true
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("ARG_ID_FIGHTER", p0.title.toLong())
        RouterUtil.startIntent(intent, this, Animation.SLIDE_IN)
        return true
    }
}
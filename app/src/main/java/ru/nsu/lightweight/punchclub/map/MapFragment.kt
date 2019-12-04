package ru.nsu.lightweight.punchclub.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.arellomobile.mvp.MvpAppCompatFragment
import ru.nsu.lightweight.punchclub.R
import ru.nsu.lightweight.punchclub.databinding.FragmentMapBinding

class MapFragment : MvpAppCompatFragment(), MapView {

    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
    }
}
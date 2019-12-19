package ru.nsu.lightweight.punchclub.punchlist

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arellomobile.mvp.MvpAppCompatActivity
import ru.nsu.lightweight.punchclub.R
import ru.nsu.lightweight.punchclub.databinding.ActivityPunchListBinding
import ru.nsu.lightweight.punchclub.profile.ProfileView
import ru.nsu.lightweight.punchclub.utils.Animation
import ru.nsu.lightweight.punchclub.utils.RouterUtil

class PunchListActivity : MvpAppCompatActivity(), ProfileView {

    private lateinit var binding: ActivityPunchListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_punch_list, null, false)
        initUI()
        setContentView(binding.root)
    }

    private fun initUI() {
        binding.toolbar.back.setOnClickListener {
            onBackPressed()
        }
        binding.toolbar.title.setText(R.string.punch_list)
    }

    override fun finish() {
        super.finish()
        RouterUtil.setCustomAnimation(this, Animation.SLIDE_OUT)
    }
}
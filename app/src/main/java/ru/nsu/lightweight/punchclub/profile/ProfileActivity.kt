package ru.nsu.lightweight.punchclub.profile

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arellomobile.mvp.MvpAppCompatActivity
import ru.nsu.lightweight.punchclub.R
import ru.nsu.lightweight.punchclub.databinding.ActivityProfileBinding
import ru.nsu.lightweight.punchclub.utils.Animation
import ru.nsu.lightweight.punchclub.utils.RouterUtil

class ProfileActivity : MvpAppCompatActivity(), ProfileView {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_profile, null, false)
        initUI()
        setContentView(binding.root)
    }

    private fun initUI() {
        binding.toolbar.back.setOnClickListener {
            onBackPressed()
        }
        binding.toolbar.title.setText(R.string.profile)
    }

    override fun finish() {
        super.finish()
        RouterUtil.setCustomAnimation(this, Animation.SLIDE_OUT)
    }
}
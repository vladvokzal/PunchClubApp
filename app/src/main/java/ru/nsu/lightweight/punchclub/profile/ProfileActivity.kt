package ru.nsu.lightweight.punchclub.profile

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.nsu.lightweight.punchclub.R
import ru.nsu.lightweight.punchclub.dataBase.fighter.Fighter
import ru.nsu.lightweight.punchclub.databinding.ActivityProfileBinding
import ru.nsu.lightweight.punchclub.utils.Animation
import ru.nsu.lightweight.punchclub.utils.RouterUtil

class ProfileActivity : MvpAppCompatActivity(), ProfileView {

    @InjectPresenter
    lateinit var presenter: ProfilePresenter
    private lateinit var binding: ActivityProfileBinding

    private val requestOptions = RequestOptions()
        .centerCrop()
        .dontAnimate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_profile, null, false)
        initUI()
        setContentView(binding.root)
    }

    override fun showFighter(fighter: Fighter) {
        binding.name.text = fighter.name
        binding.age.text = fighter.age.toString()
        binding.description.text = fighter.description
        Glide.with(binding.avatar)
            .load(fighter.avatarUrl)
            .apply(requestOptions)
            .into(binding.avatar)
    }

    private fun initUI() {
        val id = intent.getLongExtra("ARG_ID_FIGHTER", 0)
        presenter.loadFighterProfile(id)

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
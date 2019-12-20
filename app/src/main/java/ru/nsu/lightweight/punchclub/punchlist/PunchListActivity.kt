package ru.nsu.lightweight.punchclub.punchlist

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.nsu.lightweight.punchclub.R
import ru.nsu.lightweight.punchclub.dataBase.fighter.Fighter
import ru.nsu.lightweight.punchclub.databinding.ActivityPunchListBinding
import ru.nsu.lightweight.punchclub.databinding.ItemPunchListFighterBinding
import ru.nsu.lightweight.punchclub.profile.ProfileActivity
import ru.nsu.lightweight.punchclub.recycler.RecyclerAdapter
import ru.nsu.lightweight.punchclub.utils.Animation
import ru.nsu.lightweight.punchclub.utils.RouterUtil

class PunchListActivity : MvpAppCompatActivity(), PunchListView {

    @InjectPresenter
    lateinit var presenter: PunchListPresenter
    private lateinit var binding: ActivityPunchListBinding
    private lateinit var adapter: RecyclerAdapter<Fighter, ItemPunchListFighterBinding>

    private val requestOptions = RequestOptions()
        .centerCrop()
        .dontAnimate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_punch_list, null, false)
        initUI()
        setContentView(binding.root)
    }

    override fun setFighters(fighters: List<Fighter>) {
        adapter.setElements(fighters)
    }

    private fun initUI() {
        binding.toolbar.back.setOnClickListener {
            onBackPressed()
        }
        binding.toolbar.title.setText(R.string.punch_list)
        adapter = RecyclerAdapter(
            layoutRes = R.layout.item_punch_list_fighter,
            listener = { fighter, _ ->
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("ARG_ID_FIGHTER", fighter.id)
                RouterUtil.startIntent(intent, this, Animation.SLIDE_IN)
            },
            binder = { fighter, bind ->
                bind.name.text = fighter.name
                bind.description.text = fighter.description
                Glide.with(bind.avatar)
                    .load(fighter.avatarUrl)
                    .apply(requestOptions)
                    .into(bind.avatar)
            }
        )
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
    }

    override fun finish() {
        super.finish()
        RouterUtil.setCustomAnimation(this, Animation.SLIDE_OUT)
    }
}
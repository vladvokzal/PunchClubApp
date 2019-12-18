package ru.nsu.lightweight.punchclub.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.nsu.lightweight.punchclub.R
import ru.nsu.lightweight.punchclub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_main, null, false)
        initUI()
        setContentView(binding.root)
    }

    private fun initUI() {
        binding.bottomNavigationView.setupWithNavController(
            Navigation.findNavController(
                this,
                R.id.main_nav_host_fragment
            )
        )
    }
}

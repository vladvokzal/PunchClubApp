package ru.nsu.lightweight.punchclub.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.nsu.lightweight.punchclub.R
import ru.nsu.lightweight.punchclub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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
    }
}

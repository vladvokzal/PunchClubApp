package ru.nsu.lightweight.punchclub.punchlist

import com.arellomobile.mvp.MvpView
import ru.nsu.lightweight.punchclub.dataBase.fighter.Fighter

interface PunchListView : MvpView {

    fun setFighters(fighters: List<Fighter>)
}
package ru.nsu.lightweight.punchclub.profile

import com.arellomobile.mvp.MvpView
import ru.nsu.lightweight.punchclub.dataBase.fighter.Fighter

interface ProfileView : MvpView {

    fun showFighter(fighter: Fighter)
}
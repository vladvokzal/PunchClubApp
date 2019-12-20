package ru.nsu.lightweight.punchclub.map

import com.arellomobile.mvp.MvpView
import ru.nsu.lightweight.punchclub.dataBase.fighter.Fighter

interface MapView : MvpView, Map<BaseMarker> {

    fun setFighters(fighters: List<Fighter>)
}
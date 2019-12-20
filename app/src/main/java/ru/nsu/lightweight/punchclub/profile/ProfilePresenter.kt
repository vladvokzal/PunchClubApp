package ru.nsu.lightweight.punchclub.profile

import com.arellomobile.mvp.InjectViewState
import ru.nsu.lightweight.punchclub.base.BaseMvpPresenter
import ru.nsu.lightweight.punchclub.dataBase.PunchDatabase
import ru.nsu.lightweight.punchclub.rx.RxCommand

@InjectViewState
class ProfilePresenter : BaseMvpPresenter<ProfileView>() {

    fun loadFighterProfile(id: Long) {
        regSubs(RxCommand.makeSingleApiRequest(
            request = id,
            requester = PunchDatabase.getDatabase(),
            function = { request, requester ->
                requester.figterRepository.getFighterById(request)
            },
            onSuccess = {
                if (it.isNotEmpty()) {
                    viewState.showFighter(it[0])
                }
            }
        ))
    }
}
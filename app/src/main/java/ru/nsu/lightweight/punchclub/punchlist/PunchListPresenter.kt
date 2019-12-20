package ru.nsu.lightweight.punchclub.punchlist

import com.arellomobile.mvp.InjectViewState
import ru.nsu.lightweight.punchclub.base.BaseMvpPresenter
import ru.nsu.lightweight.punchclub.dataBase.PunchDatabase
import ru.nsu.lightweight.punchclub.rx.RxCommand

@InjectViewState
class PunchListPresenter : BaseMvpPresenter<PunchListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadFighters()
    }

    private fun loadFighters() {
        regSubs(RxCommand.makeSingleApiRequest(
            request = Unit,
            requester = PunchDatabase.getDatabase(),
            function = { _, requester ->
                requester.figterRepository.getfighters()
            },
            onSuccess = {
                viewState.setFighters(it)
            }
        ))
    }
}
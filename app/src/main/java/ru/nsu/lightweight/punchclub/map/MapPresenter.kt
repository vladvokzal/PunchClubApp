package ru.nsu.lightweight.punchclub.map

import com.arellomobile.mvp.InjectViewState
import ru.nsu.lightweight.punchclub.base.BaseMvpPresenter
import ru.nsu.lightweight.punchclub.dataBase.PunchDatabase
import ru.nsu.lightweight.punchclub.dataBase.fighter.Fighter
import ru.nsu.lightweight.punchclub.rx.RxCommand

@InjectViewState
class MapPresenter : BaseMvpPresenter<MapView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadFighters()
    }

    private fun loadFighters() {
        val list = listOf(
            Fighter(
                id = 1,
                avatarUrl = "https://sun9-66.userapi.com/c852236/v852236253/1225e4/JAaa-ZifhYE.jpg",
                name = "Андрей",
                description = "13 лет вдв, не люблю сопляков и тех, кто сбривает усы",
                age = 21,
                lat = 54.847227,
                lng = 83.091926
            ),
            Fighter(
                id = 0,
                avatarUrl = "https://sun9-71.userapi.com/c845524/v845524592/16361e/jYi8Z48sUuI.jpg",
                name = "Илюха",
                description = "Не хочу умирать молодым, верю что смогу превратиться в бабочку и улететь из боя",
                age = 25,
                lat = 54.848716,
                lng = 83.109243
            ),
            Fighter(
                id = 3,
                avatarUrl = "https://sun9-6.userapi.com/c604326/v604326642/428e7/_Iyhy9bfQus.jpg",
                name = "Владислав3000",
                description = "На вид я милый, но лучше не будить моего внутреннего зверя",
                age = 22,
                lat = 55.043812,
                lng = 82.921467
            ),
            Fighter(
                id = 4,
                avatarUrl = "https://sun9-38.userapi.com/c848524/v848524041/95d37/x8rs0BoxPDs.jpg",
                name = "Рома4ка",
                description = "Я собираюсь допить свое молоко и подраться. Как видишь молоко я уже допиваю",
                age = 29,
                lat = 54.994457,
                lng = 82.861679
            ),
            Fighter(
                id = 5,
                avatarUrl = "https://sun9-16.userapi.com/c633520/v633520315/2cfa2/Txsaos6cQtc.jpg",
                name = "Серега",
                description = "Выезжаю на стрелку только с моими пацанами, потому что один боюсь",
                age = 17,
                lat = 55.061977,
                lng = 82.907825
            ),
            Fighter(
                id = 2,
                avatarUrl = "https://sun4-12.userapi.com/ltNBfqb2B4_Z2SgLvKS_JD4a5HAaw2-eS5hsNg/vCgjKc_F05E.jpg",
                name = "Леха - терминатор",
                description = "Качался с 5 лет, занимался боксом и готов применить все свои навыки в бою",
                age = 26,
                lat = 54.965455,
                lng = 82.907899
            ),
            Fighter(
                id = 6,
                avatarUrl = "https://sun9-68.userapi.com/c845421/v845421276/1d923b/UWh2RoLu7j4.jpg",
                name = "Давиджан",
                description = "Быстрый, дерзкий, как пуля резкий, ежжи",
                age = 24,
                lat = 56.497325,
                lng = 84.971644
            ),
            Fighter(
                id = 7,
                avatarUrl = "https://sun9-69.userapi.com/c855128/v855128353/9fc0a/iIu_5SFGDSQ.jpg",
                name = "Жека",
                description = "Ну во-первых, у меня есть очки и я крутой, а во-вторых, что ты мне сделаешь я в другом городе",
                age = 28,
                lat = 53.692290,
                lng = 88.050994
            ),
            Fighter(
                id = 8,
                avatarUrl = "https://sun9-69.userapi.com/c857232/v857232466/c53e/0aWePArAVMA.jpg",
                name = "Илья",
                description = "Сходил в армию, но осталась привычка убивать. Или хотя бы подраться",
                age = 31,
                lat = 55.031830,
                lng = 82.914375
            ),
            Fighter(
                id = 9,
                avatarUrl = "https://sun9-36.userapi.com/c836129/v836129832/1dd5/eGcyxU6arso.jpg",
                name = "Диман",
                description = "Могу сходить на завод, а могу и тебе по лицу",
                age = 21,
                lat = 54.758152,
                lng = 83.083298
            ),
            Fighter(
                id = 10,
                avatarUrl = "https://sun4-11.userapi.com/c638824/v638824920/51f21/68YbhE-ebr8.jpg",
                name = "Витян",
                description = "Ты будешь умолять не бить тебя, но я слишком непослушный",
                age = 27,
                lat = 55.342549,
                lng = 86.069164
            )
        )
        insertFightersInDatabase(list)
    }

    private fun insertFightersInDatabase(fighters: List<Fighter>) {
        regSubs(RxCommand.makeSingleApiRequest(
            request = fighters,
            requester = PunchDatabase.getDatabase(),
            function = { request, requester ->
                requester.figterRepository.insertFighters(request)
            },
            onNext = {
                viewState.setFighters(fighters)
            }
        ))
    }
}
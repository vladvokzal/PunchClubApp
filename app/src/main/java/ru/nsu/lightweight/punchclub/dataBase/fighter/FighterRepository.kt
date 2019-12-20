package ru.nsu.lightweight.punchclub.dataBase.fighter

class FighterRepository(
    private val fighterDao: FighterDao
) {

    fun insertFighters(fighters: List<Fighter>) {
        fighterDao.insertAll(fighters)
    }

    fun getfighters(): List<Fighter> {
        return fighterDao.getAll()
    }

    fun getFighterById(id: Long): List<Fighter> {
        return fighterDao.getFighterById(id)
    }
}
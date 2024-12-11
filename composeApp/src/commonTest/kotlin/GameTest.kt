import org.towers.Game
import kotlin.test.Test
import kotlin.test.assertEquals

class GameTest {

    @Test
    fun `Create game and check initialization`() {
        val game = Game(3, 3)
        assertEquals(
            listOf(0, 1, 2),
            game.blocksOnStick(0)
        )
        assertEquals(
            emptyList(),
            game.blocksOnStick(1)
        )
        assertEquals(
            emptyList(),
            game.blocksOnStick(2)
        )
    }
}
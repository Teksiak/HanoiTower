import org.towers.Game
import kotlin.test.Test
import kotlin.test.assertEquals

class GameTest {

    @Test
    fun `Create game and check initialization`() {
        val game = Game()
        assertEquals(
            listOf(1, 2, 3),
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

    @Test
    fun `Test move`() {
        val game = Game()
        game.move(0, 1)

        assertEquals(
            listOf(2, 3),
            game.blocksOnStick(0)
        )
        assertEquals(
            listOf(1),
            game.blocksOnStick(1)
        )

    }
}
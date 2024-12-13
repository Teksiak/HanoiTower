import org.towers.Game
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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
    fun `Try to access stick outside `() {
        val game = Game()
        assertFailsWith(NoSuchElementException::class) {
            game.blocksOnStick(4)
        }
    }

    @Test
    fun `Move block to empty stick`() {
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

    @Test
    fun `Move block to stick with larger block`() {
        val game = Game()
        game.move(0, 1) // [2, 3] [1] []
        game.move(0, 2) // [3] [1] [2]
        game.move(1, 2) // [3] [] [1, 2]

        assertEquals(
            listOf(3),
            game.blocksOnStick(0)
        )
        assertEquals(
            emptyList(),
            game.blocksOnStick(1)
        )
        assertEquals(
            listOf(1, 2),
            game.blocksOnStick(2)
        )
    }

    @Test
    fun `Move block to stick with smaller block `() {
        val game = Game()
        game.move(0, 1) // [2, 3] [1] []

        assertFailsWith(IllegalStateException::class) {
            game.move(0, 1) // [3] [2, 1] [] - Illegal
        }
    }

    @Test
    fun `Try to move block from empty stick`() {
        val game = Game()

        assertFailsWith(IllegalStateException::class) {
            game.move(1, 2)
        }
    }

    @Test
    fun `Check if game solved listener is not called for the first stick`() {
        val game = Game(3, 2)
        var isSolved = false
        game.bindOnGameSolvedListener {
            isSolved = true
        }

        game.move(0, 1)
        game.move(1, 0)

        assertEquals(false, isSolved)
    }

    @Test
    fun `Test if game solved listener is called when finished`() {
        val game = Game(3, 2)
        var isSolved = false
        game.bindOnGameSolvedListener {
            isSolved = true
        }

        game.move(0, 1)
        game.move(0, 2)
        game.move(1, 2)

        assertEquals(true, isSolved)
    }
}
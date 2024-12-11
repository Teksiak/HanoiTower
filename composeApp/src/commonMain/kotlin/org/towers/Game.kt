package org.towers

import org.towers.util.Stack
import org.towers.util.peek
import org.towers.util.pop
import org.towers.util.push

class Game(
    private val sticksNum: Int = 3,
    private val blocksNum: Int = 3
) {

    private val state: Map<Int, Stack<Int>> = buildMap {
        put(0, Stack((1 .. blocksNum).toList()))
        for (i in 1 until sticksNum) {
            put(i, Stack())
        }
    }


    fun move(from: Int, to: Int) {
        require(state.containsKey(from) && state.containsKey(to))
        require(state[from]!!.isNotEmpty())

        val fromStick = state[from]!!
        val toStick = state[to]!!

        if(toStick.isEmpty()) {
            val block = fromStick.pop()
            toStick.push(block)
        } else if(toStick.peek() > fromStick.peek()) {
            val block = fromStick.pop()
            toStick.push(block)
        } else {
            throw IllegalStateException("Cannot move a larger block on top of a smaller block")
        }
    }

    fun blocksOnStick(stick: Int): List<Int> {
        require(state.containsKey(stick))
        return state[stick]!!.toList()
    }
}
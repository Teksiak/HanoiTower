package org.towers

import org.towers.util.Stack
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

        if(state[to]!!.isEmpty()) {
            val block = state[from]!!.pop()
            state[to]!!.push(block)
        }
    }

    fun blocksOnStick(stick: Int): List<Int> {
        require(state.containsKey(stick))
        return state[stick]!!.toList()
    }
}
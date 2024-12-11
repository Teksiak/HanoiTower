package org.towers

class Game(
    private val sticksNum: Int,
    private val blocksNum: Int
) {

    private val state: Map<Int, ArrayDeque<Int>> = buildMap {
        put(0, ArrayDeque((0 until blocksNum).toList()))
        for (i in 1 until sticksNum) {
            put(i, ArrayDeque())
        }
    }

    fun move(from: Int, to: Int) {
        require(state.containsKey(from) && state.containsKey(to))
        require(state[from]!!.isNotEmpty())

        if(state[to]!!.isEmpty()) {
            val block = state[from]!!.removeLast()
            state[to]!!.add(block)
        }
    }

    fun blocksOnStick(stick: Int): List<Int> {
        require(state.containsKey(stick))
        return state[stick]!!.toList()
    }
}
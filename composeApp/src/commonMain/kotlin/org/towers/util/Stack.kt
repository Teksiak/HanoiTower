package org.towers.util

// The order of the Stack is FILO
typealias Stack<T> = MutableList<T>

fun <T> Stack(): Stack<T> = mutableListOf()
fun <T> Stack(items: Collection<T>): Stack<T> = items.toMutableList()
fun <T> Stack(vararg items: T): Stack<T> = mutableListOf(*items)

fun <T> Stack<T>.push(item: T) = add(0, item)

fun <T> Stack<T>.pop(): T = removeFirst()

fun <T> Stack<T>.peek(): T = first()


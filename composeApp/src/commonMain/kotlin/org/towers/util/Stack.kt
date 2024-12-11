package org.towers.util

typealias Stack<T> = MutableList<T>

fun <T> Stack(): Stack<T> = mutableListOf()

fun <T> Stack(items: Collection<T>): Stack<T> = items.toMutableList()

fun <T> Stack<T>.push(item: T) = add(0, item)

fun <T> Stack<T>.pop(): T = removeAt(0)

fun <T> Stack<T>.peek(): T = first()


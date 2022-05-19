package BaekJoon.Common

fun printList(r: List<Array<Int>>) {
    r.forEach { printArray(it) }
}

fun <T> printArray(r: Array<T>) {
    println(r.contentDeepToString())
}

fun <T> printlnArray(r: Array<List<T>>) {
    r.forEach { println(it) }
}

fun <T> printlnArray(r: Array<Array<T>>) {
    r.forEach { printArray(it) }
}

fun <T> printlnArray(r: List<Array<T>>) {
    r.forEach { printArray(it) }
}
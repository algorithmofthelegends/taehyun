package BaekJoon.A1015

fun main() {
    readLine()!!
    print(readLine()!!.split(" ")
        .map { it.toInt() }.withIndex()
        .sortedBy { it.value }.withIndex()
        .sortedBy { it.value.index }
        .joinToString(" ") { "${it.index}" }
    )
}
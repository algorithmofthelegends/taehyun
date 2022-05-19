package BaekJoon.A5533

fun main() {
    val n = readLine()!!.toInt()
    val a = List(n) { readLine()!!.split(" ").map { it.toInt() } }
    println((0 until n).map { i -> a[i].filterIndexed { j, v -> a.count { it[j] == v } == 1 }.sum() }.joinToString("\n"))
}
package BaekJoon.A24508

fun main() {
    val (_, k, t) = readLine()!!.split(" ").map { it.toInt() }
    val v = readLine()!!.split(" ").map { it.toLong() }.sortedDescending()
    print(if (v.sum() % k == 0L && v.slice(0 until (v.sum() / k).toInt()).sumOf { k - it } <= t) "YES" else "NO")
}
package BaekJoon.A11562

import kotlin.math.min

fun main() {
    val (n, m) = readIntArr()
    val map = Array(n) { Array(n) { 0 } }

    for (a in 0 until n)
        for (b in 0 until n)
            if (a != b) map[a][b] = n;

    for (i in 0 until m) {
        val (u, v, b) = readIntArr()
        map[u - 1][v - 1] = 0
        map[v - 1][u - 1] = if (b == 1) 0 else 1
    }

    for (a in 0 until n)
        for (b in 0 until n)
            for (c in 0 until n)
                map[b][c] = min(map[b][c], map[b][a] + map[a][c])

    val k = readLine()!!.toInt()
    for (i in 0 until k) {
        val (s, e) = readIntArr()
        println(map[s - 1][e - 1])
    }
}

private fun readIntArr() = readLine()!!.split(" ").map { it.toInt() }
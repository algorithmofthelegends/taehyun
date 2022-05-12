package BaekJoon.A11562

import kotlin.math.min

fun main() {
    val (n, m) = readIntArr()
    val map = Array(n) { Array(n) { 0 } }

    // 같은 정점으로의 이동은 0
    // 이외의 곳은 최대 값으로 초기화
    for (a in 0 until n)
        for (b in 0 until n)
            if (a != b) map[a][b] = n;

    for (i in 0 until m) {
        val (u, v, b) = readIntArr()
        // u -> v 는 바로 이동 가능
        map[u - 1][v - 1] = 0
        // b 가 1 이면 v -> u 바로 이동 가능
        map[v - 1][u - 1] = if (b == 1) 0 else 1
    }

    // 각 정점에 대해 다른 정점으로 이동하는데 바꿔야 하는 통행 수
    // 플로이드 (Floyd) 알고리즘
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
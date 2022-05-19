package BaekJoon.A14621

import kotlin.math.min

fun main() {
    fun read() = readLine()!!.split(" ")
    val (n, m) = read().map { it.toInt() }
    val l = read()
    val b = Array(n) { Array(n) { 0 } }
    repeat(m) {
        val (u, v, d) = read().map { it.toInt() - 1 }
        b[u][v] = if (b[u][v] > 0 && b[u][v] < d + 1) b[u][v] else d + 1
        b[v][u] = min(d + 1, b[v][u])
    }
    b.map { it.map { i -> if (i == 1000) 0 else i } }

    fun visit(from: Int, to: Int, v: Array<Int>) {
        if (from != to) {
            v[to] = b[from][to]
        } else {
            v[from] = 0
        }
        for (j in b[to].indices) {
            if (v[j] == -1 && b[to][j] != 0 && l[to] != l[j]) {
                visit(to, j, v)
            }
        }
    }

    (0 until n).map {
        val v = Array(n) { -1 }
        visit(it, it, v)
        v
    }.filter { !it.contains(-1) }.let { ls ->
        print(if (ls.isNotEmpty()) {
            ls.minOf { it.sum() }
        } else {
            -1
        })
    }
}
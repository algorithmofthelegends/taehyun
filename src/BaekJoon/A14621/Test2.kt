package BaekJoon.A14621

import kotlin.math.min

fun main() {
    fun read() = readLine()!!.split(" ")
    val (n, m) = read().map { it.toInt() }
    val l = read()
    val b = Array(n) { Array(n) { 1000 } }
    repeat(m) {
        val (u, v, d) = read().map { it.toInt() - 1 }
        b[u][v] = min(d + 1, b[u][v])
        b[v][u] = min(d + 1, b[v][u])
    }
    b.forEachIndexed { y, i -> i.forEachIndexed { x, j -> if (b[y][x] == 1000) b[y][x] = 0 } }
    var r = ArrayList<Array<Int>>()
    fun visit(from: Int, to: Int, v: Array<Int>) {
        if (from != to) {
            v[to] = b[from][to]
        } else {
            v[from] = 0
        }
        r.add(v)
        for (j in b[to].indices) {
            if (v[j] == -1 && b[to][j] != 0 && l[to] != l[j]) {
                visit(to, j, v)
            }
        }
    }

    (0 until 1).map {
        val v = Array(n) { -1 }
        visit(it, it, v)
        v
    }.filter { !it.contains(-1) }.let { ls ->
        println(r.forEach { println(it.contentDeepToString()) })
        print(if (ls.isNotEmpty()) {
            ls.minOf { it.sum() }
        } else {
            -1
        })
    }
}
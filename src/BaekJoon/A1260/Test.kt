package BaekJoon.A1260

import java.util.*

fun main() {
    var (n, m, v) = readLine()!!.split(" ").map { it.toInt() - 1 }
    n++
    val map = Array(n) { Array(n) { 0 } }
    var visit = Array(n) { false }

    for (i in 0..m) {
        val (f, t) = readLine()!!.split(" ").map { it.toInt() - 1 }
        map[f][t] = 1
        map[t][f] = 1
    }

    fun dfs(s: Int) {
        print("${s + 1} ")
        visit[s] = true
        for (i in map[s].indices) {
            if (!visit[i] && map[s][i] == 1)
                dfs(i)
        }
    }

    fun bfs(s: Int) {
        val q = LinkedList<Int>()
        q.add(s)
        visit[s] = true

        while (!q.isEmpty()) {
            print("${q.pop() + 1} ")
            for (i in map[s].indices) {
                if (visit[i]) {
                    q.add(i)
                    visit[i] = true
                }
            }
        }
    }

    dfs(v)
    visit = visit.map { false }.toTypedArray()
    println()
    bfs(v)
}
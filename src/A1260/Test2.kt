package A1260

import java.util.*

fun main() {
    var (n, m, v) = readLine()!!.split(" ").map { it.toInt() - 1 }
    n++
    val map = Array(n) { LinkedList<Int>() }
    val dVisit = Array(n) { false }
    val bVisit = Array(n) { false }

    for (i in 0..m) {
        val (f, t) = readLine()!!.split(" ").map { it.toInt() - 1 }
        map[f].add(t)
        map[t].add(f)
    }
    map.map { it.sort() }

    fun dfs(s: Int) {
        print("${s + 1} ")
        dVisit[s] = true
        for (i in map[s])
            if (!dVisit[i])
                dfs(i)
    }

    fun bfs(s: Int) {
        val q = LinkedList<Int>()
        q.offer(s)

        while (!q.isEmpty()) {
            val p = q.pop()
            if (!bVisit[p]) {
                print("${p + 1} ")
                bVisit[p] = true
                for (i in map[p]) {
                    q.add(i)
                }
            }
        }
    }

    dfs(v)
    println()
    bfs(v)
}
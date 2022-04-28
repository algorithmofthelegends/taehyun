package A1260

import java.util.*

fun main() {
    var (n, m, v) = readLine()!!.split(" ").map { it.toInt() - 1 }
    n++
    val map = Array(n) { LinkedList<Int>() }
    val visit = Array(n) { false }

    for (i in 0..m) {
        val (f, t) = readLine()!!.split(" ").map { it.toInt() - 1 }
        map[f].add(t)
        map[t].add(f)
    }
    map.map { it.sort() }

    fun bfs(s: Int) {
        val q = LinkedList<Int>()
        q.offer(s)

        while (!q.isEmpty()) {
            val p = q.pop()
            if (!visit[p]) {
                print("${p + 1} ")
                visit[p] = true
                for (i in map[p]) {
                    q.add(i)
                }
            }
        }
    }

    bfs(v)
}
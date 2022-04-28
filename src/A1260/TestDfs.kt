package A1260

fun main() {
    var (n, m, v) = readLine()!!.split(" ").map { it.toInt() - 1 }
    n++
    val map = Array(n) { Array(n) { 0 } }
    val visit = Array(n) { false }

    for (i in 0..m) {
        val (f, t) = readLine()!!.split(" ").map { it.toInt() - 1 }
        map[f][t] = 1
        map[t][f] = 1
    }

    fun dfs(s: Int) {
        print("${s + 1} ")
        visit[s] = true
        for (i in map[s])
            if (!visit[i])
                dfs(i)
    }

    dfs(v)
}
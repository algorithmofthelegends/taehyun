package BaekJoon.A18126

fun main() {
    val n = readLine()!!.toInt()
    val b = (1 until n).map { readLine()!!.split(" ").map { it.toInt() } }
    val v = Array(n + 1) { 0 }
    val m = Array(n + 1) { Array(n + 1) { 0 } }
    val d = Array(n + 1) { 0L }
    b.forEach {
        m[it[0]][it[1]] = it[2]
        m[it[1]][it[0]] = it[2]
    }
    fun dfs(i: Int) {
        v[i] = 1
        for (j in m[i].indices) {
            if (m[i][j] != 0 && v[j] == 0) {
                d[j] = m[i][j] + d[i]
                dfs(j)
            }
        }
    }
    dfs(1)
    print(d.maxOf { it })
}
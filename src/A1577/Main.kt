package A1577

fun main() {
    val rd = fun() = readln()!!.split(" ").map { it.toInt() }
    val (n, m) = rd()
    val k = readln()!!.toInt()
    val l = Array<Array<Long>>(m + 1) { Array(n + 1) { 0 } }
    for (i in 0 until k) {
        val (a, b, c, d) = rd()
        l[a][b] = -1
        l[c][d] = -1
    }
    l[0][0] = 0
    l[m][n] = 0
    for (i in 1..n) {
        if (l[0][i] == -1L)
            break
        l[0][i] = 1
    }
    for (i in 1..m) {
        if (l[i][0] == -1L)
            break
        l[i][0] = 1
    }
    for (i in 1..m)
        for (j in 1..n)
            if (l[i][j] != -1L)
                l[i][j] = l[i][j - 1] + l[i - 1][j] + if (l[i][j - 1] == -1L || l[i - 1][j] == -1L) 1 else 0
    print(if(l[m][n] == -1L) 0 else l[m][n])
}
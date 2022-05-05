package A1577

fun main() {
    val rd = fun() = readln()!!.split(" ").map { it.toInt() }
    val (n, m) = rd()
    val k = readln()!!.toInt()
    val l = Array(m + 1) { Array(n + 1) { 0 } }
    for (i in 0 until k) {
        val (a, b, c, d) = rd()
        l[a][b] = -1
        l[c][d] = -1
    }

    move(0, 0, n, m, l, 0)
    print(
        if (l[m][n] != -1)
            l[m][n]
        else if (l[m - 1][n] != -1)
            l[m - 1][n]
        else if (l[m][n - 1] != -1)
            l[m][n - 1]
        else 0
    )
}

private fun move(x: Int, y: Int, n: Int, m: Int, l: Array<Array<Int>>, c: Int): Int {
    if (l[y][x] != -1)
        l[y][x] += 1
    return if (x == n && y == m) c
    else {
        if (x < n && l[y][x + 1] != -1)
            move(x + 1, y, n, m, l, c + 1)
        else 0
        +
        if (y < m && l[y + 1][x] != -1)
            move(x, y + 1, n, m, l, c + 1)
        else 0
    }
}
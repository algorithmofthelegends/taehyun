package BaekJoon.A1577

fun main() {
    val rd = fun() = readLine()!!.split(" ").map { it.toInt() }
    val bi = fun(n: String) = n.toBigInteger()
    val (n, m) = rd()
    val k = readLine()!!.toInt()
    val l = Array(m + 1) { Array(n + 1) { "0" } }
    val x = "-1"
    for (i in 0 until k) {
        val (a, b, c, d) = rd()
        l[a][b] = x
        l[c][d] = x
    }
    l[0][0] = "0"
    l[m][n] = "0"
    pr(l)

    for (i in 1..n) {
        if (l[0][i] == x)
            break
        l[0][i] = "1"
    }
    for (i in 1..m) {
        if (l[i][0] == x)
            break
        l[i][0] = "1"
    }
    for (i in 1..m)
        for (j in 1..n)
            if (l[i][j] != x)
                l[i][j] =
                    "${bi(l[i][j - 1]) + bi(l[i - 1][j]) + bi(if (l[i][j - 1] == x || l[i - 1][j] == x) "1" else "0")}"
    pr(l)
    print(if (l[m][n] == x) 0 else l[m][n])
}
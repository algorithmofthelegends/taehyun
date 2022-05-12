package BaekJoon.A1018

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val l = Array(n) {
        readLine()!!.toCharArray()
    }
    val rc = fun(c: Char) = if (c == 'B') 'W' else 'B'
    val c = fun(): Int {
        var r = 0
        for (i in l.indices) {
            for (j in l[i].indices) {
                if (j > 0) {
                    if (l[i][j - 1] == l[i][j]) {
                        l[i][j] = rc(l[i][j])
                        r++
                    }
                } else if (i > 0) {
                    if (l[i - 1][j] == l[i][j]) {
                        l[i][j] = rc(l[i][j])
                        r++
                    }
                }
            }
        }
        return r
    }

    var a = c()
    l[0][0] = rc(l[0][0])
    var b = c()

    println(l.forEach { println(it.contentToString()) })
    print("$a $b")
}
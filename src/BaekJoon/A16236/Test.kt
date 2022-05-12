package BaekJoon.A16236

import BaekJoon.Common.printlnArray

fun main() {
    val n = readLine()!!.toInt()
    val l = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    printlnArray(l)

    fun find(t: Int): List<Array<Int>> {
        val r = ArrayList<Array<Int>>()
        for (i in 0 until n)
            for (j in 0 until n)
                if (l[i][j] == t)
                    r.add(arrayOf(i, j))
        return r
    }

    // 상어 위치
    var (x, y) = find(9)[0]
    // 상어 크기
    var s = 2

    fun board(): Array<Array<Int>> {
        val v = Array(n) { Array(n) { 0 } }
        for (i in s..n) {
            find(i).forEach { v[it[0]][it[1]] = 1 }
        }
        return v
    }

    fun move(m: Array<Int>, b: Array<Array<Int>>) {
        printlnArray(b)
    }

    for (i in 1..n) {
        for (j in find(i)) {
            println(j.contentDeepToString())
        }
    }

    move(arrayOf(0, 3), board())
}

// 4
// 4 3 2 1
// 0 0 0 0
// 0 0 9 0
// 1 2 3 4

// 14
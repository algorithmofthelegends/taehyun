package BaekJoon.A11562

import java.lang.Integer.min

fun main() {
    val (n, m) = readIntArr()
    val arr = Array(n) { Array(n) { 0 } }

    for (i in 0 until m) {
        val (f, b, w) = readIntArr()
        arr[f - 1][b - 1] = 1
        if (w == 1)
            arr[b - 1][f - 1] = 1
    }
    val k = readLine()!!.toInt()
    for (i in 0 until k) {
        val (f, b) = readIntArr()
        println(move(f, b, 0, arr))
    }
}

private fun readIntArr() = readLine()!!.split(" ").map { it.toInt() }

private fun move(a: Int, b: Int, c: Int, arr: Array<Array<Int>>): Int {
    var min = arr.size
    if (a == b) {
        return c
    } else if (a < b) {
        for (i in a..b) {
            min = min(min, move(a + 1, b, c + if (arr[a - 1][i - 1] == 1) 0 else 1, arr))
        }
    } else {
        for (i in a downTo b) {
            min = min(min, move(a - 1, b, c + if (arr[a - 1][i - 1] == 1) 0 else 1, arr))
        }
    }
    return min
}
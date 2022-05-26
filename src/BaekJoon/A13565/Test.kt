package BaekJoon.A13565

import BaekJoon.Common.printlnArray

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val b = Array(n) { readLine()!!.toCharArray() }
    printlnArray(b)

    fun move(x: Int, y: Int) {
        if (x in 0 until m && y < n && b[y][x] == '0') {
            b[y][x] = '2'
            move(x - 1, y)
            move(x + 1, y)
            move(x, y + 1)
        }
    }
    for (x in 0 until m)
        move(x, 0)

    printlnArray(b)
    print(if (b.last().contains('2')) "YES" else "NO")
}
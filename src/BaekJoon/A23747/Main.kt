package BaekJoon.A23747

fun main() {
    val (r, c) = readLine()!!.split(" ").map { it.toInt() }
    val b = Array(r) { readLine()!!.toCharArray() }
    var (y, x) = readLine()!!.split(" ").map { it.toInt() - 1 }
    val t = Array(r) { Array(c) { '#' } }
    fun light(i: Int, j: Int) {
        if (i in 0 until r && j in 0 until c) t[i][j] = '.'
    }

    fun check(i: Int, j: Int, k: Char) {
        if (i in 0 until r && j in 0 until c && b[i][j] == k && t[i][j] == '#') {
            light(i, j)
            check(i + 1, j, k)
            check(i - 1, j, k)
            check(i, j + 1, k)
            check(i, j - 1, k)
        }
    }
    readLine()!!.toCharArray().forEach {
        when (it) {
            'W' -> check(y, x, b[y][x])
            'L' -> x--
            'R' -> x++
            'U' -> y--
            'D' -> y++
        }
    }

    light(y, x)
    light(y - 1, x)
    light(y + 1, x)
    light(y, x + 1)
    light(y, x - 1)
    t.forEach { println(it.joinToString("")) }
}
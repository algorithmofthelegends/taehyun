package BaekJoon.A23747

import kotlin.test.assertEquals

fun main() {
    assertEquals(
        test(
            4, 5,
            arrayOf(
                "aaabc".toCharArray(),
                "dcbbc".toCharArray(),
                "dccaa".toCharArray(),
                "ddaaa".toCharArray(),
            ),
            3, 4,
            "WLLLWUURRD".toCharArray()
        ), "##.##\n" +
                "....#\n" +
                ".#...\n" +
                ".....\n"
    )

    assertEquals(
        test(
            3, 3,
            arrayOf(
                "abc".toCharArray(),
                "def".toCharArray(),
                "ghi".toCharArray(),
            ),
            2, 2,
            "LU".toCharArray()
        ), "..#\n" +
                ".##\n" +
                "###\n"
    )
}

private fun test(r: Int, c: Int, b: Array<CharArray>, i1: Int, i2: Int, command: CharArray): String {
    var (y, x) = arrayOf(i1 - 1, i2 - 1)
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
    command.forEach {
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
    val result = t.fold("") { acc, chars -> acc + chars.joinToString("") + "\n" }
    println(result)
    return result
}
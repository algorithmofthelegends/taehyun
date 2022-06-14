package BaekJoon.A18126

import kotlin.test.assertEquals

fun main() {
    assertEquals(
        test(
            4,
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(2, 3, 2),
                arrayOf(2, 4, 4)
            )
        ),
        7
    )

    assertEquals(
        test(
            4,
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(1, 3, 3),
                arrayOf(2, 4, 4),
            )
        ),
        7
    )

    assertEquals(
        test(
            5,
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(1, 3, 3),
                arrayOf(3, 4, 5),
                arrayOf(2, 4, 4),
            )
        ),
        12
    )

    assertEquals(
        test(
            7,
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(2, 3, 2),
                arrayOf(2, 4, 4),
                arrayOf(4, 5, 6),
                arrayOf(4, 6, 5),
                arrayOf(5, 3, 2),
            )
        ),
        18
    )

    assertEquals(
        test(
            2,
            arrayOf(
                arrayOf(1, 2, 3),
            )
        ),
        3
    )

    assertEquals(
        test(
            2,
            arrayOf(
                arrayOf(2, 2, 3),
            )
        ),
        0
    )

    assertEquals(
        test(
            4,
            arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(1, 3, 3),
                arrayOf(2, 3, 3),
                arrayOf(3, 2, 3),
            )
        ),
        6
    )

    assertEquals(
        test(
            11,
            arrayOf(
                arrayOf(1, 2, 1000000000),
                arrayOf(2, 3, 1000000000),
                arrayOf(3, 4, 1000000000),
                arrayOf(4, 5, 1000000000),
                arrayOf(5, 6, 1000000000),
                arrayOf(6, 7, 1_000_000_000),
                arrayOf(7, 8, 1_000_000_000),
                arrayOf(8, 9, 1_000_000_000),
                arrayOf(9, 10, 1_000_000_000),
            )
        ),
        9000000000
    )
}

private fun test(n: Int, b: Array<Array<Int>>): Long {
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
    return d.maxOf { it }
}
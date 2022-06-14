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
        8
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
        15
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
        15
    )
}

private fun test(n: Int, b: Array<Array<Int>>): Long {
    fun move(i: Int, j: Int, d: Long, v: Array<Int>): Long {
        v[i] = 1
        var m = d
        for (k in b.filter { it[0] == j }) {
            if (v[j] == 0) {
                val r = move(j, k[1], d + k[2], v.copyOf())
                if (r > m) m = r
            }
        }
        return m
    }

    var m = 0L
    for (i in b.filter { it[0] == 1 }) {
        val r = move(i[0], i[1], i[2].toLong(), Array(n) { 0 })
        if (r > m) m = r
    }
    return m
}
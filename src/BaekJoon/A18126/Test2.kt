package BaekJoon.A18126

import kotlin.math.max
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
}

private fun test(n: Int, b: Array<Array<Int>>): Int {
    fun move(i: Int, d: Int = 0): Int {
        var m = d
        for (j in b) {
            if (j[0] == i) {
                m = max(m, move(j[1], d + j[2]))
            }
        }
        return m
    }

    return move(1)
}
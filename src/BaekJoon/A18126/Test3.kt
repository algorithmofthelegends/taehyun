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
}

private fun test(n: Int, b: Array<Array<Int>>): Int {
    val map = Array(n) { Array(n) { 0 } }
    fun move(i: Int, j: Int, d: Int, v: Array<Int>) {
        v[i] = 1
        map[i - 1][j - 1] = d
        for (k in b) {
            if (k[0] == j && v[j] == 0) {
                move(k[0], k[1], d + k[2], v.clone())
            }
        }
    }

    for (i in b.filter { it[0] == 1 }) {
        move(i[0], i[1], i[2], Array(n) { 0 })
        println(map.contentDeepToString())
    }

    return map.maxOf { it.maxOf { i -> i } }
}
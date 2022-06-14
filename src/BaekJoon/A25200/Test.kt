package BaekJoon.A25200

import kotlin.test.assertEquals

fun main() {
    assertEquals(
        test(
            5, 4,
            arrayOf(
                arrayOf(1, 3),
                arrayOf(3, 2),
                arrayOf(4, 3),
                arrayOf(2, 4),
            )
        ), "4 4 4 3 5"
    )

    assertEquals(
        test(
            5, 4,
            arrayOf(
                arrayOf(1, 3),
                arrayOf(3, 2),
                arrayOf(4, 3),
                arrayOf(2, 4),
            )
        ), "4 4 4 3 5"
    )
}

private fun test(n: Int, m: Int, r: Array<Array<Int>>): String {
    val ia = Array(m) { 0 }
    r.forEachIndexed { i, ints -> ia[ints[0] - 1] = i }
    r.sortBy { it[0] }
    println(r.contentDeepToString())
    println(ia.contentDeepToString())

    fun move(d: Int, i: Int = -1): Int {
        if (d > m) {
            return d
        }
        val t = r[d - 1]
        println("t ${t.contentDeepToString()}")
        println("ia ${ia[t[0] - 1]} $i")
        return if (ia[t[0] - 1] > i) {
            move(r[t[1] - 1][0], ia[t[0] - 1])
        } else {
            t[0]
        }
    }

    print(move(1))
    return (1..n).map { move(it) }.joinToString(" ")
}
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
            4, 3,
            arrayOf(
                arrayOf(1, 2),
                arrayOf(3, 2),
                arrayOf(2, 3),
            )
        ), "3 3 3 4"
    )
}

private fun test(n: Int, m: Int, r: Array<Array<Int>>): String {
    val indices = HashMap<Int, Int>()
    r.forEachIndexed { i, ints -> indices[ints[0]] = i }
    val map = r.associate { it[0] to it[1] }
//    println(r.contentDeepToString())
//    println(map)
//    println(indices)

    fun move(d: Int, i: Int = -1): Int {
        return if (map.containsKey(d)) {
            val t = map[d]!!
//            println("d/$d t/$t map/${map[t]}")
//            println("index ${indices[t]} $i")
            if (indices[d]!! > i) {
                move(t, indices[d]!!)
            } else {
                d
            }
        } else {
            d
        }
    }

//    println(move(1))
//    return "123"
    val result = (1..n).map { move(it) }.joinToString(" ")
    println(result)
    return result
}
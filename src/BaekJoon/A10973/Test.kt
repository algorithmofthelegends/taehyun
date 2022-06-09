package BaekJoon.A10973

import java.util.Collections.swap
import kotlin.test.assertTrue

fun main() {
    assertTrue(test(arrayOf(1, 2, 3)) == "-1")
    assertTrue(test(arrayOf(3, 2, 1)) == "3 1 2")
    assertTrue(test(arrayOf(2, 1, 3)) == "1 3 2")
    assertTrue(test(arrayOf(1, 9, 4, 6, 7)) == "1 7 4 6 9")
    assertTrue(test(arrayOf(5, 4, 3, 2, 1)) == "5 4 3 1 2")
    assertTrue(test(arrayOf(1)) == "-1")
    assertTrue(test(arrayOf(2)) == "-1")
    assertTrue(test(arrayOf(1, 2)) == "-1")
    assertTrue(test(arrayOf(2, 1)) == "1 2")
}

private fun test(r: Array<Int>): String {
    val n = r.size
    val f = Array(n) { it + 1 }.joinToString(" ")
    fun prev(a: Array<Int>): Array<Int> {
        var turnIdx = 0
        for (i in a.size - 1 downTo 1) {
            if (a[i] < a[i - 1]) {
                turnIdx = i - 1
                break
            }
        }

        val lastPart = a.slice(turnIdx + 1 until a.size)
        var swapIdx = 0
        for (j in lastPart.size - 1 downTo 0) {
            if (lastPart[j] < a[turnIdx]) {
                swapIdx = turnIdx + j + 1;
                break
            }
        }

        println("lastPart : $lastPart")
        println("idx : $turnIdx $swapIdx")
        swap(a.asList(), turnIdx, swapIdx)
        return a
    }

    val p = if (n == 1 || f == r.joinToString(" ")) "-1" else prev(r).joinToString(" ")
    println(f)
    println(p)
    println(r.joinToString(" "))
    return p
}

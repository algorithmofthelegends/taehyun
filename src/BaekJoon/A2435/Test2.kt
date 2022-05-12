package BaekJoon.A2435

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val c = nextInt()
    val d = nextInt()
    val l = IntArray(c)
    var max = -100
    for (i in 0 until c) l[i] = nextInt()
    for (i in 0..c - d) {
        var sum = 0
        for (j in i until i + d) sum += l[j]
        max = if (max > sum) max else sum
    }
    print(max)
}
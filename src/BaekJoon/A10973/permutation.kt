package BaekJoon.A10973

import java.util.Collections.swap

fun main() {
    test(5)
}

private fun test(n: Int) {
    val r = Array(n) { it + 1 }
    permutation(r, 0, n)
}

private fun permutation(r: Array<Int>, s: Int, e: Int) {
    if (s == e) {
        println(r.contentDeepToString())
    } else {
        for (i in s until e) {
            swap(r.asList(), s, i)
            permutation(r, s + 1, e);
            swap(r.asList(), s, i)
        }
    }
}
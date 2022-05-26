package BaekJoon.A2851

import kotlin.math.abs

fun main() {
    val v = Array(10) { readLine()!!.toInt() }
    val r = Array(10) { 0 }
    r[0] = v[0]
    for (i in 0..9) if (i > 0) r[i] = v[i] + r[i - 1]
    for (i in 0..100) {
        val f = r.filter { abs(100 - it) == i }
        if (f.isNotEmpty()) {
            print(f.maxOf { it })
            break
        }
    }
}
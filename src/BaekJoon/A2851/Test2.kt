package BaekJoon.A2851

import kotlin.math.abs

fun main() {
    val v = Array(10) { readLine()!!.toInt() }
    var s = 0
    var r = 0
    for (i in v) {
        s += i
        if (abs(s - 100) <= abs(r - 100))
            r = s
    }
    print(r)
}
package BaekJoon.A10973

import java.util.Collections.swap

fun main() {
    val n = readLine()!!.toInt()
    val f = Array(n) { it + 1 }.joinToString(" ")
    val a = readLine()!!
    fun prev(a: List<Int>): String {
        var i = a.size - 1;
        while (i > 0 && a[i - 1] <= a[i]) {
            i -= 1
        }
        if (i <= 0) {
            return "-1"
        }
        var j = a.size - 1
        while (a[j] >= a[i - 1]) {
            j -= 1
        }
        swap(a, i - 1, j)
        j = a.size - 1
        while (i < j) {
            swap(a, i, j)
            i += 1
            j -= 1
        }
        return a.joinToString(" ")
    }
    print(if (n == 1 || f == a) "-1" else prev(a.split(" ").map { it.toInt() }))
}
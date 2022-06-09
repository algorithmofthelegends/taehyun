package BaekJoon.A10973

import java.util.Collections.swap
import kotlin.test.assertTrue

fun main() {
    assertTrue(test(arrayOf(1, 2, 3)) == "-1")
    assertTrue(test(arrayOf(3, 2, 1)) == "3 1 2")
    assertTrue(test(arrayOf(2, 1, 3)) == "1 3 2")
    assertTrue(test(arrayOf(1, 9, 4, 6, 7)) == "1 7 9 6 4")
    assertTrue(test(arrayOf(5, 4, 3, 2, 1)) == "5 4 3 1 2")
    assertTrue(test(arrayOf(1)) == "-1")
    assertTrue(test(arrayOf(2)) == "-1")
    assertTrue(test(arrayOf(1, 2)) == "-1")
    assertTrue(test(arrayOf(2, 1)) == "1 2")
}

private fun test(r: Array<Int>): String {
    val n = r.size
    val f = Array(n) { it + 1 }.joinToString(" ")

    fun prev(a: Array<Int>): String {
        //1. a[i-1] > a[i]를 만족하는 첫 번째 수 찾기
        var i = a.size - 1;
        while (i > 0 && a[i - 1] <= a[i]) {
            i -= 1
        }

        // 첫 번째 순열인 경우
        if (i <= 0) {
            return "-1"
        }
        //2. a[i-1] > a[j]를 만족하는 첫 번째 수 찾기
        var j = a.size - 1
        while (a[j] >= a[i - 1]) {
            j -= 1
        }

        //3. a[i-1]과 a[j] swap
        swap(a.asList(), i - 1, j)

        //4 i부터 a.length-1까지 순열 뒤집기
        j = a.size - 1
        while (i < j) {
            swap(a.asList(), i, j)
            i += 1
            j -= 1
        }
        return a.joinToString(" ")
    }

    val p = if (n == 1 || f == r.joinToString(" ")) "-1" else prev(r)
    println(f)
    println(p)
    return p
}

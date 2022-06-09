package BaekJoon.A10973

import kotlin.test.assertEquals

fun main() {
    assertEquals(test("1 2 3"), "-1")
    assertEquals(test("2 1 3"), "1 3 2")
    assertEquals(test("1 9 4 6 7"), "1 7 9 6 4")
}

private fun test(s: String): String {
    val a = s.split(" ").map { it.toInt() }.toList()
    val n = a.size
    fun f(): String {
        val i = (n - 1 downTo 1).find { a[it - 1] > a[it] } ?: return "-1"
        val j = (i until n).filter { a[i - 1] > a[it] }.maxByOrNull { a[it] } ?: return ""
        println("$i $j")
        println(a.subList(0, i - 1))
        println(listOf(a[j]))
        println(a.subList(i - 1, n).filter { it != a[j] }.sorted().reversed())
        return (a.subList(0, i - 1) + listOf(a[j]) + a.subList(i - 1, n).filter { it != a[j] }.sorted().reversed()).joinToString(" ")
    }

    val r = f()
    println(r)
    return r
}

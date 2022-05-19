package BaekJoon.A21921

import kotlin.random.Random
import kotlin.random.nextLong

fun main() {
//    test("5 2", "1 4 2 5 1")
//    test("7 5", "1 1 1 1 1 5 1")
//    test("5 3", "0 0 0 0 0")
//    test3("250000 100000")
    test3("5 2", "1 4 2 5 1")
}

private fun test(s1: String, s2: String) {
    val (n, x) = s1.split(" ").map { it.toInt() }
    val l = s2.split(" ").map { it.toInt() }
    val r = (0..n - x).map {
        l.filterIndexed { i, _ -> i >= it && i < it + x }.sum()
    }.sortedDescending()
    println(if (r[0] == 0) "SAD" else "${r[0]}\n${r.count { it == r[0] }}")
}

private fun test2(s1: String) {
    val (n, x) = s1.split(" ").map { it.toInt() }
    val l = Array(n) { Random.nextLong(0L..8000) }
    val r = (0..n - x).map { (it until it + x).sumOf { i -> l[i] } }
    val max = r.maxOf { it }
    print(if (max == 0L) "SAD" else "$max\n${r.count { it == max }}")
}

private fun test3(s1: String, s2: String) {
    val (n, x) = s1.split(" ").map { it.toInt() }
    val l = s2.split(" ").map { it.toInt() }
    val r = ArrayList<Int>()
    r.add(l.slice(0 until x).sum())
    for (i in 1..n - x) {
        r.add(r[i - 1] - l[i - 1] + l[i + x - 1])
    }
    val max = r.maxOf { it }
    print(if (max == 0) "SAD" else "$max\n${r.count { it == max }}")
}
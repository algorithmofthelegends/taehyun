package BaekJoon.A10973

fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val l = Array(n) { it + 1 }
    val r = p(l)
    val i = r.indexOf(s) - 1
    println(r)
    print(if (i > 0) r[i] else -1)
}

private fun p(l: Array<Int>, s: List<Int> = listOf(), e: List<Int> = l.toList()): List<String> = when (e.size) {
    0 -> listOf(s.joinToString(" "))
    else -> e.flatMap { p(l, s + it, e - it) }
}
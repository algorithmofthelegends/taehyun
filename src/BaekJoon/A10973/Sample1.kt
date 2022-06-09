package BaekJoon.A10973

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.toList()
    fun f(): String {
        val i = (n - 1 downTo 1).find { a[it - 1] > a[it] } ?: return "-1"
        val j = (i until n).filter { a[i - 1] > a[it] }.maxByOrNull { a[it] } ?: return ""
        return (a.subList(0, i - 1) + listOf(a[j]) + a.subList(i - 1, n).filter { it != a[j] }.sorted().reversed()).joinToString(" ")
    }
    print(f())
}

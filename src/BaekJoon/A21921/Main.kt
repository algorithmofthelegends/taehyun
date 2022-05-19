package BaekJoon.A21921

fun main() {
    fun read() = readLine()!!.split(" ").map { it.toInt() }
    val (n, x) = read()
    val l = read()
    val r = ArrayList<Int>()
    r.add(l.slice(0 until x).sum())
    for (i in 1..n - x) {
        r.add(r[i - 1] - l[i - 1] + l[i + x - 1])
    }
    val max = r.maxOf { it }
    print(if (max == 0) "SAD" else "$max\n${r.count { it == max }}")
}
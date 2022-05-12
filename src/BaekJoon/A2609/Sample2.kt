package BaekJoon.A2609

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val g = gcd(n, m)
    println(g)
    println(n * m / g)
}
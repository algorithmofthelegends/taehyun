package BaekJoon.A2609

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    var i = minOf(n, m)
    while (n % i + m % i != 0) i--
    println(i)
    println(n * m / i)
}
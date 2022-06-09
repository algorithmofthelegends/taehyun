package BaekJoon.A25175

fun main() {
    var (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    m -= 1
    k -= 3
    m += k
    m %= n
    print(m)
}
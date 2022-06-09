package BaekJoon.A25175

fun main() {
    // val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    test(arrayOf(7, 2, 4))  // 3
    test(arrayOf(6, 1, -1)) // 3
    test(arrayOf(6, 1, 2))  // 6
    test(arrayOf(7, 2, 2))  // 1
    test(arrayOf(7, 2, 9))  // 1
    test(arrayOf(7, 2, 10)) // 2
    test(arrayOf(7, 2, -3)) // 3
    test(arrayOf(7, 2, -15))// 5
    test(arrayOf(7, 2, 15)) // 7
    test(arrayOf(1, 1, 10)) // 1
    test(arrayOf(1, 1, -11))//
    test(arrayOf(10000, 10000, -100000))  //
}

private fun test(vars: Array<Int>) {
    var (n, m, k) = vars
    m -= 1
    k -= 3
    m += k
    m %= n
    m += n
    m %= n
    println(m + 1)
}
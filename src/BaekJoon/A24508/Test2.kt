package BaekJoon.A24508

fun main() {
//    println(test("2 2 1", "1 1")) // YES
//    println(test("3 5 2", "1 2 2")) // NO
//    println(test("3 5 3", "1 2 2")) // YES
//    println(test("3 3 100000", "2 1 2")) // NO
//    println(test("4 3 2", "2 1 2 1")) // YES
//    println(test("4 4 2", "2 2 2 2")) // NO
//    println(test("4 4 3", "3 2 1 2")) // YES
//    println(test("2 100000 1000000000", "99999 1")) // YES
//    println(test("6 6 2", "5 3 3 3 2 2")) // NO
//    println(test("6 1 0", "0 0 0 0 0 0")) //
//    println(test("2 1 2", "0 0 0")) //
//    println(test("8 6 9", "5 2 2 2 2 2 2 1")) // YES
//    println(test("8 6 9", "5 2 2 2 2 2 2 1")) // YES
//    println(test("4 5 3", "4 4 4 3")) // YES
//    println(test("5 10000 10000000", "9122 1234 1244 4949 3451")) // YES
    println(test("10 100000 10000000", "999999 999999 999999 999999 999999 999999 999999 999999 999999 999999")) //
}

private fun test(s1: String, s2: String): String {
    val (_, k, t) = s1.split(" ").map { it.toInt() }
    val v = s2.split(" ").map { it.toInt() }.sortedByDescending { it }
    println(v)
    println(v.sum())
    println(v.sum() / k)
    println(v.slice(0 until v.sum() / k))
    println(v.slice(0 until v.sum() / k).sumOf { k - it })
    return if (v.sum() % k == 0 && v.slice(0 until v.sum() / k).sumOf { k - it } <= t) "YES" else "NO"
}
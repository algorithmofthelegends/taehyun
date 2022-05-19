package BaekJoon.A5533

fun main() {
    val n = readLine()!!.toInt()
    val v = Array(n) { readLine()!!.split(" ").map { it.toInt() } }
    val r = Array(n) { 0 }
    for (x in 0..2) {
        val l = ArrayList<Array<Int>>()
        for (y in 0 until n) l.add(arrayOf(y, v[y][x]))
        l.filter { i -> l.count { it[1] == i[1] } == 1 }.forEach { r[it[0]] += it[1] }
    }
    r.forEach { println(it) }
}

// 100 99 98
// 100 97 92
// 63 89 63
// 99 99 99
// 89 97 98

// X X X
// X X 92
// 63 89 63
// 99 X 99
// 89 X X
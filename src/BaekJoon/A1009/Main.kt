package BaekJoon.A1009

fun main() {
    val t = readLine()!!.toInt()
    val toInt = fun(s: Int) = "$s".last().digitToInt()
    val r = ArrayList<Int>()
    for (i in 1..t) {
        var (a, b) = readLine()!!.split(" ").map { it.toInt() }
        a = toInt(a)
        var m = 1
        val l = Array(4) {
            m *= a
            toInt(m)
        }
        var j = b % 10 % 4 - 1
        j = if (j > -1) j else 3
        r.add(if (l[j] == 0) 10 else l[j])
    }
    r.forEach { println(it) }
}
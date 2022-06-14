package BaekJoon.A25200

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val r = Array(m) { readLine()!!.split(" ").map { it.toInt() } }
    val indices = HashMap<Int, Int>()
    r.forEachIndexed { i, ints -> indices[ints[0]] = i }
    val map = r.associate { it[0] to it[1] }
    fun move(d: Int, i: Int = -1): Int {
        return if (map.containsKey(d)) {
            val t = map[d]!!
            if (indices[d]!! > i) {
                move(t, indices[d]!!)
            } else {
                d
            }
        } else {
            d
        }
    }
    print((1..n).map { move(it) }.joinToString(" "))
}
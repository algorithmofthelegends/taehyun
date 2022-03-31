package A1015

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    val r = Array(n) { 0 }
    arr.sorted().forEachIndexed { idx, i ->
        val ai = arr.indexOf(i)
        arr[ai] = -1
        r[ai] = idx
    }
    print(r.joinToString(" "))
}
package BaekJoon.A15668

fun main() {
    // val n = readLine()!!.toInt()
    val n = "555"
    val al = ArrayList<Int>()
    val bl = ArrayList<Int>()
    var a = 0
    var b = 0

    var loop = true
    val m = n.length
    var f = n.first().digitToInt()

    for (i in f downTo 1) {
        for (j in 9 downTo 1) {
            if (!al.contains(j)) {
                al.add(j)
                if (al.size == f) {
                    if (toInt(al) > n.toInt()) {
                        
                    }
                }
            }
        }
    }

    println(al)
    println(bl)
}

private fun toInt(l: List<Int>): Int {
    return l.joinToString("").toInt()
}
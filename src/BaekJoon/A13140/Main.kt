package BaekJoon.A13140

fun main() {
    // val input = readLine()!!.toInt();
    val input = "66971".toInt();
    val result = Array(10) { it }

    permutate(result).forEach { n ->
        if (n.size > 1 && n[2] != 0 && n[6] != 0) {
            val x = "${n[2]}${n[1]}${n[3]}${n[3]}${n[4]}".toInt()
            val y = "${n[6]}${n[4]}${n[5]}${n[3]}${n[0]}".toInt()
            if (x + y == input) {
                print("  $x\n+ $y\n-------\n" + "%7d".format(input))
                return
            }
        }
    }
    print("No Answer")
}

private fun permutate(
    e: Array<Int>,
    f: List<Int> = listOf(),
    s: List<Int> = e.toList(),
): List<List<Int>> {
    return if ((f.size > 2 && f[2] == 0) || (f.size > 6 && f[6] == 0)) {
        return listOf()
    } else
        when (s.size) {
            3 -> listOf(f)
            else -> s.flatMap { permutate(e, f + it, s - it) }.distinct()
        }
}
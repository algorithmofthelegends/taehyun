package A13140

fun main() {
    val input = "66971".toInt();
    val result = Array(10) { it }

    permutate(result).forEach { n ->
        if (n[2] != 0 && n[6] != 0) {
            val x = (n[2] * 1e4 + n[1] * 1e3 + n[3] * 1e2 + n[3] * 1e1 + n[4]).toInt()
            val y = (n[6] * 1e4 + n[4] * 1e3 + n[5] * 1e2 + n[3] * 1e1 + n[0]).toInt()
            if (x + y == input) {
                print("  $x\n+ $y\n-------\n")
                print("%7d".format(input))
                return
            }
        }
    }

    print("No Answer")
}

private fun permutate(
    e: Array<Int>,
    f: List<Int> = listOf(),
    s: List<Int> = e.toList()
): List<List<Int>> = when (s.size) {
    1 -> listOf(f + s)
    else -> s.flatMap { permutate(e, f + it, s - it) }
}
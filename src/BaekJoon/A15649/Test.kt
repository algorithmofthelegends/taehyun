package BaekJoon.A15649

fun main() {
    test(3, 1)
    test(4, 2)
}

private fun test(n: Int, m: Int) {
    permutate(m, Array(n) { it + 1 }).forEach { println(it.joinToString(" ")) }
}

private fun permutate(
    c: Int,
    e: Array<Int>,
    f: List<Int> = listOf(),
    s: List<Int> = e.toList()
): List<List<Int>> = when (f.size) {
    c -> listOf(f)
    else -> s.flatMap { permutate(c, e, f + it, s - it) }
}
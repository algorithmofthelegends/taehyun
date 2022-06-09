package BaekJoon.A15649

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    // 출력할 자리수 크기, 1 부터 n 까지의 list 를 넘겨줍니다
    permutate(m, Array(n) { it + 1 }).forEach {
        // 각각의 결과를 공백으로 구분하고 다음 결과는 \n 하여 출력 합니다
        println(it.joinToString(" "))
    }
}

private fun permutate(
    c: Int, // 자리수 크기
    e: Array<Int>, // 원본 list
    f: List<Int> = listOf(), // 출력할 list
    s: List<Int> = e.toList() // 남은 숫자 list
): List<List<Int>> = when (f.size) {
    // 출력할 f:list 의 크기가 c 일 경우 return
    c -> listOf(f)
    //
    else -> s.flatMap { permutate(c, e, f + it, s - it) }
}
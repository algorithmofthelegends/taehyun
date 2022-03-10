package A13140

fun main() {
    val input = readLine()!!.toInt();
    val result = Array(10) { it }

    permutate(result).forEach { n ->
        println(n)
        if (n.size > 1 && n[2] != 0 && n[6] != 0) {
            // hello
            // world
            // 에 맞게 배치
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

// 모든 경우의 수를 list로 제공합니다
// [0, 1, 2, 3, 4, 5, 6]
// [0, 1, 2, 3, 4, 5, 7]
// [0, 1, 2, 3, 4, 5, 8]
// [0, 1, 2, 3, 4, 5, 9]
// [0, 1, 2, 3, 4, 6, 5]
// [0, 1, 2, 3, 4, 6, 7]
// ...
// [9, 8, 7, 6, 5, 4, 2]
// [9, 8, 7, 6, 5, 4, 3]
private fun permutate(
    e: Array<Int>,
    f: List<Int> = listOf(),
    s: List<Int> = e.toList(),
): List<List<Int>> {
    return if ((f.size > 2 && f[2] == 0) || (f.size > 6 && f[6] == 0)) {
        return listOf()
    } else
        when (s.size) {
            // d, e, h, l, o, r, w 7 자리가 f 에 들어갔을 경우
            // 즉 최초 크기 10인 s 에 7개 원소가 빠져나가서 크기가 3이 될 때 결과를 return 합니다
            3 -> listOf(f)
            else -> s.flatMap { permutate(e, f + it, s - it) }.distinct()
        }
}
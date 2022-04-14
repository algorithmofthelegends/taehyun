package A2435

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val c = nextInt()
    val d = nextInt()
    val l = IntArray(c)
    var max = -100
    // 초기화
    for (i in 0 until c) l[i] = nextInt()
    // c 에서 d 만큼 뺸 만큼 반복 (c - d == length)
    for (i in 0..c - d) {
        var sum = 0
        // 연속적인 날짜 d 만큼 더한 값을 max 로 대체
        for (j in i until i + d) sum += l[j]
        max = if (max > sum) max else sum
    }
    print(max)
}
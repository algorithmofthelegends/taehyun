package BaekJoon.A2851

import kotlin.math.abs

fun main() {
    val v = Array(10) { readLine()!!.toInt() }
    // 누적 합
    var s = 0
    // 100 근사값
    var r = 0
    for (i in v) {
        // s 에 i 를 누적하여 더함
        s += i
        // s 와 100의 차이가 r 과 100의 차이보다 작을 경우 r 을 s 로 대체
        if (abs(s - 100) <= abs(r - 100))
            r = s
    }
    print(r)
}
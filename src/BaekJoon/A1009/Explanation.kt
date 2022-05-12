package BaekJoon.A1009

fun main() {
    val t = readLine()!!.toInt()
    // 마지막 문자를 숫자로 변경하는 함수
    val toInt = fun(s: Int) = "$s".last().digitToInt()
    for (i in 1..t) {
        var (a, b) = readLine()!!.split(" ").map { it.toInt() }
        a = toInt(a)
        var m = 1
        // 4 제곱근 까지의 마지막 숫자만 저장
        val l = Array(4) {
            m *= a
            toInt(m)
        }
        // 4 개의 숫자가 반복되므로 4로 나누고 1을 뺍니다
        var j = b % 4 - 1
        // -1 일 경우 마지막
        j = if (j > -1) j else 3
        println(
            if (l[j] == 0) 10
            else l[j]
        )
    }
}
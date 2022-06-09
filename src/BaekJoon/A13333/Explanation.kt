package BaekJoon.A13333

fun main() {
    val n = readLine()!!.toInt()
    val l = readLine()!!.split(" ").map { it.toInt() }
    // q-index 가 없을 경우 0
    var r = 0
    for (k in n downTo 0)
    // 인용한 횟수가 k 이상인 논문의 개수가 k 이상일 경우 출력
        if (l.count { it >= k } >= k) {
            r = k
            break
        }
    print(r)
}
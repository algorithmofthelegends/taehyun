package BaekJoon.A21921

fun main() {
    fun read() = readLine()!!.split(" ").map { it.toInt() }
    val (n, x) = read()
    val l = read()
    // 예시
    // 5 2
    // 1 4 2 5 1

    // x 기간동안 총 방분자수 값을 저장
    val r = ArrayList<Int>()
    // 최초 크기 설정 (0 ~ x-1 까지의 합)
    r.add(l.slice(0 until x).sum())
    // 1 부터 n-x 까지 반복
    for (i in 1..n - x) {
        // 1 부터 x 길이 (1..2) 동안의 방문자 수 총합은 [ (1 4) 2 5 1 ]
        // 0 부터 x 길이 (0..1) 동안의 방문자 수 총합의 - l[0] + l[2] 입니다 [ 1 (4 2) 5 1 ]

        // n 부터 x 길이 (n..n+x-1) 동안의 방문자 수 총합은 (n-1 의 총합) - l[n-1] + l[n + x -1] 입니다
        r.add(r[i - 1] - l[i - 1] + l[i + x - 1])
    }
    val max = r.maxOf { it }
    print(if (max == 0) "SAD" else "$max\n${r.count { it == max }}")
}
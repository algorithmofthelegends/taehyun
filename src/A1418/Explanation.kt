package A1418

fun main() {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    // 각 자연수의 소인수 중 최대값을 저장
    val r = ArrayList<Int>()
    // 2 부터 n 까지 실행 (1 무조건 포함 된다고 가정)
    for (i in 2..n) {
        // 소인수 저장
        val l = ArrayList<Int>()
        var t = i
        // 소인수를 다 구할 때 까지
        while (t != 1) {
            // 2 부터 t (자신) 까지 값 중 나머지가 0 일 경우 소인수로 처리
            for (j in 2..t) {
                if (t % j == 0) {
                    t /= j
                    l.add(j)
                    break
                }
            }
        }
        // 소인수 중 가장 큰 값을 r 에 저앙
        r.add(l.maxOf { it })
    }
    // n 까지의 자연수 중 소인수의 크기가 k 보다 작거나 같은 경우의 수 출력
    print(r.count { k >= it } + 1)
}
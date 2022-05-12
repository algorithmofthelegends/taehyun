package BaekJoon.A1026

fun main() {
    val n = readLine()!!.toInt()
    // 첫번째 행을 입력 받고 오름차순으로 정렬 합니다
    val a = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val b = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    var result = 0

    for (i in 0 until n) {
        var idx = 0;
        for (y in b.indices) {
            if (b[y] > b[idx]) {
                idx = y
            }
        }

        // 두 번째 행에서 값이 큰 값 부터 차례로 첫번째 행과 곱하여 결과값에 저장합니다.
        // 곱한 두번째 행에는 -1 을 대입하여 사용 처리 합니다
        result += a[i] * b[idx]
        b[idx] = -1
    }
    print(result)
}
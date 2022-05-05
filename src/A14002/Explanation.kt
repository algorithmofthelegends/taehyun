package A14002

fun main() {
    val n = readLine()!!.toInt()
    // 0 부터 시작해서 수열 데이터를 받습니다
    val v = ("0 " + readLine()).split(" ").map { it.toInt() }
    // 맨 앞에 0을 추가 했기 때문에 n + 1
    // 수열 정렬 순서 를 담습니다
    // init : 0
    val d = Array(n + 1) { 0 }

    // n : 6
    // v : 0 10 20 10 30 20 50
    // d : 0 0 0 0 0 0 0

    // i : 1
    // v[i] : 10
    // m : 0
    // d : 0 1 0 0 0 0 0
    // m 이 0 이고 v[0] 보다 v[1] 이 더 크기 떄문에 d[1] = d[0] + 1

    // i : 2
    // v[i] : 20
    // m : 1
    // d : 0 1 2 0 0 0 0
    // m 이 1 이고 v[1] 보다 v[2] 이 더 크기 떄문에 d[2] = d[1] + 1

    // i : 3
    // v[i] : 10
    // m : 2
    // d : 0 1 2 1 0 0 0
    // m 이 2 이고 v[2] 보다 v[3] 이 더 작기 때문에 m -1
    // m 이 1 이고 v[1] 과 v[3] 이 같기 떄문에 m -1
    // m 이 0 이고 v[0] 보다 v[3] 이 더 크기 떄문에 d[3] = d[0] + 1

    // 0 다음 부터 for 실행
    for (i in 1..n) {
        // 수열 순서 중 가장 큰 값을 가져 옵니다
        var m = d.maxOf { it }
        do {
            // 수열 정렬 순서를 차례로 불러옵니다
            for (j in d.indices) {
                // 비교할 순서가 m 과 같고 d 에 저장된 index (j) 의 v (v[j]) 값보다 i 의 v (v[i]) 값이 더 클 경우
                if (d[j] == m && v[i] > v[j]) {
                    // d 에서 i index 의 값 설정
                    d[i] = m + 1
                    // m 을 -1로 설정하여 while 문을 break 합니다
                    m = -1
                    break
                }
            }
            m -= 1
        } while (m >= 0)
    }

    // 생성된 d 에서 최대 길이와 수열을 출력 합니다
    // v : 0 10 20 10 30 20 50
    // d : 0 1 2 1 3 2 4
    // 길이 : 4, 최대 길이 부터 -1 해서 출력

    val m = d.maxOf { it }
    var i = n + 1
    val r = Array(m) { 0 }
    for (j in m downTo 1) {
        for (k in n downTo 0) {
            if (d[k] == j && k < i) {
                i = k
                r[j - 1] = v[k]
                break
            }
        }
    }
    println(d.maxOf { it })
    print(r.joinToString(" "))
}
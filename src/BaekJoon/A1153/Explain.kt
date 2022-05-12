package BaekJoon.A1153

fun main() {
    val n = readLine()!!.toInt()

    // n 까지의 소수는 2 부터 n의 제곱근 까지의 숫자로 나눠서 나머지가 0 이 아닌 것들이 소수 입니다
    val r = List(n - 2) { it + 2 }
        .filter {
            var r = true
            for (i in 2..Math.sqrt(it.toDouble()).toInt())
                if (it % i == 0) {
                    r = false
                    break
                }
            r
        }

    // 8 이하는 -1을 출력하고
    // 짝수일 경우 2 2 와 두개의 소수
    // 홀수일 경우 2 3 와 두개의 소수
    if (n < 8)
        print(-1)
    else if (n % 2 == 0) {
        print("2 2")
        goldbach(n - 4, r)
    } else {
        print("2 3")
        goldbach(n - 5, r)
    }
}

// 합이 n 인 두 소수 a, b 를 출력 합니다
private fun goldbach(n: Int, r: List<Int>) {
    for (a in r)
        for (b in r)
            if (n == a + b) {
                print(" $a $b")
                return
            } else if (n < a + b) {
                break
            }
}
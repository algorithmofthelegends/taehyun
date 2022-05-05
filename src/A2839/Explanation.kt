package A2839

fun main() {
    val n = readLine()!!.toInt()
    // 설탕을 5로 나누고 몫 을 0 이 될 때 까지 반복 합니다
    for (i in n / 5 downTo 0)
        // 이때 설탕 크기에 5kg 봉지 갯수를 나누고 나머지가 3kg 봉지로 나눌 수 있을 경우 출력
        if ((n - i * 5) % 3 == 0) {
            print(i + (n - i * 5) / 3)
            return
        }
    print(-1)
}
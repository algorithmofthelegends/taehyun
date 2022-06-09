package BaekJoon.A25175

fun main() {
    var (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    // List 가 0 부터 시작이므로 -1
    m -= 1
    // 현재 모 에서 다음 모 까지의 거리 -3
    k -= 3
    // 현재 위치에서 k 까지 거리
    m += k
    // cycle 제거
    m %= n
    // 음수를 양수로, 양수여도 결과에 변화는 없음
    m += n
    // cycle 제거
    m %= n
    print(m + 1)
}
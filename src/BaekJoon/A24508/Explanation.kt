package BaekJoon.A24508

fun main() {
    val (_, k, t) = readLine()!!.split(" ").map { it.toInt() }
    // 두번째 열을 내림차순으로 정렬 합니다
    val v = readLine()!!.split(" ").map { it.toLong() }.sortedDescending()
    // v 의 합을 k 로 나눴을 때 나머지가 0 이 아니라면 무조건 NO
    // v 의 합 / k 만큼 v 를 자르고 그만큼 0 부터 v 를 slice 합니다
    // 자른 v 에서 각각 k 를 뺀 만큼의 합이 t 보다 작거나 같을 때 YES 가 나옵니다
    print(if (v.sum() % k == 0L && v.slice(0 until (v.sum() / k).toInt()).sumOf { k - it } <= t) "YES" else "NO")

//    v 정렬 : [4, 4, 4, 3]
//    v 합 : 15
//    v 합 / k : 3
//    v slice : [4, 4, 4]
//    t : 3
//    YES
}
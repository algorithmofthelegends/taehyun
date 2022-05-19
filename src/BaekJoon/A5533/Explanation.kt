package BaekJoon.A5533

fun main() {
    val n = readLine()!!.toInt()
    val v = Array(n) { readLine()!!.split(" ").map { it.toInt() } }

    // 플레이어 점수 결과 값
    val r = Array(n) { 0 }

    // 게임 수 만큼 반복
    for (x in 0..2) {
        val l = ArrayList<Array<Int>>()
        // x 번째 게임 결과를 y 명의 플레이어 수 만큼 l 에 저장
        for (y in 0 until n) l.add(arrayOf(y, v[y][x]))
        // 게임 점수가 유니크한 점수를 골라 해당 플레이어의 총 점에 더합니다
        l.filter { i -> l.count { it[1] == i[1] } == 1 }.forEach { r[it[0]] += it[1] }
    }
    r.forEach { println(it) }
}
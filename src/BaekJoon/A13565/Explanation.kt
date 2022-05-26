package BaekJoon.A13565

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val b = Array(n) { readLine()!!.toCharArray() }

    // b[y][x] 로 이동
    fun move(x: Int, y: Int) {
        // x 와 y 가 b 안에 존재하고 이동할 좌표에 전류가 흐를 수 있는 경우 상하좌우 이동
        if (x in 0 until m && y in 0 until n && b[y][x] == '0') {
            b[y][x] = '2'
            move(x - 1, y)
            move(x + 1, y)
            move(x, y - 1)
            move(x, y + 1)
        }
    }
    // y = 0 (b[0]) 축을 시작으로 모든 x 로 부터 전류를 흐르기 시작
    for (x in 0 until m)
        move(x, 0)
    // 마지막 행에 전류가 흘렀을 경우 YES
    print(if (b.last().contains('2')) "YES" else "NO")
}
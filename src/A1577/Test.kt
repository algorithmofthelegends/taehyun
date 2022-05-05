package A1577

fun main() {
    // 데이터 초기화
    val rd = fun() = readln()!!.split(" ").map { it.toInt() }
    val (n, m) = rd()
    val k = readln()!!.toInt()
    val l = Array(m + 1) { Array(n + 1) { 0 } }
    for (i in 0 until k) {
        val (a, b, c, d) = rd()
        l[a][b] = -1
        l[c][d] = -1
    }

    // n,m 까지 이동
    move(0, 0, n, m, l, 0)
    // 테스트 코드 출력
    l.forEach { println(it.contentDeepToString()) }
    // 결과 출력
    print(
        if (l[m][n] != -1)
            l[m][n]
        else if (l[m - 1][n] != -1)
            l[m - 1][n]
        else if (l[m][n - 1] != -1)
            l[m][n - 1]
        else 0
    )
}

private fun move(x: Int, y: Int, n: Int, m: Int, l: Array<Array<Int>>, c: Int) {
    // 현재 위치에 공사 중이 아닐 경우
    if (l[y][x] != -1)
    // 해당 위치를 거쳐간 만큼 +1
        l[y][x] += 1
    // 오른족 위치를 갈 수 있을 경우 이동
    if (x < n && l[y][x + 1] != -1)
        move(x + 1, y, n, m, l, c + 1)
    // 위 위치를 갈 수 있을 경우 이동
    if (y < m && l[y + 1][x] != -1)
        move(x, y + 1, n, m, l, c + 1)
}

//  - - 0 0 0 0
//  0 0 0 0 0 0
//  0 0 0 0 0 0
//  0 0 0 0 0 0
//  0 0 0 0 0 -
//  0 0 0 0 0 -

//  [-1, -1, 0, 0, 0, 0, 0]
//  [1, 1, 1, 1, 1, 1, 1]
//  [1, 2, 3, 4, 5, 6, 7]
//  [1, 3, 6, 10, 15, 21, 28]
//  [1, 4, 10, 20, 35, 56, 84]
//  [1, 5, 15, 35, 70, 126, -1]
//  [1, 6, 21, 56, 126, 252, -1]
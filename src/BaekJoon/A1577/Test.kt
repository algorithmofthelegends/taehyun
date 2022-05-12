package BaekJoon.A1577

fun main() {
//    예제
//    6 6
//    2
//    0 0 0 1
//    6 6 5 6
    val rd = fun() = readLine()!!.split(" ").map { it.toInt() }
    val (n, m) = rd()
    val k = readLine()!!.toInt()
    val l = Array<Array<Long>>(m + 1) { Array(n + 1) { 0 } }

    // 테스트용 출력
    val p = fun() {
        l.forEach { println(it.contentDeepToString()) }
        println()
    }

    // 공사중인 곳을 -1로 표시 합니다
    for (i in 0 until k) {
        val (a, b, c, d) = rd()
        l[a][b] = -1
        l[c][d] = -1
    }
    p()
//    [-1, -1, 0, 0, 0, 0, 0]
//    [0, 0, 0, 0, 0, 0, 0]
//    [0, 0, 0, 0, 0, 0, 0]
//    [0, 0, 0, 0, 0, 0, 0]
//    [0, 0, 0, 0, 0, 0, 0]
//    [0, 0, 0, 0, 0, 0, -1]
//    [0, 0, 0, 0, 0, 0, -1]

    // 시작점과 도착점을 초기화 해줍니다
    l[0][0] = 0
    l[m][n] = 0

    // 0번째 행과 열을 이동할 수 있는지 체크하여 1로 설정합니다
    for (i in 1..n) {
        if (l[0][i] == -1L)
            break
        l[0][i] = 1
    }
    for (i in 1..m) {
        if (l[i][0] == -1L)
            break
        l[i][0] = 1
    }
    p()
    // (0,1) 이 공사 중으로 이후 행들은 이동할 수 없습니다
//    [0, -1, 0, 0, 0, 0, 0]
//    [1, 0, 0, 0, 0, 0, 0]
//    [1, 0, 0, 0, 0, 0, 0]
//    [1, 0, 0, 0, 0, 0, 0]
//    [1, 0, 0, 0, 0, 0, 0]
//    [1, 0, 0, 0, 0, 0, -1]
//    [1, 0, 0, 0, 0, 0, 0]

    for (i in 1..m)
        for (j in 1..n)
            if (l[i][j] != -1L)
            // 현재 위치에 오는 경우의 수는 1칸 앞 행, 열의 합인 (i,j-1) + (i-1,j) 이지만 -1 인 경우가 있어서 +1 을 해줄지 정합니다
                l[i][j] = l[i][j - 1] + l[i - 1][j] + if (l[i][j - 1] == -1L || l[i - 1][j] == -1L) 1 else 0
    p()
    print(if (l[m][n] == -1L) 0 else l[m][n])
}
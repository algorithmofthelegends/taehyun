package A1018

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    // 초기 보드 설정
    val board = Array(n) {
        readLine()!!.toCharArray()
    }

    // c 와 다른 char 을 return
    val rc = fun(c: Char) = if (c == 'B') 'W' else 'B'
    // board 를 clone 합니다
    val cl = fun() = board.map { it.clone() }.toTypedArray().clone()
    // 체스판 최대 변경 수
    var min = 8 * 8
    for (a in 0..n - 8) {
        for (b in 0..m - 8) {
            // 시작점이 B, W 인 board
            val l1 = cl()
            val l2 = cl()
            // 넘겨 받은 board 를 수정한 수를 return 합니다
            val c = fun(l: Array<CharArray>): Int {
                var r = 0
                // (a,b) ~ (a+8,b+8) 까지 반복
                for (i in a until a + 8) {
                    for (j in b until b + 8) {
                        // 왼쪽에 보드가 있을 경우
                        if (j > b) {
                            // 같은 색이면 변경하고 + 1
                            if (l[i][j - 1] == l[i][j]) {
                                l[i][j] = rc(l[i][j])
                                r++
                            }
                            // 위쪽에 보드가 있을 경우
                        } else if (i > a) {
                            if (l[i - 1][j] == l[i][j]) {
                                l[i][j] = rc(l[i][j])
                                r++
                            }
                        }
                    }
                }
                return r
            }

            // 0.0 을 B, W 로 했을 때의 최소값을 구합니다
            // 기존 시작점의 변경 수
            val r1 = c(l1)
            // 기존 시작점을 다른 색으로 변경
            l2[a][b] = rc(l2[a][b])
            // l2 의 변경 수
            val r2 = c(l2)
            val r = if (r1 > r2) r2 + 1 else r1
            min = if (min > r) r else min
        }
    }
    print(min)
}
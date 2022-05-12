package BaekJoon.A1035

import kotlin.math.abs
import kotlin.math.min

// 조각의 위치, 이동 값, 원래 위치 가 표시되어 있는 2차원 배열
private lateinit var board: Array<Array<Int>>
// 조각의 확정된 위치
private lateinit var visit: ArrayList<Pair<Int, Int>>

fun main() {
    val piece = ArrayList<Pair<Int, Int>>()
    for (y in 0..4) {
        val l = readLine()!!.toCharArray()
        for (x in 0..4)
            if (l[x] == '*')
                piece.add(Pair(y, x))
    }

    //  이동 거리의 최소값
    var result = Int.MAX_VALUE

    // 기준점을 바꿔가며 최소 값을 구함
    for (x in piece.indices) {
        // 초기값
        board = Array(5) { Array(5) { 0 } }
        visit = ArrayList()

        //  기준점 설정
        visit.add(piece[x])

        // 조각의 기본 위치를 -1 로 설정 및 기준점과 인접한 조각의 위치 고정
        piece.forEachIndexed { index, it ->
            board[it.first][it.second] = -1
            if (x != index)
                visit(it)
        }

        // 조각을 움직일 필요가 없을 경우
        if (visit.size == piece.size) {
            print(0)
            return
        } else {
            // 조각의 위치를 옮기지 않아도 될 경우 1 로 설정
            visit.forEach {
                board[it.first][it.second] = 1
            }

            piece.forEachIndexed { _, i ->
                // 고정된 조각의 위치로 부터 이동 거리가 최소인 좌표를 구함
                val min = visit.map {
                    val v = move(i, it)
                    Pair(v, abs(i.first - v.first) + abs(i.second - v.second) + 1)
                }.sortedBy {
                    it.second
                }.first()

                // 조각의 이동하고  빈 자리는 0 설정
                board[i.first][i.second] = 0
                // 조각이 이동한 자리는 움직인 거리값으로 설정
                board[min.first.first][min.first.second] = min.second
            }

            // 조각의 최소 이동거리 값 저장
            result = min(result, board.sumOf { it.sum() } - piece.size)

//            *...*
//            .....
//            .....
//            .....
//            *...*
//
//            [1, 4, 0, 0, 0]
//            [4, 7, 0, 0, 0]
//            [0, 0, 0, 0, 0]
//            [0, 0, 0, 0, 0]
//            [0, 0, 0, 0, 0]
//            총 이동거리 16 에서 조각의 크기 4 를 빼면 12 가 최소 값이 됨
        }
    }
    print(result)
}

// 조각 이동
private fun move(i: Pair<Int, Int>, target: Pair<Int, Int>): Pair<Int, Int> {
    // y 축 이동 절대값
    val f = abs(target.first - i.first)
    // x 축 이동 절대값
    val s = abs(target.second - i.second)

    if (f + s == 0) {
        // 이동할 필요가 없으면 해당 좌표 리턴
        return i
    } else if (board[target.first][target.second] == 0) {
        // 이동할 좌표가 비어있을 경우 좌표 리턴
        return target
    } else {
        // 좌표에 이미 조각이 있거나 1,  다른 조각이 움직이지 않았을 경우 -1
        // 다음 이동할 좌표를 설정
        val target2 =
            // y 축 이동을 많이 했으면 y 축 이동을 1 만큼 줄입니다
            if (f > s)
                Pair(
                    if (target.first > i.first) target.first - 1 else target.first + 1,
                    target.second
                )
            else
                Pair(
                    target.first,
                    if (target.second > i.second) target.second - 1 else target.second + 1,
                )
        return move(
            i,
            target2
        )
    }
}

// 기준 조각과 인접한 조각 설정
private fun visit(target: Pair<Int, Int>) {
    for (i in visit.indices) {
        if (abs(visit[i].first - target.first) + abs(visit[i].second - target.second) == 1) {
            visit.add(target)
            break;
        }
    }
}
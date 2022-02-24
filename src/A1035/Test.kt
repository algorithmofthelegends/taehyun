package A1035

import kotlin.math.abs
import kotlin.math.min

private lateinit var board: Array<Array<Int>>
private lateinit var visit: ArrayList<Pair<Int, Int>>

fun main() {
    val piece = ArrayList<Pair<Int, Int>>()
    for (y in 0..4) {
        val l = readLine()!!.toCharArray()
        for (x in 0..4)
            if (l[x] == '*')
                piece.add(Pair(y, x))
    }

    var result = 13
    for (x in piece.indices) {
        board = Array(5) { Array(5) { 0 } }
        visit = ArrayList()
        visit.add(piece[x])

        piece.forEach {
            board[it.first][it.second] = -1
            visit(it)
        }

        piece.forEachIndexed { _, i ->
            val min = visit.map {
                val v = move(i, it)
                Pair(v, abs(i.first - v.first) + abs(i.second - v.second) + 1)
            }.sortedBy {
                it.second
            }.first()
            board[i.first][i.second] = 0
            board[min.first.first][min.first.second] = min.second
            println("-------")
            println(min)
            println("-------")
            printArr(board)
        }
        result = min(result, board.sumOf { it.sum() } - piece.size)
        println(result)
        println("---end---")
    }
    print(result)
}

private fun move(i: Pair<Int, Int>, target: Pair<Int, Int>): Pair<Int, Int> {
    val f = abs(target.first - i.first)
    val s = abs(target.second - i.second)

    println("$target $i")
    println("$f $s")

    if (f + s == 0) {
        return i
    } else if (board[target.first][target.second] == 0) {
        return target
    } else {
        val target2 =
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

private fun visit(target: Pair<Int, Int>) {
    for (i in visit.indices) {
        if (abs(visit[i].first - target.first) + abs(visit[i].second - target.second) == 1) {
            visit.add(target)
            break;
        }
    }
}

private fun printArr(arr: Array<Array<Int>>) {
    board.forEach {
        println(it.contentDeepToString())
    }
}
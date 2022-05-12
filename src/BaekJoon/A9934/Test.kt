package BaekJoon.A9934

import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val num = 2.0
    val line = 4
    val last = num.pow(line - 1).toInt()
    val arr = (1 until num.pow(line).toInt()).map { it.toString() }
    var result = Array<Array<String>>(line) { Array<String>(last) { "" } }

    println(last)
    println(arr)

    var i = 0
    var y = line - 1
    var x = 0
    var istLeft = true;
    var move = false;
    while (i < arr.size - 1) {
        println("y = $y, x = $x")

        if (!move && result[y][x] == "" && result[y - 1][x] == "" && result[y][x + 1] == "") {

            // when : 자신, 부모, 부모의 우측 자식이 비어있을 경우
            // do : 자신, 부모, 부모의 우측 자식에 값 저장
            // go : 부모로 이동
            result[y][x] = arr[i]
            result[y - 1][x] = arr[i + 1];
            result[y][x + 1] = arr[i + 2];

            if (istLeft) {
                y -= 1
            } else {
                y -= 2
                x -= 2
                istLeft = true
            }
            i += 3
        } else if (result[y + 1][x] != "" && result[y + 1][x + 2] != "") {
            // when : 좌측 우측 자식 값이 존재할 경우
            // do : 부모에 값 저장
            // go : 부모의 우측 자식으로 이동
            result[y - 1][x] = arr[i];
            i += 1
            x += 4
            move = true
        } else if (!move && result[y - 1][x] == "" && result[y][x + 2] == "") {
            // when : 부모와 우측 자식이 비었을 경우
            // do : 부모에 값 저장
            // go : 부모의 우측 자식으로 이동
            result[y - 1][x] = arr[i];
            i += 1
            y += 1
            x += 2
            istLeft = false
        } else {
            // when : 부모 값이 존재하고 본인이 우측 자식이며 두 자식의 값이 없을 경우
            // go : 최하단 좌측 자식으로 이동
            y += line - y - 1
            move = false
        }

        println(result.contentDeepToString())
    }
}
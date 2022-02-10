package A9934

import java.util.*
import kotlin.math.pow

fun main() = with(Scanner(System.`in`)) {
    // 2의 제곱근을 이용하기 위함
    val num = 2.0
    // 입력 - 줄
    val line = 4
    // 입력 - 빌딩 번호
    val arr = (1 until num.pow(line).toInt()).map { it.toString() }
    // 마지막 줄 갯수
    val last = num.pow(line - 1).toInt()
    // 결과
    val result = Array(line) { Array(last) { "" } }

    var idx = 1
    arr.forEach {
        // 맨 윗 줄 부터 시작
        for (y in 0 until line) {
            // 입력 순서를 (줄 - y -1)로 나눌 때 "0" 이거나 마지막 줄 일 경우
            // (줄 - y -1) : 맨 아랫 줄 부터 2, 4, 8.. 로 2의 제곱근 만큼 값 차이가 나는걸 이용
            if (idx % num.pow(line - y - 1).toInt() == 0 || y == line - 1) {
                result[y] = result[y].plus(it)
                idx++
                break;
            }
        }
    }

    // 결과 출력
    result.forEach { y ->
        y.forEach { x ->
            if (x != "")
                print("$x ")
        }
        println()
    }
}
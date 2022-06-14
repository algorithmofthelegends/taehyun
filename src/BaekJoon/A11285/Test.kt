package BaekJoon.A11285

import kotlin.test.assertEquals

fun main() {
    assertEquals(test(arrayOf('ㄴ', 'ㅏ')), '나')
    assertEquals(test(arrayOf('ㄷ', 'ㅏ')), '다')
    assertEquals(test(arrayOf('ㄱ', 'ㅏ', 'ㅁ')), '감')
    assertEquals(test(arrayOf('ㅂ', 'ㅐ', 'ㄱ')), '백')
    assertEquals(test(arrayOf('ㅈ', 'ㅜ', 'ㄴ')), '준')
}

private fun test(b: Array<Char>): Char {
    val c = arrayOf('ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ')
    val e = arrayOf('ㄸ', 'ㅃ')
    val n = (12623..12643).map { it.toChar() }
    val j = (12593..12622).filter { !e.contains(it.toChar()) }.map { it.toChar() }
    // (초성 * 21 + 중성) * 28 + 종성 + 0xAC00
    return ((c.indexOf(b[0]) * 21 + n.indexOf(b[1])) * 28 + (if (b.size > 2 && j.contains(b[2])) j.indexOf(b[2]) + 1 else 0) + 0xAC00).toChar()
}

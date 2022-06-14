package BaekJoon.A11285

import kotlin.test.assertEquals

fun main() {
    assertEquals(test(arrayOf("ㄴ", "ㅏ")), "나")
    assertEquals(test(arrayOf("ㄷ", "ㅏ")), "다")
    assertEquals(test(arrayOf("ㄱ", "ㅏ", "ㅁ")), "감")
    assertEquals(test(arrayOf("ㅂ", "ㅐ", "ㄱ")), "백")
    assertEquals(test(arrayOf("ㅈ", "ㅜ", "ㄴ")), "준")
}

private fun test(b: Array<String>): String {
    val c = arrayOf("ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ")
    val n = arrayOf("ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ")
    val j = arrayOf("", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ")
    return ((c.indexOf(b[0]) * 21 + n.indexOf(b[1])) * 28 + (if (b.size > 2 && j.contains(b[2])) j.indexOf(b[2]) else 0) + 0xAC00).toChar().toString()
}

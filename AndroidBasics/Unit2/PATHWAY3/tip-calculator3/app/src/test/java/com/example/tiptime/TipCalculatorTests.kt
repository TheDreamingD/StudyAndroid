package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

/*
 * 테스트는 test 디렉토리 밑에 만들어야하고,
 * 실제 앱 코드의 디렉토리 구조와 같게 만들어야 한다.
 * 로컬 테스트는 소량의 코드를 테스트하는 용도다.
 */
class TipCalculatorTests {

    /*
     * 이름에 테스트 내용과 예상 결과가 나와있다.
     * 어설션을 주로 사용한다.
     */
    @Test // 이 어노테이션을 붙여야 컴파일러가 테스트 메소드라는 것을 알고 적절하게 실행해준다.
    fun calculateTip_20PercentNoRoundUp() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}
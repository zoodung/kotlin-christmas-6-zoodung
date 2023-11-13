package christmas

import christmas.model.Customered
import christmas.model.StoreMenu
import christmas.utils.Validate.validateVisitDate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CustomerTest {
    /*private val customer: Customered = Customered(25, listOf("해산물파스타" to 1, "아이스크림" to 2, "레드와인" to 3))

    @Test
    fun `총 주문 금액 테스트`() {
        val totalOrderSum = customer.calculateTotalOrderSum()

        Assertions.assertTrue(totalOrderSum == 22_5000)
    }

    @ValueSource(strings = ["", "Tomorrow", "12.11", " 25", "25 ", "-1", "0", "32"])
    @ParameterizedTest
    fun `예상 방문 날짜 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> {
            validateVisitDate(input)
        }
    }

    @ValueSource(strings = ["", "초코케이크2"])
    @ParameterizedTest
    fun `주문 메뉴와 개수 스플릿 전 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> {
            validateOrderMenuBeforeSplit(input)
        }
    }

    @ValueSource(strings = ["당근케이크-1", "초코케이크-a", "초코케이크-0", "초코케이크-5,샴페인-16", "초코케이크-5,초코케이크-5", "제로콜라-5,샴페인-1"])
    @ParameterizedTest
    fun `주문 메뉴와 개수 스플릿 후 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> {
            validateOrderMenuAfterSplit(StoreMenu.splitOrderItems(input))
        }
    }*/
}
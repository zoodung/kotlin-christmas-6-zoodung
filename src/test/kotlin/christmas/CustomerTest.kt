package christmas

import christmas.model.Customer
import christmas.model.OrderItems
import christmas.model.StoreMenu
import christmas.utils.Validate.validateOrderMenu
import christmas.utils.Validate.validateVisitDate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CustomerTest {
    private val customer: Customer = Customer(25, listOf(OrderItems("해산물파스타", 1), OrderItems("아이스크림", 2), OrderItems("레드와인", 3)))

    @Test
    fun `총 주문 금액 계산 테스트`() {
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

    @ValueSource(strings = ["", "초코케이크2", "당근케이크-1", "초코케이크-a", "초코케이크-0", "초코케이크-5,샴페인-16", "초코케이크-5,초코케이크-5", "제로콜라-5,샴페인-1"])
    @ParameterizedTest
    fun `주문 메뉴와 개수 입력 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> {
            validateOrderMenu(StoreMenu.splitOrderMenuForValidate(input))
        }
    }
}
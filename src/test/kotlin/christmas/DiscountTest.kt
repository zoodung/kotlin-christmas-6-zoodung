package christmas

import christmas.model.event.Discount
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DiscountTest {
    private var discount: Discount = Discount()

    @Test
    fun `디데이 할인 금액 테스트`() {
        val discountAmount = discount.applyTheDayDiscount(25)

        Assertions.assertTrue(discountAmount == 3400)
    }

    @Test
    fun `평일 할인 금액 테스트`() {
        val discountAmount = discount.applyWeekdayDiscount(listOf("해산물파스타", "초코케이크", "아이스크림"))

        Assertions.assertTrue(discountAmount == 4046)
    }

    @Test
    fun `주말 할인 금액 테스트`() {
        val discountAmount = discount.applyWeekendDiscount(listOf("해산물파스타", "초코케이크", "아이스크림"))

        Assertions.assertTrue(discountAmount == 2023)
    }

    @Test
    fun `특별 할인 금액 테스트`() {
        val discountAmount = discount.applySpecialDiscount()

        Assertions.assertTrue(discountAmount == 1000)
    }
}
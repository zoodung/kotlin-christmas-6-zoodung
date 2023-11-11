package christmas

import christmas.model.event.Discount
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DiscountTest {
    private var discount: Discount = Discount()

    @Test
    fun `디데이 할인 금액 테스트`() {
        val discountAmount = discount.applyTheDayDiscount(1)

        Assertions.assertTrue(discountAmount == 1000)
    }
}
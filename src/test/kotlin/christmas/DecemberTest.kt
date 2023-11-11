package christmas

import christmas.model.DecemberEvent
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DecemberTest {
    private val decemberEvent: DecemberEvent = DecemberEvent()

    @Test
    fun `디데이 할인 금액 테스트`() {
        val discountAmount = decemberEvent.applyTheDayDiscount(25)

        Assertions.assertTrue(discountAmount == 3400)
    }

    @Test
    fun `평일 할인 금액 테스트`() {
        val discountAmount = decemberEvent.applyWeekdayDiscount(listOf("해산물파스타", "초코케이크", "아이스크림"))

        Assertions.assertTrue(discountAmount == 4046)
    }

    @Test
    fun `주말 할인 금액 테스트`() {
        val discountAmount = decemberEvent.applyWeekendDiscount(listOf("해산물파스타", "초코케이크", "아이스크림"))

        Assertions.assertTrue(discountAmount == 2023)
    }

    @Test
    fun `특별 할인 금액 테스트`() {
        val discountAmount = decemberEvent.applySpecialDiscount()

        Assertions.assertTrue(discountAmount == 1000)
    }

    @Test
    fun `샴페인 증정 테스트`() {
        Assertions.assertTrue(decemberEvent.presentChampagne(130_000))
    }
}
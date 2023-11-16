package christmas

import christmas.model.DecemberEvent
import christmas.model.OrderItems
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DecemberEventTest {
    private val decemberEvent: DecemberEvent = DecemberEvent()

    @Test
    fun `디데이 할인 금액 테스트`() {
        val discountAmount = decemberEvent.applyTheDayDiscount(25)

        Assertions.assertTrue(discountAmount == 3400)
    }

    @Test
    fun `평일 할인 금액 테스트`() {
        val discountAmount = decemberEvent.applyWeekdayDiscount(listOf(OrderItems("초코케이크", 2), OrderItems("해산물파스타", 3)))

        Assertions.assertTrue(discountAmount == 4046)
    }

    @Test
    fun `주말 할인 금액 테스트`() {
        val discountAmount = decemberEvent.applyWeekendDiscount(listOf(OrderItems("초코케이크", 2), OrderItems("해산물파스타", 3)))

        Assertions.assertTrue(discountAmount == 6069)
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

    @Test
    fun `배지 부여 테스트`() {
        val noneBadge = decemberEvent.assignBadge(0)
        val starBadge = decemberEvent.assignBadge(5000)
        val treeBadge = decemberEvent.assignBadge(10000)
        val santaBadge = decemberEvent.assignBadge(200000)

        Assertions.assertTrue(noneBadge == "없음")
        Assertions.assertTrue(starBadge == "별")
        Assertions.assertTrue(treeBadge == "트리")
        Assertions.assertTrue(santaBadge == "산타")
    }
}
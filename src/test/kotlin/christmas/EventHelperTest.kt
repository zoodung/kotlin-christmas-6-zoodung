package christmas

import christmas.model.Customer
import christmas.model.DiscountType
import christmas.model.OrderItems
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class EventHelperTest {
    private val customer = Customer(25, listOf(OrderItems("해산물파스타", 1),
        OrderItems("아이스크림", 2), OrderItems("레드와인", 3)))

    @Test
    fun `총 혜택 금액 계산 테스트`() {
        customer.requestApplyDecemberEvent()
        val totalBenefitAmount = customer.getEventHelper().calculateTotalBenefitAmount()

        Assertions.assertTrue(totalBenefitAmount == 33446)
    }

    @Test
    fun `이벤트 적용 기능 테스트`() {
        customer.getEventHelper().applyDecemberEvent(25, customer.getOrderMenu(), customer.calculateTotalOrderSum())

        Assertions.assertEquals(3400, customer.getEventHelper().getDiscountHistory().find { it.first == DiscountType.THE_DAY_DISCOUNT }?.second)
        Assertions.assertEquals(4046, customer.getEventHelper().getDiscountHistory().find { it.first == DiscountType.WEEKDAY_DISCOUNT }?.second)
        Assertions.assertEquals(0, customer.getEventHelper().getDiscountHistory().find { it.first == DiscountType.WEEKEND_DISCOUNT }?.second)
        Assertions.assertEquals(1000, customer.getEventHelper().getDiscountHistory().find { it.first == DiscountType.SPECIAL_DISCOUNT }?.second)

        Assertions.assertTrue(customer.getEventHelper().getFreebie())
        Assertions.assertEquals("별", customer.getEventHelper().getBadge())
    }
}
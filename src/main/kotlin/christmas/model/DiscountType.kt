package christmas.model

import christmas.utils.Constant.CHRISTMAS_DAY
import christmas.utils.Constant.EMPTY

enum class DiscountType(val eventName: String) {
    THE_DAY_DISCOUNT("크리스마스 디데이 할인"),
    WEEKDAY_DISCOUNT("평일 할인"),
    WEEKEND_DISCOUNT("주말 할인"),
    SPECIAL_DISCOUNT("특별 할인");

    companion object {
        private val decemberEvent = DecemberEvent()

        fun requestTheDayDiscount(visitDate: Int): Int {
            if (visitDate <= CHRISTMAS_DAY)
                return decemberEvent.applyTheDayDiscount(visitDate)

            return EMPTY
        }

        fun requestWeekdayDiscount(visitDate: Int, orderMenu: List<OrderItems>): Int {
            if (visitDate in DecemberCalender.WEEKDAY.dates)
                return decemberEvent.applyWeekdayDiscount(orderMenu)

            return EMPTY
        }

        fun requestWeekendDiscount(visitDate: Int, orderMenu: List<OrderItems>): Int {
            if (visitDate in DecemberCalender.WEEKEND.dates)
                return decemberEvent.applyWeekendDiscount(orderMenu)

            return EMPTY
        }

        fun requestSpecialDiscount(visitDate: Int): Int {
            if (visitDate in DecemberCalender.SPECIAL_DAY.dates)
                return decemberEvent.applySpecialDiscount()

            return EMPTY
        }
    }
}
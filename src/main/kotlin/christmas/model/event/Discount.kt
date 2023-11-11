package christmas.model.event

import christmas.utils.Constant.DAILY_DISCOUNT_AMOUNT
import christmas.utils.Constant.FIRST_DAY_DISCOUNT_AMOUNT
import christmas.utils.Constant.ONE_DAY_DECREASE
import christmas.utils.Constant.WEEK_DISCOUNT_AMOUNT

class Discount {
    fun applyTheDayDiscount(day: Int): Int {
        val dailyDiscount = (day - ONE_DAY_DECREASE) * DAILY_DISCOUNT_AMOUNT
        return FIRST_DAY_DISCOUNT_AMOUNT + dailyDiscount
    }

    fun applyWeekdayDiscount(menu : List<String>): Int {
        val desertCount = menu.count { it == "초코케이크" || it == "아이스크림"}

        return desertCount * WEEK_DISCOUNT_AMOUNT
    }
}
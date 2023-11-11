package christmas.model.event

import christmas.utils.Constant.CHRISTMAS_DAY
import christmas.utils.Constant.DAILY_DISCOUNT_AMOUNT
import christmas.utils.Constant.FIRST_DAY_DISCOUNT_AMOUNT
import christmas.utils.Constant.INITIALIZE_NUMBER
import christmas.utils.Constant.ONE_DAY_DECREASE

class Discount {
    fun applyTheDayDiscount(day: Int): Int {
        val dailyDiscount = (day - ONE_DAY_DECREASE) * DAILY_DISCOUNT_AMOUNT
        return FIRST_DAY_DISCOUNT_AMOUNT + dailyDiscount
    }
}
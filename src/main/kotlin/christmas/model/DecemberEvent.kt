package christmas.model

import christmas.utils.Constant
import christmas.utils.Constant.CHRISTMAS_DAY_DISCOUNT_AMOUNT
import christmas.utils.Constant.DAILY_DISCOUNT_AMOUNT
import christmas.utils.Constant.FIRST_DAY_DISCOUNT_AMOUNT
import christmas.utils.Constant.INITIALIZE_NUMBER
import christmas.utils.Constant.ONE_DAY_DECREASE
import christmas.utils.Constant.WEEK_DISCOUNT_AMOUNT

class DecemberEvent {
    fun applyTheDayDiscount(date: Int): Int {
        val dailyDiscount = (date - ONE_DAY_DECREASE) * DAILY_DISCOUNT_AMOUNT

        return FIRST_DAY_DISCOUNT_AMOUNT + dailyDiscount
    }

    fun applyWeekdayDiscount(orderMenu: List<Pair<String, Int>>): Int {
        var dessertMenuCount = INITIALIZE_NUMBER

        for ((menuName, quantity) in orderMenu) {
            if (menuName == "초코케이크" || menuName == "아이스크림") {
                dessertMenuCount += quantity
            }
        }

        return dessertMenuCount * WEEK_DISCOUNT_AMOUNT
    }

    fun applyWeekendDiscount(orderMenu: List<Pair<String, Int>>): Int {
        var mainMenuCount = INITIALIZE_NUMBER

        for ((menuName, quantity) in orderMenu) {
            if (menuName == "티본스테이크" || menuName == "바비큐립" || menuName == "해산물파스타" || menuName == "크리스마스파스타") {
                mainMenuCount += quantity
            }
        }

        return mainMenuCount * WEEK_DISCOUNT_AMOUNT
    }

    fun applySpecialDiscount(): Int = CHRISTMAS_DAY_DISCOUNT_AMOUNT

    fun presentChampagne(totalOrderAmount: Int): Boolean = totalOrderAmount > Constant.CHAMPAGNE_CONDITION_AMOUNT

    fun assignBadge(benefitAmount: Int): String {
        when {
            benefitAmount in Constant.STAR_MIN..Constant.STAR_MAX -> return Constant.BADGE_STAR
            benefitAmount in Constant.TREE_MIN..Constant.TREE_MAX -> return Constant.BADGE_TREE
            benefitAmount >= Constant.SANTA_MIN -> return Constant.BADGE_SANTA
        }

        return Constant.NONE
    }
}
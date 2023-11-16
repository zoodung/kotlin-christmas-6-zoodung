package christmas.model

import christmas.utils.Constant.BADGE_SANTA
import christmas.utils.Constant.BADGE_STAR
import christmas.utils.Constant.BADGE_TREE
import christmas.utils.Constant.CHAMPAGNE_CONDITION_AMOUNT
import christmas.utils.Constant.CHRISTMAS_DAY_DISCOUNT_AMOUNT
import christmas.utils.Constant.DAILY_DISCOUNT_AMOUNT
import christmas.utils.Constant.FIRST_DAY_DISCOUNT_AMOUNT
import christmas.utils.Constant.EMPTY
import christmas.utils.Constant.NONE
import christmas.utils.Constant.ONE_DAY_DECREASE
import christmas.utils.Constant.SANTA_MIN
import christmas.utils.Constant.STAR_MAX
import christmas.utils.Constant.STAR_MIN
import christmas.utils.Constant.TREE_MAX
import christmas.utils.Constant.TREE_MIN
import christmas.utils.Constant.WEEK_DISCOUNT_AMOUNT

class DecemberEvent {
    fun applyTheDayDiscount(date: Int): Int {
        val dailyDiscount = (date - ONE_DAY_DECREASE) * DAILY_DISCOUNT_AMOUNT

        return FIRST_DAY_DISCOUNT_AMOUNT + dailyDiscount
    }

    fun applyWeekdayDiscount(orderMenu: List<OrderItems>): Int {
        var dessertMenuCount = EMPTY

        for (item in orderMenu) {
            val increaseCount = increaseDessertMenuCount(item.getMenuName(), item.getQuantity())
            dessertMenuCount += increaseCount
        }

        return dessertMenuCount * WEEK_DISCOUNT_AMOUNT
    }

    private fun increaseDessertMenuCount(menuName: String, quantity: Int): Int {
        if (menuName == StoreMenu.CHOCO_CAKE.menuName || menuName == StoreMenu.ICE_CREAM.menuName)
            return quantity

        return EMPTY
    }


    fun applyWeekendDiscount(orderMenu: List<OrderItems>): Int {
        var mainMenuCount = EMPTY

        for (item in orderMenu) {
            val increaseCount = increaseMainMenuCount(item.getMenuName(), item.getQuantity())
            mainMenuCount += increaseCount
        }

        return mainMenuCount * WEEK_DISCOUNT_AMOUNT
    }

    private fun increaseMainMenuCount(menuName: String, quantity: Int): Int {
        if (menuName == StoreMenu.T_BONE_STEAK.menuName || menuName == StoreMenu.BBQ_RIBS.menuName ||
            menuName == StoreMenu.SEAFOOD_PASTA.menuName || menuName == StoreMenu.CHRISTMAS_PASTA.menuName
        )
            return quantity

        return EMPTY
    }

    fun applySpecialDiscount(): Int = CHRISTMAS_DAY_DISCOUNT_AMOUNT

    fun presentChampagne(totalOrderAmount: Int): Boolean = totalOrderAmount >= CHAMPAGNE_CONDITION_AMOUNT

    fun assignBadge(benefitAmount: Int): String {
        when {
            benefitAmount in STAR_MIN..STAR_MAX -> return BADGE_STAR
            benefitAmount in TREE_MIN..TREE_MAX -> return BADGE_TREE
            benefitAmount >= SANTA_MIN -> return BADGE_SANTA
        }

        return NONE
    }
}
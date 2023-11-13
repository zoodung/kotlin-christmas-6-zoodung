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
            val increaseCount = increaseDessertMenuCount(menuName, quantity)
            dessertMenuCount += increaseCount
        }

        return dessertMenuCount * WEEK_DISCOUNT_AMOUNT
    }

    private fun increaseDessertMenuCount(menuName: String, quantity: Int): Int {
        if (menuName == StoreMenu.CHOCO_CAKE.menuName || menuName == StoreMenu.ICE_CREAM.menuName)
            return quantity
        return INITIALIZE_NUMBER
    }


    fun applyWeekendDiscount(orderMenu: List<Pair<String, Int>>): Int {
        var mainMenuCount = INITIALIZE_NUMBER

        for ((menuName, quantity) in orderMenu) {
            val increaseCount = increaseMainMenuCount(menuName, quantity)
            mainMenuCount += increaseCount
        }

        return mainMenuCount * WEEK_DISCOUNT_AMOUNT
    }

    private fun increaseMainMenuCount(menuName: String, quantity: Int): Int {
        if (menuName == StoreMenu.T_BONE_STEAK.menuName || menuName == StoreMenu.BBQ_RIBS.menuName ||
            menuName == StoreMenu.SEAFOOD_PASTA.menuName || menuName == StoreMenu.CHRISTMAS_PASTA.menuName
        )
            return quantity
        return INITIALIZE_NUMBER
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
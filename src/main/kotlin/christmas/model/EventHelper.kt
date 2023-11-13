package christmas.model

import christmas.utils.Constant
import christmas.utils.Constant.EMPTY

class EventHelper(
    private val visitDate: Int,
    private val orderMenu: List<OrderItems>
) {
    private val decemberEvent = DecemberEvent()
    private val discountHistory = mutableMapOf<DiscountType, Int>()
    private val freebie: Boolean
        get() = decemberEvent.presentChampagne(calculateTotalOrderSum())
    private val badge: String
        get() = decemberEvent.assignBadge(discountHistory.values.sum())

    init {
        DiscountType.entries.forEach {
            discountHistory[it] = EMPTY
        }
    }

    fun getDiscountHistory(): List<Pair<DiscountType, Int>> = discountHistory.toList()

    fun calculateTotalBenefitAmount(): Int {
        if (freebie)
            return discountHistory.values.sum() + StoreMenu.CHAMPAGNE.menuPrice
        return discountHistory.values.sum()
    }

    private fun calculateTotalOrderSum(): Int {
        var totalOrderSum = EMPTY

        for (item in orderMenu) {
            val storeMenu = enumValues<StoreMenu>().first { menu -> menu.menuName == item.getMenuName() }
            totalOrderSum += storeMenu.menuPrice * item.getQuantity()
        }

        return totalOrderSum
    }

    fun applyDecemberEvent() {
        if (calculateTotalOrderSum() > Constant.DISCOUNT_THRESHOLD) {
            discountHistory[DiscountType.THE_DAY_DISCOUNT] = requestTheDayDiscount()
            discountHistory[DiscountType.WEEKDAY_DISCOUNT] = requestWeekdayDiscount()
            discountHistory[DiscountType.WEEKEND_DISCOUNT] = requestWeekendDiscount()
            discountHistory[DiscountType.SPECIAL_DISCOUNT] = requestSpecialDiscount()
        }
    }

    private fun requestTheDayDiscount(): Int {
        if (visitDate <= Constant.CHRISTMAS_DAY)
            return decemberEvent.applyTheDayDiscount(visitDate)

        return EMPTY
    }

    private fun requestWeekdayDiscount(): Int {
        if (visitDate in DecemberCalender.WEEKDAY.dates)
            return decemberEvent.applyWeekdayDiscount(orderMenu)

        return EMPTY
    }

    private fun requestWeekendDiscount(): Int {
        if (visitDate in DecemberCalender.WEEKEND.dates)
            return decemberEvent.applyWeekendDiscount(orderMenu)

        return EMPTY
    }

    private fun requestSpecialDiscount(): Int {
        if (visitDate in DecemberCalender.SPECIAL_DAY.dates)
            return decemberEvent.applySpecialDiscount()

        return EMPTY
    }
}
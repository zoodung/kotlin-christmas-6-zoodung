package christmas.model

import christmas.model.DiscountType.Companion.requestSpecialDiscount
import christmas.model.DiscountType.Companion.requestTheDayDiscount
import christmas.model.DiscountType.Companion.requestWeekdayDiscount
import christmas.model.DiscountType.Companion.requestWeekendDiscount
import christmas.utils.Constant
import christmas.utils.Constant.EMPTY

class EventHelper(
    private val customer: Customer
) {
    private val decemberEvent = DecemberEvent()
    private val visitDate = customer.getVisitDate()
    private val orderMenu = customer.getOrderMenu()
    private val discountHistory = mutableMapOf<DiscountType, Int>()
    private val freebie = decemberEvent.presentChampagne(calculateTotalOrderSum())
    private val badge = decemberEvent.assignBadge(discountHistory.values.sum())

    init {
        DiscountType.entries.forEach {
            discountHistory[it] = EMPTY
        }
    }

    fun getDiscountHistory(): List<Pair<DiscountType, Int>> = discountHistory.toList()

    fun getFreebie(): Boolean = freebie

    fun getBadge(): String = badge

    fun calculateTotalBenefitAmount(): Int {
        if (freebie)
            return discountHistory.values.sum() + StoreMenu.CHAMPAGNE.menuPrice
        return discountHistory.values.sum()
    }

    fun calculateTotalOrderSum(): Int {
        var totalOrderSum = EMPTY

        for (item in orderMenu) {
            val storeMenu = enumValues<StoreMenu>().first { menu -> menu.menuName == item.getMenuName() }
            totalOrderSum += storeMenu.menuPrice * item.getQuantity()
        }

        return totalOrderSum
    }

    fun applyDecemberEvent() {
        if (calculateTotalOrderSum() > Constant.DISCOUNT_THRESHOLD) {
            discountHistory[DiscountType.THE_DAY_DISCOUNT] = requestTheDayDiscount(visitDate)
            discountHistory[DiscountType.WEEKDAY_DISCOUNT] = requestWeekdayDiscount(visitDate, orderMenu)
            discountHistory[DiscountType.WEEKEND_DISCOUNT] = requestWeekendDiscount(visitDate, orderMenu)
            discountHistory[DiscountType.SPECIAL_DISCOUNT] = requestSpecialDiscount(visitDate)
        }
    }
}
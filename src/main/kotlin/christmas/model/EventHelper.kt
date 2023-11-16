package christmas.model

import christmas.model.DiscountType.Companion.requestSpecialDiscount
import christmas.model.DiscountType.Companion.requestTheDayDiscount
import christmas.model.DiscountType.Companion.requestWeekdayDiscount
import christmas.model.DiscountType.Companion.requestWeekendDiscount
import christmas.utils.Constant.EMPTY
import christmas.utils.Constant.NONE

class EventHelper {
    private val decemberEvent = DecemberEvent()
    private val discountHistory = mutableMapOf<DiscountType, Int>()
    private var freebie: Boolean = false
    private var badge: String = NONE

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

    fun applyDecemberEvent(visitDate: Int, orderMenu: List<OrderItems>, totalOrderSum: Int) {
        discountHistory[DiscountType.THE_DAY_DISCOUNT] = requestTheDayDiscount(visitDate)
        discountHistory[DiscountType.WEEKDAY_DISCOUNT] = requestWeekdayDiscount(visitDate, orderMenu)
        discountHistory[DiscountType.WEEKEND_DISCOUNT] = requestWeekendDiscount(visitDate, orderMenu)
        discountHistory[DiscountType.SPECIAL_DISCOUNT] = requestSpecialDiscount(visitDate)
        freebie = decemberEvent.presentChampagne(totalOrderSum)
        badge = decemberEvent.assignBadge(calculateTotalBenefitAmount())
    }
}
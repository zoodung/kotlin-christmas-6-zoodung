package christmas.model

import christmas.utils.Constant.CHRISTMAS_DAY
import christmas.utils.Constant.DISCOUNT_THRESHOLD
import christmas.utils.Constant.INITIALIZE_NUMBER

class Customer(private val visitDate: Int, private val orderMenu: List<Pair<String, Int>>) {
    private val decemberEvent = DecemberEvent()
    private val discountHistory = mutableMapOf<DiscountType, Int>()
    private val freebie = decemberEvent.presentChampagne(calculateTotalOrderSum())
    private val badge = decemberEvent.assignBadge(discountHistory.values.sum())

    init {
        DiscountType.entries.forEach {
            discountHistory[it] = INITIALIZE_NUMBER
        }
    }

    fun getDiscountHistory(): List<Pair<DiscountType, Int>> = discountHistory.toList()

    fun getFreebie(): Boolean = freebie

    fun getBadge(): String = badge

    fun sortOrderMenu(): List<Pair<String, Int>> {
        val sortedOrderMenu = orderMenu.sortedBy {
            val menuName = it.first
            enumValues<StoreMenu>().indexOfFirst { menu -> menu.menuName == menuName }
        }

        return sortedOrderMenu
    }

    fun calculateTotalBenefitAmount(): Int {
        if(freebie)
            return discountHistory.values.sum() + StoreMenu.CHAMPAGNE.menuPrice
        return discountHistory.values.sum()
    }

    fun calculateTotalOrderSum(): Int {
        var totalOrderSum = INITIALIZE_NUMBER

        for ((menuName, quantity) in orderMenu) {
            val storeMenu = enumValues<StoreMenu>().first { it.menuName == menuName }
            totalOrderSum += storeMenu.menuPrice * quantity
        }

        return totalOrderSum
    }

    fun applyDecemberEvent() {
        if (calculateTotalOrderSum() > DISCOUNT_THRESHOLD) {
            requestTheDayDiscount()
            requestWeekdayDiscount()
            requestWeekendDiscount()
            requestSpecialDiscount()
        }
    }

    private fun requestTheDayDiscount() {
        if (visitDate <= CHRISTMAS_DAY) {
            val discountAmount = decemberEvent.applyTheDayDiscount(visitDate)
            discountHistory[DiscountType.THE_DAY_DISCOUNT] = discountAmount
        }
    }

    private fun requestWeekdayDiscount() {
        if (visitDate in DecemberCalender.WEEKDAY.dates) {
            val discountAmount = decemberEvent.applyWeekdayDiscount(orderMenu)
            discountHistory[DiscountType.WEEKDAY_DISCOUNT] = discountAmount
        }
    }

    private fun requestWeekendDiscount() {
        if (visitDate in DecemberCalender.WEEKEND.dates) {
            val discountAmount = decemberEvent.applyWeekendDiscount(orderMenu)
            discountHistory[DiscountType.WEEKEND_DISCOUNT] = discountAmount
        }
    }

    private fun requestSpecialDiscount() {
        if (visitDate in DecemberCalender.SPECIAL_DAY.dates) {
            val discountAmount = decemberEvent.applySpecialDiscount()
            discountHistory[DiscountType.SPECIAL_DISCOUNT] = discountAmount
        }
    }
}
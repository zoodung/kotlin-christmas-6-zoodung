package christmas.model

import christmas.utils.Constant.DISCOUNT_THRESHOLD
import christmas.utils.Constant.EMPTY

class Customer(
    private val visitDate: Int,
    private val orderMenu: List<OrderItems>
) {
    private val eventHelper = EventHelper()

    fun getVisitDate(): Int = visitDate

    fun getOrderMenu(): List<OrderItems> = orderMenu

    fun getEventHelper(): EventHelper = eventHelper

    fun calculateTotalOrderSum(): Int {
        var totalOrderSum = EMPTY

        for (item in orderMenu) {
            val storeMenu = enumValues<StoreMenu>().first { menu -> menu.menuName == item.getMenuName() }
            totalOrderSum += storeMenu.menuPrice * item.getQuantity()
        }

        return totalOrderSum
    }

    fun requestApplyDecemberEvent() {
        if (calculateTotalOrderSum() >= DISCOUNT_THRESHOLD)
            eventHelper.applyDecemberEvent(visitDate, orderMenu, calculateTotalOrderSum())
    }
}
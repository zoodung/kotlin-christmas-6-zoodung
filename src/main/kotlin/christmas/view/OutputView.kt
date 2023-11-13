package christmas.view

import christmas.model.DiscountType
import christmas.model.OrderItems
import christmas.model.StoreMenu
import christmas.utils.Constant.BADGE_TITLE_MESSAGE
import christmas.utils.Constant.BENEFIT_AMOUNT_TITLE_MESSAGE
import christmas.utils.Constant.BENEFIT_DETAILS_TITLE_MESSAGE
import christmas.utils.Constant.BENEFIT_RESULT
import christmas.utils.Constant.FREEBIE_EVENT_NAME
import christmas.utils.Constant.EMPTY
import christmas.utils.Constant.ITEMS_RESULT
import christmas.utils.Constant.NONE
import christmas.utils.Constant.ORDER_MENU_TITLE_MESSAGE
import christmas.utils.Constant.PAYMENT_AMOUNT_TITLE_MESSAGE
import christmas.utils.Constant.PRESENT_AMOUNT
import christmas.utils.Constant.PRESENT_MENU_TITLE_MESSAGE
import christmas.utils.Constant.PREVIEW_ANNOUNCE_MESSAGE
import christmas.utils.Constant.START_PLANNER_MESSAGE
import christmas.utils.Constant.TOTAL_AMOUNT_RESULT
import christmas.utils.Constant.TOTAL_ORDER_SUM_TITLE_MESSAGE

class OutputView {
    fun printStartPlanner() {
        println(START_PLANNER_MESSAGE)
    }

    fun printPreviewAnnounce() {
        println(PREVIEW_ANNOUNCE_MESSAGE)
    }

    fun printOrderMenu(orderMenu: List<OrderItems>) {
        println(ORDER_MENU_TITLE_MESSAGE)
        orderMenu.forEach { items ->
            println(ITEMS_RESULT.format(items.getMenuName(), items.getQuantity()))
        }
    }

    fun printTotalOrderPrize(totalOrderSum: Int) {
        println(TOTAL_ORDER_SUM_TITLE_MESSAGE)
        println(TOTAL_AMOUNT_RESULT.format(totalOrderSum))

    }

    fun printFreebieMenu(freebie: Boolean) {
        println(PRESENT_MENU_TITLE_MESSAGE)
        when {
            freebie -> println(ITEMS_RESULT.format(StoreMenu.CHAMPAGNE.menuName, PRESENT_AMOUNT))
            !freebie -> println(NONE)
        }
    }

    fun printBenefitDetails(discountHistory: List<Pair<DiscountType, Int>>, freebie: Boolean) {
        val discountHistoryExist = discountHistory.filter { it.second != EMPTY }

        println(BENEFIT_DETAILS_TITLE_MESSAGE)
        discountHistoryExist.forEach { (discountType, discountAmount) ->
            println(BENEFIT_RESULT.format(discountType.eventName, discountAmount))
        }

        if(freebie)
            println(BENEFIT_RESULT.format(FREEBIE_EVENT_NAME, StoreMenu.CHAMPAGNE.menuPrice))

        if(discountHistoryExist.isEmpty() && !freebie)
            println(NONE)
    }

    fun printBenefitAmount(totalBenefitAmount: Int) {
        println(BENEFIT_AMOUNT_TITLE_MESSAGE)
        println(TOTAL_AMOUNT_RESULT.format(EMPTY - totalBenefitAmount))
    }

    fun printPaymentAmount(totalOrderSum: Int, discountHistory: List<Pair<DiscountType, Int>>) {
        println(PAYMENT_AMOUNT_TITLE_MESSAGE)
        println(TOTAL_AMOUNT_RESULT.format(totalOrderSum - discountHistory.sumOf { it.second }))
    }

    fun printBadge(badge: String) {
        println(BADGE_TITLE_MESSAGE)
        println(badge)
    }
}
package christmas.controller

import christmas.model.Customer
import christmas.model.EventHelper
import christmas.model.OrderItems
import christmas.model.StoreMenu.Companion.sortOrderMenu
import christmas.model.StoreMenu.Companion.splitOrderMenu
import christmas.model.StoreMenu.Companion.splitOrderMenuForValidate
import christmas.utils.Validate.validateOrderMenu
import christmas.utils.Validate.validateVisitDate
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {
    private val input = InputView()
    private val output = OutputView()

    fun run() {
        output.printStartPlanner()
        val customer = Customer(inputVisitDate(), inputOrderMenu())

        customer.requestApplyDecemberEvent()
        previewBenefit(customer, customer.getEventHelper())
    }

    private fun inputVisitDate(): Int {
        return try {
            val visitDateInput = input.readVisitDate()
            validateVisitDate(visitDateInput)
            visitDateInput.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputVisitDate()
        }
    }

    private fun inputOrderMenu(): List<OrderItems> {
        return try {
            val orderMenuInput = input.readOrderMenu()
            validateOrderMenu(splitOrderMenuForValidate(orderMenuInput))
            splitOrderMenu(orderMenuInput)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputOrderMenu()
        }
    }

    private fun previewBenefit(customer: Customer, eventHelper: EventHelper) {
        output.printPreviewAnnounce(customer.getVisitDate())
        output.printOrderMenu(sortOrderMenu(customer.getOrderMenu()))
        output.printTotalOrderPrize(customer.calculateTotalOrderSum())
        output.printFreebieMenu(eventHelper.getFreebie())
        output.printBenefitDetails(eventHelper.getDiscountHistory(), eventHelper.getFreebie())
        output.printBenefitAmount(eventHelper.calculateTotalBenefitAmount())
        output.printPaymentAmount(customer.calculateTotalOrderSum(), eventHelper.getDiscountHistory())
        output.printBadge(eventHelper.getBadge())
    }
}
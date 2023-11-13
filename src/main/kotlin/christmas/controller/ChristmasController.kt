package christmas.controller

import christmas.model.Customered
import christmas.model.Customer2
import christmas.model.OrderItems
import christmas.model.StoreMenu
import christmas.model.StoreMenu.Companion.sortOrderMenu
import christmas.utils.Validate.validateOrderMenu
import christmas.utils.Validate.validateVisitDate
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {
    private val input = InputView()
    private val output = OutputView()

    fun run() {
        output.printStartPlanner()
        val customer = Customer2(inputVisitDate(), inputOrderMenu())
        //customer.applyDecemberEvent()
        //previewBenefit(customer)
    }

    private fun inputVisitDate(): Int {
        return try {
            val visitDateInput = input.requestInputVisitDate()
            validateVisitDate(visitDateInput)
            visitDateInput.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputVisitDate()
        }
    }


    private fun inputOrderMenu(): List<OrderItems> {
        return try {
            val orderMenuInput = input.requestInputMenu()
            validateOrderMenu(StoreMenu.splitOrderMenuForValidate(orderMenuInput))
            StoreMenu.splitOrderMenu(orderMenuInput)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputOrderMenu()
        }
    }

    private fun previewBenefit(customer: Customered) {
        output.printOrderMenu(sortOrderMenu(customer.getOrderMenu()))
        output.printTotalOrderPrize(customer.calculateTotalOrderSum())
        output.printFreebieMenu(customer.getFreebie())
        output.printBenefitDetails(customer.getDiscountHistory(), customer.getFreebie())
        output.printBenefitAmount(customer.calculateTotalBenefitAmount())
        output.printPaymentAmount(customer.calculateTotalOrderSum(), customer.getDiscountHistory())
        output.printBadge(customer.getBadge())
    }
}
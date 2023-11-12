package christmas.controller

import christmas.model.Customer
import christmas.model.StoreMenu
import christmas.utils.Validate.validateOrderMenuAfterSplit
import christmas.utils.Validate.validateOrderMenuBeforeSplit
import christmas.utils.Validate.validateVisitDate
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {
    private val input = InputView()
    private val output = OutputView()

    fun run() {
        output.printStartPlanner()
        val customer = Customer(inputVisitDate(), inputOrderMenu())
        customer.applyDecemberEvent()
        previewBenefit(customer)
    }

    private fun inputVisitDate(): Int {
        return try {
            val visitDate = input.requestInputVisitDate()
            validateVisitDate(visitDate)
            visitDate.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputVisitDate()
        }
    }

    private fun inputOrderMenu(): List<Pair<String, Int>> {
        return try {
            val orderMenu = input.requestInputMenu()
            validateOrderMenuBeforeSplit(orderMenu)
            val splitOrderMenu = StoreMenu.splitOrderItems(orderMenu)
            validateOrderMenuAfterSplit(splitOrderMenu)
            splitOrderMenu.map { (name, quantity) -> name to quantity.toInt() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputOrderMenu()
        }
    }

    private fun previewBenefit(customer: Customer) {
        output.printOrderMenu(customer.sortOrderMenu())
        output.printTotalOrderPrize(customer.calculateTotalOrderSum())
        output.printFreebieMenu(customer.getFreebie())
        output.printBenefitDetails(customer.getDiscountHistory(), customer.getFreebie())
        output.printBenefitAmount(customer.calculateTotalBenefitAmount())
        output.printPaymentAmount(customer.calculateTotalOrderSum(), customer.getDiscountHistory())
        output.printBadge(customer.getBadge())
    }
}
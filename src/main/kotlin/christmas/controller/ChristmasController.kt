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
        startPlanner()
        val customer = Customer(inputVisitDate(), inputOrderMenu())
    }

    private fun startPlanner() {
        output.printStartPlanner()
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
}
package christmas.controller

import christmas.model.Customer
import christmas.utils.Validate
import christmas.utils.Validate.validateVisitDate
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {
    private val input = InputView()
    private val output = OutputView()

    fun run() {
        startPlanner()
        val customer = Customer(inputVisitDate())
    }
    private fun startPlanner() {
        output.printStartPlanner()
    }

    private fun inputVisitDate(): Int {
        try {
            val visitDate = input.requestInputVisitDate()
            validateVisitDate(visitDate)
            return visitDate.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return inputVisitDate()
        }
    }
}
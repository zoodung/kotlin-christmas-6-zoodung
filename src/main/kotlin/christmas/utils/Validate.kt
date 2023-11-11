package christmas.utils

import christmas.utils.Constant.ERROR_MESSAGE_INPUT_VISIT_DATE
import christmas.utils.Constant.NUMERIC_REGEX
import christmas.utils.Constant.VISIT_DATE_MAX
import christmas.utils.Constant.VISIT_DATE_MIN

object Validate {
    fun validateVisitDate(visitDate: String) {
        checkVisitDateNumeric(visitDate)
        checkVisitDateRange(visitDate)
    }

    private fun checkVisitDateNumeric(visitDate: String) {
        require(visitDate.matches(Regex(NUMERIC_REGEX))) { ERROR_MESSAGE_INPUT_VISIT_DATE }
    }

    private fun checkVisitDateRange(visitDate: String) {
        require(visitDate.toInt() in VISIT_DATE_MIN..VISIT_DATE_MAX) {
            ERROR_MESSAGE_INPUT_VISIT_DATE
        }
    }
}
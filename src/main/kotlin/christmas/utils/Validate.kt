package christmas.utils

import christmas.model.StoreMenu
import christmas.utils.Constant.COMMA
import christmas.utils.Constant.DUPLICATION_EMPTY_SIZE
import christmas.utils.Constant.ERROR_MESSAGE_INPUT_MENU
import christmas.utils.Constant.ERROR_MESSAGE_INPUT_VISIT_DATE
import christmas.utils.Constant.HYPHEN
import christmas.utils.Constant.INITIALIZE_NUMBER
import christmas.utils.Constant.NUMERIC_REGEX
import christmas.utils.Constant.QUANTITY_MAXIMUM
import christmas.utils.Constant.QUANTITY_MINIMUM
import christmas.utils.Constant.VISIT_DATE_MAX
import christmas.utils.Constant.VISIT_DATE_MIN

object Validate {
    fun validateVisitDate(visitDate: String) {
        checkVisitDateNumeric(visitDate)
        checkVisitDateRange(visitDate)
    }

    private fun checkVisitDateNumeric(visitDate: String) {
        require(visitDate.matches(Regex(NUMERIC_REGEX))) {
            ERROR_MESSAGE_INPUT_VISIT_DATE
        }
    }

    private fun checkVisitDateRange(visitDate: String) {
        require(visitDate.toInt() in VISIT_DATE_MIN..VISIT_DATE_MAX) {
            ERROR_MESSAGE_INPUT_VISIT_DATE
        }
    }

    fun validateOrderMenuBeforeSplit(orderMenu: String) {
        checkOrderMenuBlank(orderMenu)
        checkOrderMenuForm(orderMenu)
    }

    private fun checkOrderMenuBlank(orderMenu: String) {
        require(orderMenu.isNotBlank()) {
            ERROR_MESSAGE_INPUT_MENU
        }
    }

    private fun checkOrderMenuForm(orderMenu: String) {
        orderMenu.split(COMMA).map {
            menuItem -> val parts = menuItem.split(HYPHEN)
            require(parts.size == 2) {
                ERROR_MESSAGE_INPUT_MENU
            }
        }
    }

    fun validateOrderMenuAfterSplit(orderMenu: List<Pair<String, String>>) {
        var totalQuantity = INITIALIZE_NUMBER

        for ((menuName, quantity) in orderMenu) {
            checkOrderMenuName(menuName)
            checkOrderMenuQuantityType(quantity)
            checkOrderMenuQuantityMinimum(quantity.toInt())
            totalQuantity += quantity.toInt()
        }

        checkOrderMenuDuplicate(orderMenu.map { it.first })
        checkOrderMenuOnlyDrink(orderMenu.map { it.first })
        checkOrderMenuTotalQuantity(totalQuantity)
    }

    private fun checkOrderMenuName(menuName: String) {
        require(menuName in StoreMenu.entries.map { it.menuName }) {
            ERROR_MESSAGE_INPUT_MENU
        }
    }

    private fun checkOrderMenuQuantityType(quantity: String) {
        require(quantity.matches(Regex(NUMERIC_REGEX))) {
            ERROR_MESSAGE_INPUT_MENU
        }
    }

    private fun checkOrderMenuQuantityMinimum(totalQuantity: Int) {
        require(totalQuantity >= QUANTITY_MINIMUM) {
            ERROR_MESSAGE_INPUT_MENU
        }
    }

    private fun checkOrderMenuTotalQuantity(totalQuantity: Int) {
        require(totalQuantity <= QUANTITY_MAXIMUM) {
            ERROR_MESSAGE_INPUT_MENU
        }
    }

    private fun checkOrderMenuDuplicate(menuNames: List<String>) {
        val duplicateMenu = menuNames.groupBy { it }
            .filter { it.value.size > DUPLICATION_EMPTY_SIZE }
            .keys
        require(duplicateMenu.isEmpty()) {
            ERROR_MESSAGE_INPUT_MENU
        }
    }

    private fun checkOrderMenuOnlyDrink(menuNames: List<String>) {
        val drinks = setOf(StoreMenu.ZERO_COKE.menuName, StoreMenu.RED_WINE.menuName, StoreMenu.CHAMPAGNE.menuName)
        val filteredMenuNames = menuNames.filterNot { it in drinks }

        require(filteredMenuNames.isNotEmpty()) {
            ERROR_MESSAGE_INPUT_MENU
        }
    }
}
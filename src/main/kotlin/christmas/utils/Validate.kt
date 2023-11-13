package christmas.utils

import christmas.model.StoreMenu
import christmas.utils.Constant.ERROR_MESSAGE_INPUT_MENU
import christmas.utils.Constant.ERROR_MESSAGE_INPUT_VISIT_DATE
import christmas.utils.Constant.FIRST_INDEX
import christmas.utils.Constant.NUMERIC_REGEX
import christmas.utils.Constant.ORDER_ITEMS_SIZE
import christmas.utils.Constant.QUANTITY_MAXIMUM
import christmas.utils.Constant.QUANTITY_MINIMUM
import christmas.utils.Constant.SECOND_INDEX
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
        require(visitDate.toInt() in VISIT_DATE_MIN..VISIT_DATE_MAX) { ERROR_MESSAGE_INPUT_VISIT_DATE }
    }

    fun validateOrderMenu(splitOrderMenu: List<List<String>>) {
        checkOrderMenuBlank(splitOrderMenu)
        checkOrderMenuForm(splitOrderMenu)

        for (orderMenuItems in splitOrderMenu) {
            checkOrderMenuName(orderMenuItems[FIRST_INDEX])
            checkOrderMenuQuantityType(orderMenuItems[SECOND_INDEX])
            checkOrderMenuQuantityMinimum(orderMenuItems[SECOND_INDEX].toInt())
        }

        checkOrderMenuTotalQuantity(splitOrderMenu.map { it[SECOND_INDEX] })
        checkOrderMenuDuplicate(splitOrderMenu.map { it[FIRST_INDEX] })
        checkOrderMenuOnlyDrink(splitOrderMenu.map { it[FIRST_INDEX] })
    }

    private fun checkOrderMenuBlank(splitOrderMenu: List<List<String>>) {
        require(splitOrderMenu.isNotEmpty()) { ERROR_MESSAGE_INPUT_MENU }
    }

    private fun checkOrderMenuForm(splitOrderMenu: List<List<String>>) {
        require(splitOrderMenu.all { it.size == ORDER_ITEMS_SIZE }) { ERROR_MESSAGE_INPUT_MENU }
    }

    private fun checkOrderMenuName(menuName: String) {
        require(menuName in StoreMenu.entries.map { it.menuName }) { ERROR_MESSAGE_INPUT_MENU }
    }

    private fun checkOrderMenuQuantityType(quantity: String) {
        require(quantity.matches(Regex(NUMERIC_REGEX))) { ERROR_MESSAGE_INPUT_MENU }
    }

    private fun checkOrderMenuQuantityMinimum(totalQuantity: Int) {
        require(totalQuantity >= QUANTITY_MINIMUM) { ERROR_MESSAGE_INPUT_MENU }
    }

    private fun checkOrderMenuTotalQuantity(quantityGroup: List<String>) {
        val totalQuantity = quantityGroup.sumOf { it.toInt() }

        require(totalQuantity <= QUANTITY_MAXIMUM) { ERROR_MESSAGE_INPUT_MENU }
    }

    private fun checkOrderMenuDuplicate(menuNameGroup: List<String>) {
        val distinctMenuNameGroup = menuNameGroup.toSet()

        require(menuNameGroup.size == distinctMenuNameGroup.size) { ERROR_MESSAGE_INPUT_MENU }
    }

    private fun checkOrderMenuOnlyDrink(menuNames: List<String>) {
        val drinksGroup = setOf(StoreMenu.ZERO_COKE.menuName, StoreMenu.RED_WINE.menuName, StoreMenu.CHAMPAGNE.menuName)
        val filteredMenuNames = menuNames.filterNot { it in drinksGroup }

        require(filteredMenuNames.isNotEmpty()) { ERROR_MESSAGE_INPUT_MENU }
    }
}
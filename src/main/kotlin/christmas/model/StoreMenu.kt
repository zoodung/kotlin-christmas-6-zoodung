package christmas.model

import christmas.utils.Constant.COMMA
import christmas.utils.Constant.FIRST_INDEX
import christmas.utils.Constant.HYPHEN
import christmas.utils.Constant.SECOND_INDEX

enum class StoreMenu(val menuName: String, val menuPrice: Int) {
    /* Appetizer Menu */
    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000),

    /* Main Menu */
    T_BONE_STEAK("티본스테이크", 55_000),
    BBQ_RIBS("바비큐립", 54_000),
    SEAFOOD_PASTA("해산물파스타", 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000),

    /* Dessert Menu */
    CHOCO_CAKE("초코케이크", 15_000),
    ICE_CREAM("아이스크림", 5_000),

    /* Drink Menu */
    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    companion object {
        fun splitOrderMenuForValidate(orderMenuInput: String): List<List<String>> {
            return orderMenuInput.split(COMMA).map {
                it.split(HYPHEN).map { part -> part.trim() }
            }
        }

        fun splitOrderMenu(orderMenuInput: String): List<OrderItems> {
            return splitOrderMenuForValidate(orderMenuInput).map {
                val menuName = it[FIRST_INDEX]
                val quantity = it[SECOND_INDEX].toInt()

                OrderItems(menuName, quantity)
            }
        }

        fun sortOrderMenu(orderMenu: List<OrderItems>): List<OrderItems> =
            orderMenu.sortedBy { enumValues<StoreMenu>().indexOfFirst { menu -> menu.menuName == it.getMenuName() } }
    }
}
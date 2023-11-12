package christmas.model

import christmas.utils.Constant.COMMA
import christmas.utils.Constant.FIRST_INDEX
import christmas.utils.Constant.HYPHEN
import christmas.utils.Constant.INITIALIZE_NUMBER
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
        fun splitOrderItems(menu: String): List<Pair<String, String>> {
            val orderItems = menu.split(COMMA).map { menuItem ->
                val parts = menuItem.split(HYPHEN)
                val name = parts[FIRST_INDEX].trim()
                val quantity = parts[SECOND_INDEX].trim()
                name to quantity
            }
            return orderItems
        }
    }
}